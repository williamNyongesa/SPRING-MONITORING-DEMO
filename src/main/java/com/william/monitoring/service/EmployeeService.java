package com.william.monitoring.service;

import com.william.monitoring.model.Employee;
import com.william.monitoring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Employee Service - Business logic layer
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Get employee by email
    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    // Get employees by department
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    // Create new employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setSalary(updatedEmployee.getSalary());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Get total employee count
    public long getTotalEmployees() {
        return employeeRepository.count();
    }

    // Get high earners
    public List<Employee> getHighEarners(Double salaryThreshold) {
        return employeeRepository.findBySalaryGreaterThan(salaryThreshold);
    }
}
