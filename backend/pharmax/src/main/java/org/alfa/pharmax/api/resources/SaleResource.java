package org.alfa.pharmax.api.resources;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

import org.alfa.pharmax.data.model.Sale;
import org.alfa.pharmax.domain.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1" + SaleResource.SALE)
public class SaleResource {
    public static final String SALE = "/sales";
    public static final String ID = "/{id}";

    @Autowired
    private SaleService saleService;

    @GetMapping
    public Stream<Sale> readAll() {
        return this.saleService.readAll();
    }
    
  
    
    @GetMapping(value = "/filter")
    public Stream<Sale> readAllRange(@RequestParam(value = "dateStart") String dateStart, @RequestParam(value = "dateEnd") String dateEnd) {
    	
    	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        LocalDateTime dateTimeStart=LocalDateTime.parse(dateStart, formatter);
        LocalDateTime dateTimeEnd=LocalDateTime.parse(dateEnd, formatter);
        
        System.out.println(dateTimeStart);
        System.out.println(dateTimeEnd);
        
        return this.saleService.readAllRageDate(dateTimeStart, dateTimeEnd);
    }
    
    @GetMapping(value = ID)
    public Sale read(@PathVariable Long id){
        return this.saleService.read(id);
    }

    @PostMapping
    public void create(@RequestBody Sale newRegistry) {

        this.saleService.create(newRegistry);
    }

    @PutMapping(value = ID)
    public Sale update(@PathVariable Long id, @RequestBody Sale newRegistry){

        return this.saleService.update(id,newRegistry);
    }

    @DeleteMapping(value = ID)
    public void delete(@PathVariable Long id) {
        this.saleService.delete(id);
    }
}
