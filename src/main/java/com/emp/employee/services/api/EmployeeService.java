package com.emp.employee.services.api;

import com.emp.employee.models.entities.Employee;
import com.emp.employee.models.enums.EmployeeStatusEnum;
import com.emp.exceptions.EmployeeTrackingException;

public interface EmployeeService {

    Employee addEmployee(Employee employee) throws EmployeeTrackingException;

    Employee updateEmployeeStatus(EmployeeStatusEnum employeeStatus, long empID) throws EmployeeTrackingException;
}
