package com.multibite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multibite.model.OrderHistory;

@Repository
public interface OrderHistoryRepo extends JpaRepository<OrderHistory, Integer> {

	public List<OrderHistory> findByCustomerId(Integer customerId);

}
