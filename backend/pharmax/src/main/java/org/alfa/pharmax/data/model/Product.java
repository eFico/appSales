package org.alfa.pharmax.data.model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
@Builder
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    
    @NonNull
    private String name;
    
    @NonNull
    private String factoryLaboratory;
    
    private Integer stock;
    private Integer price;
    
    private LocalDateTime dateManufacture;
    private LocalDateTime dateExpiration;

}
