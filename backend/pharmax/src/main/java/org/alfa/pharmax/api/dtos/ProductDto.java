package org.alfa.pharmax.api.dtos;

import java.time.LocalDateTime;

import org.alfa.pharmax.data.model.Product;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {


    private Long id;
  
    private String name;
    private String factoryLaboratory;
    
    private Integer stock;
    private Integer price;
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime dateManufacture;
   // @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime dateExpiration;
    
    
    //public ProductDto (Product registry){
   //     BeanUtils.copyProperties(registry, this);
   // }
    
    public static ProductDto toDto(Product registry){
    	System.out.println(registry.getId());
    	ProductDto product = new ProductDto();
        BeanUtils.copyProperties(registry, product);
        return product;
    }

    public static Product toEntity (ProductDto registry){
    	Product product = new Product();
        BeanUtils.copyProperties(registry, product);
        return product;

    }



}
