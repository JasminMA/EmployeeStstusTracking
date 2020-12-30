package com.emp.web.models;

import com.emp.employee.models.dto.BaseDTO;

public class RequestTransaction<T extends BaseDTO> {

    private T requestBody;

    public T getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(T requestBody) {
        this.requestBody = requestBody;
    }
}
