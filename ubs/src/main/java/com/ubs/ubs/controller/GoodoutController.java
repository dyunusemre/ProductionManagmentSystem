package com.ubs.ubs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.ubs.repository.GoodoutRepository;

@RestController
@RequestMapping(value = "/goodout")
public class GoodoutController {
	
	@Autowired
	GoodoutRepository goodoutRepository;
}
