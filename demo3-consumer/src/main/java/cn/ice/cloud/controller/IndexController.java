package cn.ice.cloud.controller;

import cn.ice.cloud.dto.ProductCommentDto;
import cn.ice.cloud.dto.UserDto;
import cn.ice.cloud.entity.Product;
import cn.ice.cloud.entity.ProductComment;
import cn.ice.cloud.repo.ProductCommentRepository;
import cn.ice.cloud.repo.ProductRepository;
import cn.ice.cloud.service.ProductService;
import cn.ice.cloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class IndexController {

    protected Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Value("${foo}")
    private String foo;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductCommentRepository productCommentRepository;

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    @RequestMapping(value = "/foo")
    public String foo() {
        return foo;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list(){
        return productService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product detail(@PathVariable Long id){
        return productService.getOne(id);
    }

    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    @Transactional
    public List<ProductCommentDto> comments(@PathVariable Long id){
        List<ProductComment> commentList = productCommentRepository.findByProductIdOrderByCreated(id);
        if (null == commentList || commentList.isEmpty()) {
            return Collections.emptyList();
        }
        List<ProductCommentDto> results = commentList.stream().map((comment) -> {
            ProductCommentDto dto = new ProductCommentDto(comment);
            dto.setProduct(productService.getOne(comment.getProductId()));
            dto.setAuthor(userService.load(comment.getAuthorId()));
            return dto;
        }).collect(Collectors.toList());
        return results;
    }

    /**
     * This method had been replaced by Feign component automatically
     * Reference UserService
     * @param userId
     * @return
     */
    @Deprecated
    protected UserDto loadUser(Long userId){
        ResponseEntity<UserDto> userDto = restTemplate.getForEntity("http://EUREKA-PROVIDER-SERVER/user/{id}", UserDto.class, userId);
        if (userDto != null) {
            logger.debug("I came from server: {}", userDto.getBody().getId());
        }
        return userDto.getBody();
    }
}
