package com.emp.web.models;

import com.emp.employee.models.dto.BaseDTO;

public class ResponseTransaction<T extends BaseDTO> {

    private String statusCode;
    private String errorMessage;
    private String status;
    private T responseBody;

    public ResponseTransaction() {
    }
    public ResponseTransaction(T responseDTO) {
        this.responseBody = responseDTO;
        statusCode = "0";
        errorMessage ="";
        status = "Success";
    }

    public ResponseTransaction(String statusCode, String errorMessage) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ResponseTransaction buildSuccessResponse(T responseDTO) {
        ResponseTransaction billResponseTransaction = new ResponseTransaction(responseDTO);
        billResponseTransaction.setStatusCode("0");
        billResponseTransaction.setErrorMessage("");
        return billResponseTransaction;
    }

    public static ResponseTransaction buildFailedResponse(Exception exception) {
        ResponseTransaction billResponseTransaction = new ResponseTransaction();
        billResponseTransaction.setStatusCode("100");
        billResponseTransaction.setStatus("Failed");
        billResponseTransaction.setErrorMessage(exception.getMessage());
        return billResponseTransaction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(T responseBody) {
        this.responseBody = responseBody;
    }
}
