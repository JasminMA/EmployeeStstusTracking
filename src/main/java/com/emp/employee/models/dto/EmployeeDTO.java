package com.emp.employee.models.dto;

import com.emp.employee.models.enums.EmployeeStatusEnum;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class EmployeeDTO extends BaseDTO implements Serializable {

    @NotNull(message = "Name cannot be null")
    private String Name;
    private String nationalID;
    private EmployeeStatusEnum employeeStatus;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public EmployeeStatusEnum getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatusEnum employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
}
