package org.alfa.pharmax.data.daos;

import java.time.LocalDateTime;
import java.util.List;

import org.alfa.pharmax.data.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SaleRepository extends JpaRepository<Sale, Long> {
	
    List<Sale> findAllByDateBetween( LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);
    
    //@Query("select s Sale s where s.date >= :timeStart AND s.date <= :timeEnd")
    //List<Sale>  findAllByDateBetween(@Param("timeStart") LocalDateTime timeStart, @Param("timeEnd") LocalDateTime timeEnd);


}
