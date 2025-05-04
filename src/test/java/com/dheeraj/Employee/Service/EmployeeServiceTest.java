package com.dheeraj.Employee.Service;

import com.dheeraj.Employee.Entity.Employee;
import com.dheeraj.Employee.Repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveEmployee() {
        Employee emp = new Employee(1L, "Dheeraj", "Software Developer", "IT Department", "dheeraj@example.com", "1234567890");
        when(repository.save(emp)).thenReturn(emp);

        Employee result = service.saveEmployee(emp);
        assertEquals("Dheeraj", result.getName());
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> list = Arrays.asList(
                new Employee(1L, "A", "Dev", "IT", "a@x.com", "111"),
                new Employee(2L, "B", "QA", "IT", "b@x.com", "222")
        );
        when(repository.findAll()).thenReturn(list);

        List<Employee> result = service.getAllEmployees();
        assertEquals(2, result.size());
    }

    @Test
    void testGetEmployeeById() {
        Employee emp = new Employee(1L, "Dheeraj", "Software Developer", "IT Department", "dheeraj@x.com", "123");
        when(repository.findById(1L)).thenReturn(Optional.of(emp));

        Employee result = service.getEmployeeById(1L);
        assertEquals("Dheeraj", result.getName());
    }

    @Test
    void testUpdateEmployee() {
        Employee existing = new Employee(1L, "a", "Dev", "IT", "a@x.com", "123");
        Employee updated = new Employee(1L, "b", "QA", "HR", "b@x.com", "456");

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any(Employee.class))).thenReturn(updated);

        Employee result = service.updateEmployee(1L, updated);
        assertEquals("b", result.getName());
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(repository).deleteById(1L);
        service.deleteEmployee(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}
