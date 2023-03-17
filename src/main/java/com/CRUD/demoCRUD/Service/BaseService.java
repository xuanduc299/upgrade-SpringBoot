package com.CRUD.demoCRUD.Service;

import com.CRUD.demoCRUD.DTO.ProductDTO;
import com.CRUD.demoCRUD.DTO.Response;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {
    Response<List<T>> getAll();

    Response<T> create(T dto);
    Response<T> edit(T dto, UUID id);

    Response<Boolean> delete(UUID id);
}
