package com.emp.web.controller;

import com.emp.employee.models.dto.EmployeeDTO;
import com.emp.employee.models.entities.Employee;
import com.emp.employee.models.enums.EmployeeStatusEnum;
import com.emp.employee.services.api.EmployeeService;
import com.emp.web.models.RequestTransaction;
import com.emp.web.models.ResponseTransaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class TrackingEmployeeController extends BaseController<EmployeeDTO, Employee> {
    private static final Logger logger = LogManager.getLogger(TrackingEmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    public TrackingEmployeeController() {
        super(EmployeeDTO.class, Employee.class);
    }

    @PostMapping(value = "/addEmployee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseTransaction<EmployeeDTO>> addEmployee(@RequestBody RequestTransaction<EmployeeDTO> requestTransaction) {
        logger.trace("addEmployee");
        ResponseTransaction<EmployeeDTO> responseTransaction = null;
        try {

            Employee employee = convertToEntity(requestTransaction.getRequestBody());
            employeeService.addEmployee(employee);
            responseTransaction = new ResponseTransaction<EmployeeDTO>(convertToDTO(employee));
        } catch (Exception exception) {
            responseTransaction = ResponseTransaction.buildFailedResponse(exception);
        }
        return new ResponseEntity<>(responseTransaction, HttpStatus.OK);
    }

    @PutMapping(value = "/updateStatus/{id}/{status}", produces = "application/json")
    public ResponseEntity<ResponseTransaction<EmployeeDTO>> updateStatus(@PathVariable("id") long id,
                                                                         @PathVariable("status") EmployeeStatusEnum employeeStatus) {
        logger.trace("updateStatus");
        ResponseTransaction<EmployeeDTO> responseTransaction = null;
        try {

            Employee employee = employeeService.updateEmployeeStatus(employeeStatus, id);
            responseTransaction = new ResponseTransaction<EmployeeDTO>(convertToDTO(employee));
        } catch (Exception exception) {
            responseTransaction = ResponseTransaction.buildFailedResponse(exception);
        }
        return new ResponseEntity<>(responseTransaction, HttpStatus.OK);
    }
}
