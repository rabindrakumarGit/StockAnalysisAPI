package com.springboot;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;


@RestController
public class AccountController {
	@ApiOperation(value = " get the Balance", response = double.class, notes = "Gives Balance of Customer with Accno")
	@GetMapping("/mybal/{accno}")
	public double getBalance(@PathVariable("accno") String accno) {
		System.out.println("AC-getBalance()" + accno);
		return 25000;
	}


	@ApiOperation(value = " get All Accounts Information",response = List.class,
notes = "Gives All the Accounts Information" )
@GetMapping("/myaccounts")
public List<Account> getAllCounts(){
		System.out.println("AC-getAllCounts()");
		List<Account> accList = new ArrayList<>();
		accList.add(new Account(101, "SA", "B99", 19000.0));
		accList.add(new Account(102, "SA", "B99", 29000.0));
		accList.add(new Account(103, "SA", "B99", 29000.0));

accList.add(new Account(104,"SA","B99",39000.0));
accList.add(new Account(105,"SA","B99",49000.0));
return accList;
}

	@ApiOperation(value = " Adds Account Info", response = Account.class, notes = "Adds Accounts Information")
	@PostMapping(value = "/addAccount")
	public Account addAccount(@RequestBody Account acc) {
		System.out.println("AC-addAccount()");
		acc.setAccno(123);
		return acc;
	}

	

	
}