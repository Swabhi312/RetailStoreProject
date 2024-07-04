package com.coder.cruddemo.service;

import java.util.List;

import com.coder.cruddemo.entity.Product;
import com.coder.cruddemo.entity.ProductDTO;
import com.coder.cruddemo.entity.ShoppingBill;

public interface ProductService {

	public Product addProduct(Product product) ;

	public List<Product> findProducts();

	public Product findProductById(Long productIdL);

	public void deleteProduct(Long productIdL);

	public ShoppingBill generateBill(ProductDTO productDTO);

	public ShoppingBill downloadBill();
}
