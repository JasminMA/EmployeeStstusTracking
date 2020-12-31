package com.emp;

import com.emp.employee.models.dto.EmployeeDTO;
import com.emp.employee.models.entities.Employee;
import com.emp.employee.models.enums.EmployeeStatusEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class EmployeeDtoUnitTest {

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void whenConvertPostEntityToPostDto_thenCorrect() {
        Employee employee = new Employee();
        employee.setEmployeeStatus(EmployeeStatusEnum.ADDED);
        employee.setName("yasmin");
        employee.setNationalID("123456789");
        employee.setId(1234);
        employee.setCreationDate(new Date());
        employee.setLastModificationDate(new Date());

        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        Assert.assertEquals(employee.getId(), employeeDTO.getId());
        Assert.assertEquals(employee.getName(), employeeDTO.getName());
        Assert.assertEquals(employee.getNationalID(), employeeDTO.getNationalID());
        Assert.assertEquals(employee.getCreationDate(), employeeDTO.getCreationDate());
        Assert.assertEquals(employee.getLastModificationDate(), employeeDTO.getLastModificationDate());
    }

    @Test
    public void whenConvertPostDtoToPostEntity_thenCorrect() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeStatus(EmployeeStatusEnum.ADDED);
        employeeDTO.setName("yasmin");
        employeeDTO.setNationalID("123456789");
        employeeDTO.setId(1234);
        employeeDTO.setCreationDate(new Date());
        employeeDTO.setLastModificationDate(new Date());

        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Assert.assertEquals(employee.getId(), employeeDTO.getId());
        Assert.assertEquals(employee.getName(), employeeDTO.getName());
        Assert.assertEquals(employee.getNationalID(), employeeDTO.getNationalID());
        Assert.assertEquals(employee.getCreationDate(), employeeDTO.getCreationDate());
        Assert.assertEquals(employee.getLastModificationDate(), employeeDTO.getLastModificationDate());
    }
}
