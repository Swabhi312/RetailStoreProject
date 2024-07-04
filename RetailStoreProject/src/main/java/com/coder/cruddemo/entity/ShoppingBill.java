package com.coder.cruddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bill")
public class ShoppingBill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long billId;
	private String customerName;
	private long mobileNumber;
	private double discountForUserType;
	private double additionalDiscount;
	private double totalBillAmountWithDiscount;

	public ShoppingBill() {
		super();
	}

	public ShoppingBill(long billId, String customerName, long mobileNumber, double discountForUserType,
			 double additionalDiscount, double totalBillAmountWithDiscount) {
		super();
		this.billId = billId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.discountForUserType = discountForUserType;
		this.additionalDiscount = additionalDiscount;
		this.totalBillAmountWithDiscount = totalBillAmountWithDiscount;
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public double getDiscountForUserType() {
		return discountForUserType;
	}

	public void setDiscountForUserType(double discountForUserType) {
		this.discountForUserType = discountForUserType;
	}

	public double getAdditionalDiscount() {
		return additionalDiscount;
	}

	public void setAdditionalDiscount(double additionalDiscount) {
		this.additionalDiscount = additionalDiscount;
	}

	public double getTotalBillAmountWithDiscount() {
		return totalBillAmountWithDiscount;
	}

	public void setTotalBillAmountWithDiscount(double totalBillAmountWithDiscount) {
		this.totalBillAmountWithDiscount = totalBillAmountWithDiscount;
	}

}
