package com.william.monitoring.controller;

import com.william.monitoring.model.Employee;
import com.william.monitoring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Employee REST Controller
 * Exposes CRUD API endpoints for Employee management
 *
 * Base URL: http://localhost:8080/api/employees
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET all employees
    // http://localhost:8080/api/employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // GET employee by ID
    // http://localhost:8080/api/employees/1
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET employees by department
    // http://localhost:8080/api/employees/department/Engineering
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Employee>> getByDepartment(@PathVariable String department) {
        List<Employee> employees = employeeService.getEmployeesByDepartment(department);
        return ResponseEntity.ok(employees);
    }

    // POST create new employee
    // http://localhost:8080/api/employees
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    // PUT update employee
    // http://localhost:8080/api/employees/1
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                    @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE employee
    // http://localhost:8080/api/employees/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // GET total count
    // http://localhost:8080/api/employees/count
    @GetMapping("/count")
    public ResponseEntity<Long> getTotalCount() {
        return ResponseEntity.ok(employeeService.getTotalEmployees());
    }
}
