package org.kamar.mpi_ecom_web.item.controller;

import org.kamar.mpi_ecom_web.item.data.dto.CartItemCreationDto;
import org.kamar.mpi_ecom_web.item.data.model.CartItemModel;
import org.kamar.mpi_ecom_web.item.entity.CartItem;
import org.kamar.mpi_ecom_web.item.exception.CartItemException;
import org.springframework.http.ResponseEntity;

/**
 * The CartItemApi interface provides methods for interacting with cart items.
 * It allows the creation and retrieval of cart items.
 *
 * @author kamar baraka.
 */
public interface CartItemApi {

    ResponseEntity<CartItemModel> createCartItem(CartItemCreationDto creationDto) throws CartItemException;

    ResponseEntity<CartItem> getCartItemById(long cartItemId) throws CartItemException;
}
