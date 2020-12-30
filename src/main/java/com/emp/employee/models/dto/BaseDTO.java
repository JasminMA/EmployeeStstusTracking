package com.emp.employee.models.dto;

import java.util.Date;

public class BaseDTO {
    private long id;
    private Date CreationDate;
    private Date LastModificationDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    public Date getLastModificationDate() {
        return LastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        LastModificationDate = lastModificationDate;
    }
}
