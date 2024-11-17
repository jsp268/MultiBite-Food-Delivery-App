package com.multibite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multibite.exception.AdminException;
import com.multibite.exception.DeliveryPersonnelException;
import com.multibite.exception.LoginException;
import com.multibite.exception.OrderDetailsException;
import com.multibite.model.DeliveryPersonnel;
import com.multibite.model.Login;
import com.multibite.model.OrderDetails;
import com.multibite.model.UpdateOrderDTO;
import com.multibite.repository.OrderDetailsRepo;
import com.multibite.service.DeliveryPersonnelService;
import com.multibite.service.LoginService;

@RestController
@RequestMapping("/deliverypersonnels")
public class DeliveryPersonnelController {

	@Autowired
	private DeliveryPersonnelService deliverypersonnelService;

	@Autowired
	private OrderDetailsRepo orderRepo;
	
	@PostMapping("/add")
	public ResponseEntity<DeliveryPersonnel> addDeliveryPersonnel(@RequestBody DeliveryPersonnel deliverypersonnel) throws DeliveryPersonnelException {
		DeliveryPersonnel returnDeliveryPersonnel = deliverypersonnelService.addDeliveryPersonnel(deliverypersonnel);
		return new ResponseEntity<DeliveryPersonnel>(returnDeliveryPersonnel, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<DeliveryPersonnel> updateDeliveryPersonnel(@RequestParam(required = false) String key,
			@RequestBody DeliveryPersonnel deliverypersonnel) throws DeliveryPersonnelException, LoginException {
		DeliveryPersonnel returnDeliveryPersonnel = deliverypersonnelService.updateDeliveryPersonnel(key, deliverypersonnel);
		return new ResponseEntity<DeliveryPersonnel>(returnDeliveryPersonnel, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<DeliveryPersonnel> deleteDeliveryPersonnelById(@RequestParam(required = false) String key,
			@PathVariable("id") Integer deliverypersonnelId) throws DeliveryPersonnelException, LoginException {
		DeliveryPersonnel deliverypersonnel = deliverypersonnelService.removeDeliveryPersonnelById(key, deliverypersonnelId);
		return new ResponseEntity<DeliveryPersonnel>(deliverypersonnel, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<DeliveryPersonnel> deleteDeliveryPersonnel(@RequestParam(required = false) String key,
			@RequestBody DeliveryPersonnel deliverypersonnel) throws DeliveryPersonnelException, LoginException {
		DeliveryPersonnel resDeliveryPersonnel = deliverypersonnelService.removeDeliveryPersonnel(key, deliverypersonnel);
		return new ResponseEntity<DeliveryPersonnel>(resDeliveryPersonnel, HttpStatus.OK);
	}

	@GetMapping("/all/{id}")
	public ResponseEntity<DeliveryPersonnel> viewCutomer(@RequestParam(required = false) String key,
			@PathVariable("id") Integer id) throws DeliveryPersonnelException, LoginException {
		DeliveryPersonnel deliverypersonnel = deliverypersonnelService.viewDeliveryPersonnel(key, id);
		return new ResponseEntity<DeliveryPersonnel>(deliverypersonnel, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<DeliveryPersonnel>> viewAllDeliveryPersonnels(@RequestParam(required = false) String key)
			throws DeliveryPersonnelException, LoginException {
		List<DeliveryPersonnel> deliverypersonnels = deliverypersonnelService.viewAllDeliveryPersonnels(key);
		return new ResponseEntity<List<DeliveryPersonnel>>(deliverypersonnels, HttpStatus.OK);
	}
    @GetMapping("/orders")
	public ResponseEntity<Object> viewAllOrders() throws AdminException {
		List<OrderDetails> orders = orderRepo.findAll(); // Fetch all orders
		return new ResponseEntity<Object>(orders, HttpStatus.OK);
	}
    
    @PutMapping("/updateorder")
	public ResponseEntity<OrderDetails> updateDeliveryPersonnelOrder(@RequestParam(required = false) String key,
			@RequestBody UpdateOrderDTO updateorderdto ) throws DeliveryPersonnelException, LoginException, OrderDetailsException {
		OrderDetails returnupdateorderdto = deliverypersonnelService.updateDeliveryPersonnelOrder(key, updateorderdto);
		return new ResponseEntity<OrderDetails>(returnupdateorderdto, HttpStatus.OK);
	}
    
    @GetMapping("/toggleAvailability/{id}")
	public ResponseEntity<DeliveryPersonnel> toggleAvailabilityStatus(@RequestParam(required = false) String key,
			@PathVariable("id") Integer id) throws DeliveryPersonnelException, LoginException {
		DeliveryPersonnel deliverypersonnel = deliverypersonnelService.toggleAvailabilityStatus(key, id);
		return new ResponseEntity<DeliveryPersonnel>(deliverypersonnel, HttpStatus.OK);
	}
    
}
