package com.springboot;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;


@RestController
public class CustomerController {
	@ApiOperation(value = " get the Customer By Cid", response = double.class, notes = "Gives Customer Full Information By CID")
	@GetMapping(value = "/mycustomer/custId/{custId}", produces = "application/xml")
	public Customer getCustomerByCid(@PathVariable("custId") int custId) {
		System.out.println("CC-getCustomerByCid() - " + custId);
		Customer cust = new Customer(custId, "Srinivas", "sri@jlc.com", 12345,
				"Blore");
		return cust;
	}

	@ApiOperation(value = " get the Customer By Phone", response = Customer.class, notes = "Gives Customer Full Information By Phone")
	@GetMapping(value = "/mycustomer/phone/{phone}", produces = "application/xml")
	public Customer getCustomerByPhone(@PathVariable("phone") long phone) {
		System.out.println("CC-getCustomerByPhone() - " + phone);
		Customer cust = new Customer(109, "Dande", "dande@jlc.com", phone,
				"Blore");
		return cust;
	}

	
}