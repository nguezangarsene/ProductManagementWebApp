package edu.mum.cs.cs425.labassignment8.demo.repository;

import edu.mum.cs.cs425.labassignment8.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface IProductRepository extends JpaRepository<Product,Long> {
}
