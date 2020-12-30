package com.emp.employee.models.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseEntity implements Serializable {
    private long id;
    private Date CreationDate;
    private Date LastModificationDate;

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }


    @Column(nullable = false)
    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        CreationDate = creationDate;
    }

    @Column(nullable = false)
    public Date getLastModificationDate() {
        return LastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        LastModificationDate = lastModificationDate;
    }
}
