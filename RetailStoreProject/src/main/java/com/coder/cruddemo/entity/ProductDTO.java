package com.coder.cruddemo.entity;

import java.util.List;

public class ProductDTO {
	public Long mobileNumber;
	List<Long> listOfProductIds;

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<Long> getListOfProductIds() {
		return listOfProductIds;
	}

	public void setListOfProductIds(List<Long> listOfProductIds) {
		this.listOfProductIds = listOfProductIds;
	}
}
