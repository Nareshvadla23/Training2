package com.hnt.office.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hnt.office.entity.Employee;
import com.hnt.office.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	EmpService empservice;


	@GetMapping
	String getEMployee() {
		return "hello";
	}
	
	@PostMapping("/save")
	void saveEmployee( @Valid @RequestBody Employee emp )
	{
	  empservice.saveEmp(emp);
	}
	
	@GetMapping("/id")
	void getEmployee(@RequestParam Integer id)
	{
		System.out.println(empservice.getEmp(id).toString());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String, String> handlingException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldname = ((FieldError) error).getField();
			String message = ((FieldError) error).getDefaultMessage();
			errors.put(fieldname, message);

		});

		return errors;
	}


}
