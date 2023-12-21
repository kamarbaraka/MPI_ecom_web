package org.kamar.mpi_ecom_web.item.event;

import lombok.Getter;
import org.kamar.mpi_ecom_web.item.data.dto.CartItemCreationDto;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


/**
 * This class represents an event that is triggered when a new cart item is created.
 * It extends the ApplicationEvent class from the Spring Framework.
 *
 * @author kamar baraka.

 */
@Getter
public class CartItemCreationEvent extends ApplicationEvent {

    private final CartItemCreationDto creationDto;

    public CartItemCreationEvent(Object source, CartItemCreationDto creationDto) {
        super(source);
        this.creationDto = creationDto;
    }
}
