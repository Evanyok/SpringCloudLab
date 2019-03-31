package cn.ice.cloud.service.impl;

import cn.ice.cloud.dto.UserDto;
import cn.ice.cloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Commented codes are using Hystrix directly
//@Service
@Component
public class UserServiceImpl implements UserService {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Override
//    @HystrixCommand(fallbackMethod = "findAllFallback")
//    public List<UserDto> findAll() {
//        UserDto[] userDtos = restTemplate.getForObject("http://EUREKA-PROVIDER-SERVER/user/", UserDto[].class);
//        return Arrays.asList(userDtos);
//    }
//
//    @Override
//    @HystrixCommand(fallbackMethod = "loadFallback")
//    public UserDto load(Long id) {
//        return restTemplate.getForEntity("http://EUREKA-PROVIDER-SERVER/user/" + id, UserDto.class).getBody();
//    }


    @Override
    public List<UserDto> findAll() {
        return findAllFallback();
    }

    @Override
    public UserDto load(Long id) {
        return loadFallback(id);
    }

    protected List<UserDto> findAllFallback(){
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto(1L, "AB_Static", "/path/avatar/AB.png"));
        return userDtos;
    }

    protected UserDto loadFallback(Long id){
        return new UserDto(id, "Anonymous", "default.png");
    }
}
