package com.ecomproj.productservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document(value = "product")
public class Product {

    @Id
    private String id;
    private String productName;
    private String productDescription;
    private double productPrice;
    private int productRating;


}
