package com.dheeraj.Employee.Service;

import com.dheeraj.Employee.Entity.Employee;
import com.dheeraj.Employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = repository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setRole(updatedEmployee.getRole());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setMobileNumber(updatedEmployee.getMobileNumber());
            return repository.save(existingEmployee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
