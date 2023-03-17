package com.CRUD.demoCRUD.Convert;

import com.CRUD.demoCRUD.DTO.CustomerDTO;
import com.CRUD.demoCRUD.DTO.ProductDTO;
import com.CRUD.demoCRUD.Entity.Customer;
import com.CRUD.demoCRUD.Entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Convert {
    public void convertDataIntoDTO(ProductDTO productDTO, Product product){
        product.setMaSp(productDTO.getMaSp());
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setSectors(productDTO.getSectors());
    }

    public void convertDataIntoDTO(CustomerDTO customerDTO, Customer customer,Product product){
        customer.setMakh(customerDTO.getMakh());
        customer.setName(customerDTO.getName());
        customer.setQuantity(customerDTO.getQuantity());
        customer.setSectors(customerDTO.getSectors());
        customer.setProduct(product);


    }
}
