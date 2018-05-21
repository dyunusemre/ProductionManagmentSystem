package com.ubs.ubs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.ubs.model.RecentTransaction;
import com.ubs.ubs.repository.RecentTransactionsRepository;

@RestController
@RequestMapping(value="/recent")
public class RecentController {
	@Autowired
	RecentTransactionsRepository recentRepository;
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value="/getAllRecent")
	public @ResponseBody List<RecentTransaction> getAllRecent(){
		return recentRepository.findAll();
	}
}
