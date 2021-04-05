package com.ecommerce.order.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.OrderService;
import com.ecommerce.order.util.ErrorResponse;
import com.ecommerce.order.util.ResourceNotCreated;
import com.ecommerce.order.util.ResourceNotFoundError;

@RestController
@RequestMapping(value = "/eCommerce")
public class OrderController
{
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/{orderId}")
	public  ResponseEntity<?> findOrderById(@PathVariable("orderId") long orderId)
	{
		Optional<Order> order = orderService.findOrderById(orderId);
		if(order.isPresent())
			return new ResponseEntity<>(order, HttpStatus.OK);
		else
			throw new ResourceNotFoundError("The ordeId "+orderId+" does not exist");
	}
	
	@PostMapping("/order/createOrder")
	public Order createOrder(@RequestBody Order order)
	{
		Order orderRes =  orderService.createOrder(order);
		if(orderRes!=null)
			return orderRes;
		else
			throw new ResourceNotCreated("Order is not created");
	}
	
	@PutMapping("/order/cancelOrder")
	public Order cancelOrder(@RequestBody Order order)
	{
		Order orderRes = orderService.cancelOrder(order);
		if(orderRes!=null)
			return orderRes;
		else
			throw new ResourceNotCreated("Order is not canceled");
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(ResourceNotCreated exc)
	{	
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.NO_CONTENT.value());
		error.setMessage(exc.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NO_CONTENT);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundError exc)
	{	
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
}
