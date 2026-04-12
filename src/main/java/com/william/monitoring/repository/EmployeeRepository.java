package com.william.monitoring.repository;

import com.william.monitoring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Employee Repository - Database operations using Spring Data JPA
 * No SQL needed - JPA handles everything!
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employee by email
    Optional<Employee> findByEmail(String email);

    // Find all employees in a department
    List<Employee> findByDepartment(String department);

    // Custom query - find employees with salary greater than amount
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findBySalaryGreaterThan(Double salary);

    // Count employees per department
    @Query("SELECT e.department, COUNT(e) FROM Employee e GROUP BY e.department")
    List<Object[]> countByDepartment();
}
