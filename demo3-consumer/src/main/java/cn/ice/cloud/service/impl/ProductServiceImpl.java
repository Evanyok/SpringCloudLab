package cn.ice.cloud.service.impl;

import cn.ice.cloud.entity.Product;
import cn.ice.cloud.repo.ProductRepository;
import cn.ice.cloud.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getOne(Long id) {
        Product product = new Product();
        BeanUtils.copyProperties(productRepository.getOne(id), product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
