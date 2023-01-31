package org.alfa.pharmax.domain.services;

import java.util.stream.Stream;

import org.alfa.pharmax.data.daos.ProductRepository;
import org.alfa.pharmax.data.model.Product;
import org.alfa.pharmax.domain.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
    @Autowired
    private ProductRepository productRepository;
    
    public Stream<Product> readAll(){
    	Stream<Product> result = this.productRepository.findAll().stream();
    	
    	//result.forEach(x=>{System.out.println(x)});
    //	result.forEach(y->System.out.println(y.toString()));
        return result;
    }
    

    public Product read(Long id){

    	Product response = this.productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The id don't exist: " + id));

        return response;
    }

    public Product create(Product newRegistry){

        return this.productRepository.save(newRegistry);
    }

    public Product update(Long id, Product newRegistry){

    	Product oldRegistry = this.productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The id don't exist: " + id));
    	//newRegistry.setId(oldRegistry.getId());
    	oldRegistry.setName(newRegistry.getName());
    	oldRegistry.setFactoryLaboratory(newRegistry.getFactoryLaboratory());
    	oldRegistry.setStock(newRegistry.getStock());
    	oldRegistry.setPrice(newRegistry.getPrice());
    	oldRegistry.setDateManufacture(newRegistry.getDateManufacture());
    	oldRegistry.setDateExpiration(newRegistry.getDateExpiration());
        this.productRepository.save(oldRegistry);
        
        return oldRegistry;
    }

    public void delete(Long id){
    	Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The id don't exist: " + id));
        this.productRepository.deleteById(id);
    }
}
