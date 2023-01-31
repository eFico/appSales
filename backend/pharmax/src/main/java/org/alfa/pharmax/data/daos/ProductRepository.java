package org.alfa.pharmax.data.daos;

import org.alfa.pharmax.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
