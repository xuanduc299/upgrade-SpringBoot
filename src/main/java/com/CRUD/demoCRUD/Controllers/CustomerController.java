package com.CRUD.demoCRUD.Controllers;

import com.CRUD.demoCRUD.DTO.CustomerDTO;
import com.CRUD.demoCRUD.DTO.Response;
import com.CRUD.demoCRUD.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public Response<List<CustomerDTO>> getAllCustomers(){
        return customerService.getAll();
    }

    @PostMapping("/add")
    public Response<CustomerDTO> add(@RequestBody CustomerDTO dto){
        return customerService.create(dto);
    }

    @PutMapping("/{id}")
    public Response<CustomerDTO> edit(@PathVariable UUID id,@RequestBody CustomerDTO dto){
        return customerService.edit(dto,id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        customerService.delete(id);
    }
}
