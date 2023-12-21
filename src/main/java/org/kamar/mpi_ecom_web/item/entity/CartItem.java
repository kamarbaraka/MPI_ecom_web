package org.kamar.mpi_ecom_web.item.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * cart entity.
 * @author kamar baraka.*/


@Entity(name = "cart_item")
@Data
@Component
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", updatable = false, nullable = false)
    private long itemId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "price", nullable = false)
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "quantity", nullable = false)
    private int quantity = 0;

    @FutureOrPresent
    @Column(name = "updated_on", nullable = false)
    private Timestamp updatedOn = Timestamp.valueOf(LocalDateTime.now());

    @Column(name = "created_on", nullable = false)
    private final LocalDateTime createdOn = LocalDateTime.now();

}
