package com.hnt.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnt.office.EmpRepo;
import com.hnt.office.entity.Employee;

@Service
public class EmpService {

	@Autowired
	EmpRepo emrepo;

	public void saveEmp(Employee emp) {
		emrepo.save(emp);
	}

	public Employee getEmp(Integer id) {
		Employee e1 = emrepo.getById(id);

		return e1;
	}

}
