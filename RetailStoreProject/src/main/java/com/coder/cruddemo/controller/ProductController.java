package com.coder.cruddemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.cruddemo.entity.Product;
import com.coder.cruddemo.entity.ProductDTO;
import com.coder.cruddemo.entity.ShoppingBill;
import com.coder.cruddemo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		log.info("Inside addProduct");
		Product prod = productService.addProduct(product);
		return new ResponseEntity<>(prod, HttpStatus.CREATED);
	}

	@GetMapping("/fetchbyid/{productId}")
	public ResponseEntity<Product> fetchProductDetails(@PathVariable("productId") Long productIdL) {
		log.info("Inside fetchProductDetails");
		Product product = productService.findProductById(productIdL);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/fetch/allproducts")
	public ResponseEntity<List<Product>> fetchAllProducts() {
		log.info("Inside fetchAllProducts");
		List<Product> productList = productService.findProducts();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@DeleteMapping("/deleteproduct/{productId}")
	public ResponseEntity<Void> deleteProductById(@PathVariable("productId") Long productIdL) {
		log.info("Inside deleteProductById");
		productService.deleteProduct(productIdL);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@PostMapping("/generate/bill")
	public ResponseEntity<ShoppingBill> generateShoppingBill(@RequestBody ProductDTO productDTO) {
		log.info("Inside getShoppingBill");
		ShoppingBill productList = productService.generateBill(productDTO);
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@GetMapping("/download/bill")
	public ResponseEntity<ShoppingBill> getShoppingBill() {
		log.info("Inside getShoppingBill");
		ShoppingBill productList = productService.downloadBill();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

}
