package com.employee.dao;

import com.employee.entities.Emp;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Emp, Integer> {

}
