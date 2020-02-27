package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ItemRepo;
import com.example.demo.model.Item;

import io.swagger.annotations.Api;


@Api(value = "Swagger2DemoRestController", description = "REST Apis related to Item Entity")
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

	@Autowired
	ItemRepo repo;
	
	@GetMapping("/items")
	public List<Item> getItemList(){
		return (List<Item>) repo.findAll();
	}
	
	@GetMapping("/items/{id}")
	public Item getItemById(@PathVariable("id") int id) {
		System.out.println(",kjyfghgdhgdhgfjhfkj");
		Item item = repo.getOne(id);
		System.out.println(item.getAmount());
		if(item != null) {
			return item;
		}
		return null;
	}
	
	@PostMapping("/items/add")
	public Item addItem(@RequestBody Item item) {
		 repo.save(item);
		 return item;

		
	}
	
	@DeleteMapping("/items/delete/{id}")
	public String deleteItem(@PathVariable("id") int id) {
		Item item = repo.getOne(id);
		 repo.delete(item);
		 return "Deleted";
		
	}
	
	
	@PutMapping("/items/deposit/{id}/{amount}")
	public void deposit(@PathVariable("id") int id, int deposit) {
		Item item = repo.getOne(id);
		
		if(item != null) {
		item.setAmount(item.getAmount() + deposit);
		repo.save(item);
		}
	
		
	}
		
		@PutMapping("/items/withdrawal/{id}/{amount}")
		public void withdrawal(@PathVariable("id") int id , @PathVariable("amount") int amount) {
			Item item = repo.getOne(id);
			
			if(item!=null)
				{
				if((item.getAmount() - amount) >= 0);
					item.setAmount(item.getAmount() - amount);
					repo.save(item);
			
				}
		}	
		
		
		
		
		}


		
	
	
	

	
	
	
	

