package edu.mum.cs.cs425.labassignment8.demo.service.impl;

import edu.mum.cs.cs425.labassignment8.demo.model.Product;
import edu.mum.cs.cs425.labassignment8.demo.repository.IProductRepository;
import edu.mum.cs.cs425.labassignment8.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService implements IProductService {

    private IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll(){
        return productRepository.findAll(Sort.by("productNumber"));
    }

    @Override
    public Product save(Product product){
        return productRepository.save(product);
    }
    @Override
    public Product findById(Long productId){
        return productRepository.findById(productId).orElse(null);
    }



}
