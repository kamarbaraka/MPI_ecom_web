package org.kamar.mpi_ecom_web.item.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.kamar.mpi_ecom_web.item.data.dto.CartItemCreationDto;
import org.kamar.mpi_ecom_web.item.entity.CartItem;
import org.kamar.mpi_ecom_web.item.event.CartItemCreationEvent;
import org.kamar.mpi_ecom_web.item.repository.CartItemRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


/**
 * The CartItemListener class is responsible for handling events related to cart item operations.
 *
 * @author kamar baraka.
 */
@Service
@Log4j2
public class CartItemListener {

    /**
     * Adds a new cart item when an item is added to the cart.
     *
     * @param event The event containing the cart item creation information.
     *
     */
    @EventListener({CartItemCreationEvent.class})
    public void onItemAddedToCart(CartItemCreationEvent event) {

        /*get the data*/
        CartItemCreationDto creationDto = event.getCreationDto();

        log.info("cart item created: {}", creationDto);


    }
}
