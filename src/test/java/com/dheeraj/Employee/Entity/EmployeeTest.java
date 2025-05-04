package com.dheeraj.Employee.Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    void testEmployeeName() {
    	
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("Dheeraj Gadde");
        emp.setRole("Software Developer");
        emp.setDepartment("IT Department");
        emp.setEmail("dheeraj@gmail.com");
        emp.setMobileNumber("1234567890");
        
        assertEquals("Dheeraj Gadde", emp.getName());
        
    }
    
    @Test
    void testEmployeeEmail() {
    	
        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("Dheeraj Gadde");
        emp.setRole("Software Developer");
        emp.setDepartment("IT Department");
        emp.setEmail("dheeraj@gmail.com");
        emp.setMobileNumber("1234567890");
        
        assertEquals("dheeraj@gmail.com", emp.getEmail());
        
    }
    
}
