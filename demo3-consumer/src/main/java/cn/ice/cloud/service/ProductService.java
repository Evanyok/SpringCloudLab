package cn.ice.cloud.service;

import cn.ice.cloud.entity.Product;

import java.util.List;

public interface ProductService {
    Product getOne(Long id);

    List<Product> findAll();
}
