package com.example.CrudRapido.service;

import com.example.CrudRapido.entity.Employee;
import com.example.CrudRapido.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Long dni){
        return employeeRepository.findById(dni);
    }

    public void saveOrUpdate(Employee employee){
        employeeRepository.save(employee);
    }

    public void delete(Long dni){
        employeeRepository.deleteById(dni);
    }

    public Optional<Employee> getCompany(Long company){
        return employeeRepository.findById(company);
    }
}
