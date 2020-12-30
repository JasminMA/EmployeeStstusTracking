package com.emp.employee.services.impl;

import com.emp.employee.dao.api.EmployeeDAO;
import com.emp.employee.models.entities.Employee;
import com.emp.employee.models.enums.EmployeeStatusEnum;
import com.emp.employee.services.api.EmployeeService;
import com.emp.exceptions.EmployeeTrackingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeDAO<Employee> employeeDAO;


    @Override
    public Employee addEmployee(Employee employee) throws EmployeeTrackingException {
        logger.trace("addEmployee"); //TODO add method parameters
        try {
            employee.setEmployeeStatus(EmployeeStatusEnum.ADDED);
            employeeDAO.addOrUpdateEmployee(employee);
            return employee;
        } catch (Exception exception) {
            throw new EmployeeTrackingException("Employee with name=[" + employee.getName() + "] is not added due to" +
                    " [" + exception.getMessage() + "]", exception);
        }
    }

    @Override
    public Employee updateEmployeeStatus(EmployeeStatusEnum employeeStatus, long empID)
            throws EmployeeTrackingException {
        logger.trace("updateEmployeeStatus"); //TODO add method parameters
        try {
            Employee employee = employeeDAO.getEmployeeByID(empID);
            if (employee == null) {
                throw new EmployeeTrackingException("No employee found with ID=[" + empID + "]");
            }
            employee.setEmployeeStatus(employeeStatus);
            employeeDAO.addOrUpdateEmployee(employee);
            return employee;
        } catch (Exception exception) {
            if (!(exception instanceof EmployeeTrackingException)) {
                throw new EmployeeTrackingException("Changing status of employee with ID=[" + empID + "] is not Saved due to" +
                        " [" + exception.getMessage() + "]", exception);
            }
            throw exception;
        }
    }
}
