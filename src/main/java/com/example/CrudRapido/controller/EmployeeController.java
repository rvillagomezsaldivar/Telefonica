package com.example.CrudRapido.controller;

import com.example.CrudRapido.entity.Employee;
import com.example.CrudRapido.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{dni}")
    public Optional<Employee> getById(@PathVariable("dni") Long dni){
        return employeeService.getEmployee(dni);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Employee employee){
        employeeService.saveOrUpdate(employee);
    }

    @DeleteMapping("/{dni}")
    public void delete(@PathVariable("dni") Long dni){
        employeeService.delete(dni);
    }

    /*@GetMapping("/{company}")
    public Optional<Employee> getByCompany(@PathVariable("company") Long company){
        return employeeService.getCompany(company);
    }*/

}
