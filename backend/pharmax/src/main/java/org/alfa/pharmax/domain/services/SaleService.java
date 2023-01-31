package org.alfa.pharmax.domain.services;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.alfa.pharmax.data.daos.ProductRepository;
import org.alfa.pharmax.data.daos.SaleRepository;
import org.alfa.pharmax.data.model.Product;
import org.alfa.pharmax.data.model.Sale;
import org.alfa.pharmax.domain.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
    private ProductRepository productRepository;
	
	public Stream<Sale> readAllRageDate(LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd) {
		return this.saleRepository.findAllByDateBetween(dateTimeStart,dateTimeEnd).stream();
	}


	public Stream<Sale> readAll() {
		return this.saleRepository.findAll().stream();
	}

	public Sale read(Long id) {

		Sale response = this.saleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("The id don't exist: " + id));

		return response;
	}

	public Sale create(Sale newRegistry) {
		
    	Product product = this.productRepository.findById(newRegistry.getProduct().getId())
                .orElseThrow(() -> new NotFoundException("The id don't exist: " + newRegistry.getProduct().getId()));
    	
    	product.setStock(product.getStock()-newRegistry.getQuantity());
    	this.productRepository.save(product);
		return this.saleRepository.save(newRegistry);
		
	}

	public Sale update(Long id, Sale newRegistry) {

		Sale oldRegistry = this.saleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("The id don't exist: " + id));

		this.saleRepository.save(oldRegistry);

		return oldRegistry;
	}

	public void delete(Long id) {
		Sale product = this.saleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("The id don't exist: " + id));
		this.saleRepository.deleteById(id);
	}

}
