package com.emp.employee.dao.impl;

import com.emp.employee.dao.BaseDAO;
import com.emp.employee.dao.api.EmployeeDAO;
import com.emp.employee.models.entities.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl extends BaseDAO<Employee> implements EmployeeDAO<Employee> {
    private static final Logger logger = LogManager.getLogger(EmployeeDAOImpl.class);

    public EmployeeDAOImpl() {
        super(Employee.class);
    }


    @Override
    public Employee getEmployeeByID(long id) {
        logger.trace("getEmployeeByID");
        return super.loadByID(id);
    }

    @Override
    public Employee addOrUpdateEmployee(Employee employee) {
        logger.trace("addOrUpdateEmployee");
        super.saveOrUpdate(employee);
        return employee;
    }
}
