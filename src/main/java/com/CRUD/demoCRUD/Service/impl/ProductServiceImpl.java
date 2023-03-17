package com.CRUD.demoCRUD.Service.impl;

import com.CRUD.demoCRUD.DTO.ProductDTO;
import com.CRUD.demoCRUD.DTO.Response;
import com.CRUD.demoCRUD.Entity.Product;
import com.CRUD.demoCRUD.Repository.ProductRepository;
import com.CRUD.demoCRUD.Service.ProductService;
import com.CRUD.demoCRUD.Convert.Convert;
import com.CRUD.demoCRUD.Validate.ResponseStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final Convert convert;

    public ProductServiceImpl(ProductRepository productRepository, Convert convert) {
        this.productRepository = productRepository;
        this.convert = convert;
    }

    @Override
    public Response<List<ProductDTO>> getAll() {
        List<Product> product = productRepository.findAll();
        List<ProductDTO> productDto = new ArrayList<>();
        productRepository.findAll().forEach(products -> productDto.add(new ProductDTO(products)));
        return new Response<>(productDto);
    }

    @Override
    public Response<ProductDTO> create(ProductDTO dto) {
        Product product = new Product();
        convert.convertDataIntoDTO((ProductDTO) dto,product);
        product = productRepository.save(product);
        return new Response<>(new ProductDTO(product),ResponseStatus.SUCCESS);
    }

    @Override
    public Response<ProductDTO> edit(ProductDTO dto, UUID id) {
        Product product = productRepository.getProductById(id);
        convert.convertDataIntoDTO(dto,product);
        product = productRepository.save(product);
        return new Response<>(new ProductDTO(product),ResponseStatus.SUCCESS);
    }

    @Override
    public Response<Boolean> delete(UUID id) {
        productRepository.deleteById(id);
        return new Response<>(ResponseStatus.SUCCESS);
    }


}
