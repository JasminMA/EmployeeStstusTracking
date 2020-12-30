package com.emp.web.controller;

import com.emp.employee.models.dto.BaseDTO;
import com.emp.employee.models.entities.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.Date;

public class BaseController<T extends BaseDTO, S extends BaseEntity> {

    private final Class<T> dtoType;
    private final Class<S> entityType;

    public BaseController(Class<T> dtoType, Class<S> entityType) {
        this.dtoType = dtoType;
        this.entityType = entityType;
    }

    public Class<T> getDTOType() {
        return this.dtoType;
    }

    public Class<S> getEntityType() {
        return this.entityType;
    }

    @Autowired
    ModelMapper modelMapper;

    S convertToEntity(T dto) {
        S entity = modelMapper.map(dto, getEntityType());
        if (entity.getId() == 0) {
            entity.setCreationDate(new Date());
        }
        entity.setLastModificationDate(new Date());
        return entity;
    }

    T convertToDTO(S entity) {
        return modelMapper.map(entity, getDTOType());
    }

}
