package com.coder.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coder.cruddemo.entity.ShoppingBill;

@Repository
public interface ShoppingBillRepository extends JpaRepository<ShoppingBill, Long> {
      
}

