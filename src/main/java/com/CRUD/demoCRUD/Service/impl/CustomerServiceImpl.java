package com.CRUD.demoCRUD.Service.impl;

import com.CRUD.demoCRUD.Convert.Convert;
import com.CRUD.demoCRUD.DTO.CustomerDTO;
import com.CRUD.demoCRUD.DTO.Response;
import com.CRUD.demoCRUD.Entity.Customer;
import com.CRUD.demoCRUD.Entity.Product;
import com.CRUD.demoCRUD.Repository.CustomerRepository;
import com.CRUD.demoCRUD.Service.CustomerService;
import com.CRUD.demoCRUD.Validate.ResponseStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final Convert convert;

    public CustomerServiceImpl(CustomerRepository customerRepository, Convert convert) {
        this.customerRepository = customerRepository;
        this.convert = convert;
    }


    @Override
    public Response<List<CustomerDTO>> getAll() {
        List<Customer> customer = customerRepository.findAll();
        List<CustomerDTO> customerDto = new ArrayList<>();
        customerRepository.findAll().forEach(customers -> customerDto.add(new CustomerDTO(customers)));
        return new Response<>(customerDto);
    }

    @Override
    public Response<CustomerDTO> create(CustomerDTO dto) {

        Product product = new Product();
        product.setId(dto.getProductDto().getId());

        Customer customer = new Customer();
        convert.convertDataIntoDTO(dto,customer,product);
        customer = customerRepository.save(customer);
        return new Response<>(new CustomerDTO(customer), ResponseStatus.SUCCESS);
    }

    @Override
    public Response<CustomerDTO> edit(CustomerDTO dto, UUID id) {
            return null;
    }

    @Override
    public Response<Boolean> delete(UUID id) {
        customerRepository.deleteById(id);
        return new Response<>(ResponseStatus.SUCCESS);
    }
}
