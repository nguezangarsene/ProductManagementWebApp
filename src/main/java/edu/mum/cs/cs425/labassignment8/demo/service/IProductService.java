package edu.mum.cs.cs425.labassignment8.demo.service;

import edu.mum.cs.cs425.labassignment8.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product save(Product product);
    Product findById(Long pid);
}
