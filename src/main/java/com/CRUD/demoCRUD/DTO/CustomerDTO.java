package com.CRUD.demoCRUD.DTO;

import com.CRUD.demoCRUD.Entity.Customer;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;

@JsonPropertyOrder({"list","productDto"})
public class CustomerDTO extends BaseObjectDto{
    private String makh;

    private String name;

    private String quantity;

    private String sectors;

    private ProductDTO productDto;

    public CustomerDTO(){}

    public CustomerDTO(UUID id) {
        this.setId(id);
    }
    public CustomerDTO(Customer entity){
        if(entity!=null){
            this.setId(entity.getId());
            this.setMakh(entity.getMakh());
            this.setName(entity.getName());
            this.setQuantity(entity.getQuantity());
            this.setSectors(entity.getSectors());
            this.setProductDto(new ProductDTO(entity.getProduct()));
        }
    }


    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSectors() {
        return sectors;
    }

    public void setSectors(String sectors) {
        this.sectors = sectors;
    }

    public ProductDTO getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDTO productDto) {
        this.productDto = productDto;
    }
}
