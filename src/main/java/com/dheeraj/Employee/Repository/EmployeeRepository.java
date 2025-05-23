package com.dheeraj.Employee.Repository;

import com.dheeraj.Employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

}
