package com.onebox.backendtest.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onebox.backendtest.models.CartModel;

@Controller
@RequestMapping("/carts")
public class CartController {
	
	private static Long cacheCreateHour;
	private final Integer minutesCacheTime = 600;

	@GetMapping("/create")
	@Cacheable(value="cart", key = "#id")
	public CartModel create(Model model) {
		
		defineActualHour();
		
		CartModel cart = new CartModel();
		
		return cart;
	}

	@GetMapping(path = "/get/{id}")
	@Cacheable(value = "cart", key = "#id")
	public CartModel getById(Integer id) {
		
		if(!isTTLCacheGreater()) {
			//TODO: Buscar CartModel
		}
		
		return null;
	}
	
	@GetMapping(path = "/delete/{id}")
	@CacheEvict(cacheNames="cart", key="#id")
	public void delete(Model model) {

	}
	
	private void defineActualHour() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		
		cacheCreateHour = Long.parseLong(dtf.format(now));
	}
	
	private boolean isTTLCacheGreater() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		
		Long actualDate = Long.parseLong(dtf.format(now));
		
		if(actualDate - cacheCreateHour >= minutesCacheTime)
			return true;
		
		return false;
	}
	
}
