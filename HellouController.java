package com.hellouworld.hellou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hellou")
public class HellouController {
@GetMapping
public String hellou() 
{
return "Hoje utilizei persistência e atenção aos detalhes";	
	
}
}
