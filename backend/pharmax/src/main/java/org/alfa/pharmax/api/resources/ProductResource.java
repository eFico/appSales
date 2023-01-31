package org.alfa.pharmax.api.resources;



import java.util.stream.Stream;

import org.alfa.pharmax.api.dtos.ProductDto;
import org.alfa.pharmax.data.model.Product;
import org.alfa.pharmax.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1" +ProductResource.PRODUCT)
public class ProductResource {

    public static final String PRODUCT = "/products";
    public static final String ID = "/{id}";

    @Autowired
    private ProductService productService;

    @GetMapping
    public Stream<ProductDto> readAll() {

    	System.out.println("readAll");
        return this.productService.readAll().map(ProductDto::toDto);
    }
    @GetMapping(value = ID)
    public Product read(@PathVariable Long id){
        return  this.productService.read(id);
    }

    @PostMapping
    public void create(@RequestBody Product newRegistry) {
        this.productService.create(newRegistry);
    }

    @PutMapping(value = ID)
    public Product update(@PathVariable Long id, @RequestBody Product newRegistry){
        return this.productService.update(id,newRegistry);
    }

    @DeleteMapping(value = ID)
    public void delete(@PathVariable Long id) {
        this.productService.delete(id);
    }
}
