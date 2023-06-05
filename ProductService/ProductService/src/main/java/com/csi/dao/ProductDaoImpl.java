package com.csi.dao;

import com.csi.model.Product;
import com.csi.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductDaoImpl {

    @Autowired
    ProductRepo productRepoImpl;

    public Product saveData(Product product) {
        return  productRepoImpl.save(product);
    }

    public Optional<Product> getDataByID(long productId) {
        return productRepoImpl.findById(productId);
    }
}
