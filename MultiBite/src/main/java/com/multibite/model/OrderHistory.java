package com.multibite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderHistoryId;

	@NotNull(message = "Customer id required")
	private Integer customerId;

	@OneToOne(targetEntity = Bill.class)
	private Bill bill;

	public Integer getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(Integer orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
