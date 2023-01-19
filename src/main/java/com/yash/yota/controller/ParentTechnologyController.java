package com.yash.yota.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.yash.yota.model.ParentTechnology;
import com.yash.yota.service.ParentTechnologyService;

/*
 * Parent Technology Controller will facilitates CRUD functionalities
 */
@RestController
@RequestMapping("/yota/dashboard")
public class ParentTechnologyController {
	
	@Autowired
	private ParentTechnologyService parentTechnologyService;
	
	@PostMapping("/addTech")
	public ParentTechnology addParentTechnology(@Valid @RequestBody ParentTechnology technology)
	{
		return parentTechnologyService.save(technology);
	}
	
	@GetMapping("/getAllTech")
	public List<ParentTechnology> getAll()
	{
		return parentTechnologyService.getAllTechs();
	}
	
	@GetMapping("/getTech/{name}")
	public ParentTechnology getTech(@RequestParam("name") String name)
	{
		return parentTechnologyService.getTech(name);
	}
	
	@GetMapping("/searchTech/{keyword}")
	public List<ParentTechnology> searchTech(@PathVariable("keyword") String keyword)
	{
		List<ParentTechnology> technologies=parentTechnologyService.searchTech(keyword);
		return technologies;
	}
	
	@DeleteMapping("/removeTech/{name}")
	public ResponseEntity<?> removeTech(@RequestParam("name") String name)
	{
		boolean result=parentTechnologyService.removeTech(name);
		if (result) {
			return new ResponseEntity<>("Technology Deleted",HttpStatus.OK);
		}
		return new ResponseEntity<>("Technology not Deleted",HttpStatus.OK);
	}
	
	@PutMapping("/updateTech")
	public ParentTechnology upadateTech(@Valid @RequestBody ParentTechnology technology)
	{
		return parentTechnologyService.updateTech(technology);
	}
}
