package com.CRUD.demoCRUD.DTO;

import java.util.UUID;

public class BaseObjectDto {
    protected UUID id;

    public BaseObjectDto(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
