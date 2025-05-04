package com.dheeraj.Employee.Controller;

import com.dheeraj.Employee.Entity.Employee;
import com.dheeraj.Employee.Repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setup() {
        employeeRepository.deleteAll();
    }

    @Test
    void testListEmployeesWithRealService() throws Exception {
        employeeRepository.save(new Employee(null, "Test User", "Dev", "IT", "test@x.com", "1234567890"));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("employees"));
    }

    @Test
    void testShowAddFormWithRealService() throws Exception {
        mockMvc.perform(get("/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add_employee"))
                .andExpect(model().attributeExists("employee"));
    }

    @Test
    void testDeleteEmployeeWithRealService() throws Exception {
        Employee emp = employeeRepository.save(new Employee(null, "Delete Me", "QA", "HR", "del@x.com", "0987654321"));

        mockMvc.perform(get("/delete/" + emp.getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
}
