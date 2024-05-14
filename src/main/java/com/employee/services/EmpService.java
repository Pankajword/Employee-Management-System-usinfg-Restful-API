package com.employee.services;

import com.employee.dao.EmpRepository;
import com.employee.entities.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    // adding the employee
    public Emp addEmployee(Emp e){
        Emp result = empRepository.save(e);
        return result;
    }

    //get all employee
    public List<Emp> getAllEmployee(){
        List<Emp> list = (List<Emp>)empRepository.findAll();
        return list;
    }

    //get Single Employee by Id
    public Emp getEmployeeById(int id) {
        try {
            Optional<Emp> empOptional = empRepository.findById(id);
            return empOptional.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //delete the employee
    public void deleteEmployee(int bid){
        empRepository.deleteById(bid);

    }

    //update the book
    public void updateEmployee(Emp emp,int empId){
        emp.setEmpId(empId);
        empRepository.save(emp);
    }









}
