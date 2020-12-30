package com.emp.employee.models.entities;

import com.emp.employee.models.enums.EmployeeStatusEnum;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "EMPLOYEE")
@org.hibernate.annotations.NamedQueries({
        @NamedQuery(name = "getEmployeeByID",
                query = "from Employee where id = :id")})
public class Employee extends BaseEntity {


    private String Name;
    private String nationalID;
    private EmployeeStatusEnum employeeStatus;

    @Column(nullable = false)
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Column(unique = true)
    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    @Enumerated(EnumType.STRING)
    public EmployeeStatusEnum getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatusEnum employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
}
