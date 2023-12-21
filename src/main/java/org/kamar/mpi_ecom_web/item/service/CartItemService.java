package org.kamar.mpi_ecom_web.item.service;

import org.kamar.mpi_ecom_web.item.data.dto.CartItemCreationDto;
import org.kamar.mpi_ecom_web.item.entity.CartItem;
import org.kamar.mpi_ecom_web.item.exception.CartItemException;

/**
 * The CartItemService interface defines methods for performing operations related to cart items.
 *
 * @author kamar baraka.
 */
public interface CartItemService {

    CartItem createCartItem(CartItemCreationDto creationDto) throws CartItemException;

    CartItem getCartItemById(long cartItemId) throws CartItemException;
}
