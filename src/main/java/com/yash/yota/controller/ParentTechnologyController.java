package com.yash.yota.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.yash.yota.service.TechnologyValidationService;

/*
 * Parent Technology Controller will facilitates CRUD functionalities
 */

@RestController
//TODO: in request mapping mention /boyota/parent-tech
@RequestMapping("/yota/parent-tech")
public class ParentTechnologyController {
	
	@Autowired
	private ParentTechnologyService parentTechnologyService;
	
	@Autowired
	private TechnologyValidationService validationService;
	
	//TODO : return type should be ResponseEntity<?>, because it may send the exception as well. 
	@PostMapping("/")
	public ResponseEntity<?> addParentTechnology(@Valid @RequestBody ParentTechnology technology, BindingResult result)
	{
		ResponseEntity<?> errorMap= validationService.validationError(result);
		if (errorMap!=null) {
			return errorMap;
		}
		return new ResponseEntity<ParentTechnology>(parentTechnologyService.save(technology),HttpStatus.OK);
	}
	//TODO : 
	@GetMapping("/")
	public ResponseEntity<List<ParentTechnology>> getAll()
	{
		return new ResponseEntity<List<ParentTechnology>>(parentTechnologyService.getAllTechs(),HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<ParentTechnology> getTech(@RequestParam(value ="name") String name)
	{
		return new ResponseEntity<ParentTechnology>(parentTechnologyService.getTech(name),HttpStatus.OK);
	}
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<ParentTechnology>> searchTech(@PathVariable("keyword") String keyword)
	{
		List<ParentTechnology> technologies=parentTechnologyService.searchTech(keyword);
		return new ResponseEntity<List<ParentTechnology>>(technologies,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeTech(@PathVariable(value = "id") long id)
	{
		 parentTechnologyService.removeTech(id);
		 return new ResponseEntity<String>("Technology with ID :"+id+" deleted.", HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> upadateTech(@Valid @RequestBody ParentTechnology technology,BindingResult result)
	{
		ResponseEntity<?> errorMap= validationService.validationError(result);
		if (errorMap!=null) {
			return errorMap;
		}
		return new ResponseEntity<ParentTechnology>(parentTechnologyService.updateTech(technology),HttpStatus.OK);
	}
}
