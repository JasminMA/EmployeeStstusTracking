package com.emp.employee.dao.api;

import com.emp.employee.models.entities.Employee;

public interface EmployeeDAO<Employee>{

    Employee getEmployeeByID(long id);

    Employee addOrUpdateEmployee(Employee employee);

}
