package org.kamar.mpi_ecom_web.item.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.kamar.mpi_ecom_web.item.data.dto.CartItemCreationDto;
import org.kamar.mpi_ecom_web.item.entity.CartItem;
import org.kamar.mpi_ecom_web.item.event.CartItemCreationEvent;
import org.kamar.mpi_ecom_web.item.exception.CartItemException;
import org.kamar.mpi_ecom_web.item.repository.CartItemRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


/**
 * The CartItemServiceImpl class is responsible for creating and retrieving cart items.
 * It implements the CartItemService interface.
 *
 * @author kamar baraka.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository repository;
    private final CartItem cartItem;
    private final ApplicationEventPublisher publisher;

    /**
     * Creates a new cart item based on the given CartItemCreationDto.
     *
     * @param creationDto the CartItemCreationDto containing the necessary information to create the cart item
     * @return the created cart item
     * @throws CartItemException if there is an error creating the cart item
     */
    @Override
    public CartItem createCartItem(CartItemCreationDto creationDto) throws CartItemException {


        /*create the cart item and persist it.*/
        cartItem.setItemName(creationDto.itemName());
        cartItem.setPrice(BigDecimal.valueOf(creationDto.price()));

        CartItem savedCartItem = repository.save(cartItem);

        /*create the event and publish it*/
        CartItemCreationEvent cartItemCreationEvent = new CartItemCreationEvent(this, creationDto);
        publisher.publishEvent(cartItemCreationEvent);

        return savedCartItem;

    }

    /**
     * Retrieves a cart item by its ID.
     *
     * @param cartItemId the ID of the cart item to retrieve
     * @return the retrieved cart item
     * @throws CartItemException if the cart item is not found
     */
    @Override
    public CartItem getCartItemById(final long cartItemId) throws CartItemException {

        /*get the cart item*/
        return repository.findById(cartItemId).orElseThrow(
                () -> new CartItemException("cart item not found! : "+ this.getClass().getSimpleName())
        );
    }
}
