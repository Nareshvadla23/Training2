package com.hnt.office;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hnt.office.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
