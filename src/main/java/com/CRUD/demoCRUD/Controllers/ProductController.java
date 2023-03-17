package com.CRUD.demoCRUD.Controllers;
import com.CRUD.demoCRUD.DTO.ProductDTO;
import com.CRUD.demoCRUD.DTO.Response;
import com.CRUD.demoCRUD.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public Response<List<ProductDTO>> getAllProducts(){
        return productService.getAll();
    }

    @PostMapping("/add")
    public Response<ProductDTO> add(@RequestBody ProductDTO dto){
        return productService.create(dto);
    }

    @PutMapping("/{id}")
    public Response<ProductDTO> edit(@PathVariable UUID id,@RequestBody ProductDTO dto){
        return productService.edit(dto,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        productService.delete(id);
    }
}

