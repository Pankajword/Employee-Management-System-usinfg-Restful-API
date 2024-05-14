package com.employee.controller;

import com.employee.entities.Emp;
import com.employee.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    // add new employee handler
    @PostMapping("/emp")
    public ResponseEntity<Emp> addEmployee(@RequestBody Emp emp) {
        Emp e = null;
        try {
            e = empService.addEmployee(emp);
            return ResponseEntity.status(HttpStatus.CREATED).body(e);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //get All Employee handler
    @GetMapping("/emp")
    public ResponseEntity<List<Emp>> getAllEmployeesHandler() {
        List<Emp> list = empService.getAllEmployee();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }

    //get Single employee handler
    @GetMapping("/emp/{id}")
    public ResponseEntity<Emp> getEmployee(@PathVariable("id") int id){
        Emp employee = empService.getEmployeeById(id);
        if(employee==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(employee));
    }

    @DeleteMapping("/emp/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("empId") int empId) {
        try {
            empService.deleteEmployee(empId);
            return ResponseEntity.ok("Employee with ID " + empId + " deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete employee.");
        }
    }

@PutMapping("/emp/{empId}") // Corrected the path variable name to "empId"
public ResponseEntity<Emp> updateEmployee(@RequestBody Emp emp, @PathVariable("empId") int empId) {
    try {
        this.empService.updateEmployee(emp, empId);
        return ResponseEntity.ok().body(emp); // Return the updated employee in the response body
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

}







