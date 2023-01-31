package org.alfa.pharmax.data.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Product product;//FK


    private Integer quantity;
    private Integer price;
    private Integer totalPrice;

    private LocalDateTime date;

    
}
