package edu.mum.cs.cs425.labassignment8.demo.model;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId")
    private Long productId;

    @Column(name = "ProductNumber", unique = true, nullable = false)
    @NotNull(message = "*Enter a product Number")
    private Long productNumber;

    @Column(name = "Name", nullable = false)
    @NotNull(message = "*Enter a product Name")
    @NotBlank(message = "*Enter product name")
    private String name;

    @Column(name = "UnitPrice", nullable = false)
    @NotNull(message = "Unit Price is required")
    @NumberFormat(pattern = "#,###.##")
    private Float unitPrice;

    @Column(name = "DateMfd", nullable = false)
    @NotNull(message = "Date Manufactured is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateMfd;

    public Product(Long productId, Long productNumber, String name, Float unirPrice, LocalDate dateMfd) {
        this.productId = productId;
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unirPrice;
        this.dateMfd = dateMfd;
    }
    public Product(){

    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice){
        this.unitPrice = unitPrice;
    }

    public LocalDate getDateMfd() {
        return dateMfd;
    }

    public void setDateMfd(LocalDate dateMfd) {
        this.dateMfd = dateMfd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) &&
                Objects.equals(productNumber, product.productNumber) &&
                Objects.equals(name, product.name) &&
                Objects.equals(unitPrice, product.unitPrice) &&
                Objects.equals(dateMfd, product.dateMfd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productNumber, name, unitPrice, dateMfd);
    }

    @Override
    public String toString(){
        return "Product{" +
                "productId=" + productId +
                ", productNumber=" + productNumber +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", dateMfd=" + dateMfd +
                '}';
    }
}
