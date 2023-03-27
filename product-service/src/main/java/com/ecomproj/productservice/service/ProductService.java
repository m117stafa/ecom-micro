package com.ecomproj.productservice.service;

import com.ecomproj.productservice.dto.ProductRequest;
import com.ecomproj.productservice.dto.ProductResponse;
import com.ecomproj.productservice.model.Product;
import com.ecomproj.productservice.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepo productRepo;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .productDescription(productRequest.getProductDescription())
                .productPrice(productRequest.getProductPrice())
                .productRating(productRequest.getProductRating())
                .build();
        productRepo.save(product);
        log.info("Product {} is saved successfully",product.getId());

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .productRating(product.getProductRating())
                .build();
    }

}
