package com.coder.cruddemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.cruddemo.entity.Product;
import com.coder.cruddemo.entity.ProductDTO;
import com.coder.cruddemo.entity.ShoppingBill;
import com.coder.cruddemo.entity.User;
import com.coder.cruddemo.repository.ProductRepository;
import com.coder.cruddemo.repository.ShoppingBillRepository;

@Service
public class ProductServiceImpl implements ProductService {

	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	private ShoppingBillRepository shoppingBillRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(Long productIdL) {
		  Optional<Product> product =  productRepository.findById(productIdL);
	        if(product.isPresent()){
	            return product.get();
	        }else {
	        	return null;
	        }
	}

	@Override
	public List<Product> findProducts() {
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(Long productIdL) {
		productRepository.deleteById(productIdL);
	}

	@Override
	public ShoppingBill generateBill(ProductDTO productDTO) {
		Double discount = 0.0;
		ShoppingBill shoppingBill = new ShoppingBill();
		Double nonGroceryPrice = calculateNonGroceryItemsBill(productDTO);
		Double groceryPrice = calculateGroceryItemsBill(productDTO);
		
		Long mobNo = productDTO.getMobileNumber();
		User user = userServiceImpl.findUserById(mobNo);
		String userType = user.getUserType();

		if (userType.equalsIgnoreCase("Employee"))
			discount = 30.00;
		if (userType.equalsIgnoreCase("Affiliate"))
			discount = 10.00;
		if (userType.equalsIgnoreCase("Customer") && Integer.valueOf(user.getUserDuration()) >= 2) {
			discount = 5.00;
		}
		
		Double totalBillWithDiscount = calculateTotalBillAmountWithDiscount(shoppingBill,groceryPrice, nonGroceryPrice, discount);
		
		shoppingBill.setMobileNumber(mobNo);
		shoppingBill.setCustomerName(user.getUserName());
		shoppingBill.setDiscountForUserType(discount);
		shoppingBill.setTotalBillAmountWithDiscount(totalBillWithDiscount);
		shoppingBillRepository.save(shoppingBill);
		return shoppingBill;

	}

	public Double calculateGroceryItemsBill(ProductDTO productDTO) {
		List<Product> listOfGroceryItems = productDTO.getListOfProductIds().stream().map(element -> { 
			return productRepository.findById(element).get();
		}).collect(Collectors.toList());
		return listOfGroceryItems.stream().filter(p -> p.getPtype().equalsIgnoreCase("Grocery"))
				.mapToDouble(x -> x.getPrice()).sum();
	}

	public Double calculateNonGroceryItemsBill( ProductDTO productDTO) {
		List<Product> listOfNonGroceryItems = productDTO.getListOfProductIds().stream().map(element -> {
			return productRepository.findById(element).get();
		}).collect(Collectors.toList());
		 return listOfNonGroceryItems.stream().filter(p -> p.getPtype().equalsIgnoreCase("NA"))
				.mapToDouble(x -> x.getPrice()).sum();
		 
	}

	public Double calculateTotalBillAmountWithDiscount(ShoppingBill shoppingBill, Double groceryPrice, Double nonGroceryPrice, Double discount) {
		Double billAmountWithDiscount;
		Double discountedAmount = (nonGroceryPrice * discount) / 100;
		Double netPriceNonGroceryPrice = nonGroceryPrice - discountedAmount;
		Double totalBillAmount = netPriceNonGroceryPrice + groceryPrice;
		if (totalBillAmount > 100) {
			Double factor = totalBillAmount / 100;
			Double additionalDiscount = factor * 5;
			shoppingBill.setAdditionalDiscount(additionalDiscount);
			billAmountWithDiscount = totalBillAmount - additionalDiscount;

		} else {
			billAmountWithDiscount = totalBillAmount;
		}
		return billAmountWithDiscount;
	}

	@Override
	public ShoppingBill downloadBill() {
		return null;
	}

}
