package com.emp.employee.services.impl;

import com.emp.employee.models.entities.Employee;
import com.emp.employee.models.enums.EmployeeStatusEnum;
import com.emp.employee.services.api.EmployeeService;
import com.emp.exceptions.EmployeeTrackingException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void addEmployee() throws EmployeeTrackingException {
        Employee employee = new Employee();
        employee.setName("test");
        employee.setNationalID(String.valueOf(Math.random()));
        employee.setCreationDate(new Date());
        employee.setLastModificationDate(new Date());
        employeeService.addEmployee(employee);
        Assert.assertNotNull(employee.getId());
    }

    @Test
    void updateEmployeeStatus() throws EmployeeTrackingException {
        Employee employee = employeeService.updateEmployeeStatus(EmployeeStatusEnum.IN_CHECK, 7);
        Assert.assertEquals(EmployeeStatusEnum.IN_CHECK, employee.getEmployeeStatus());
    }
}