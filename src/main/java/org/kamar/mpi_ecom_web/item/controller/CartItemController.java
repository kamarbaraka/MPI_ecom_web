package org.kamar.mpi_ecom_web.item.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.kamar.mpi_ecom_web.item.data.dto.CartItemCreationDto;
import org.kamar.mpi_ecom_web.item.data.model.CartItemModel;
import org.kamar.mpi_ecom_web.item.data.model.CartItemModelAssembler;
import org.kamar.mpi_ecom_web.item.entity.CartItem;
import org.kamar.mpi_ecom_web.item.exception.CartItemException;
import org.kamar.mpi_ecom_web.item.service.CartItemService;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;


/**
 * The CartItemController is a REST controller that handles requests related to cart items.
 *
 * @author kamar baraka.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(name = "cartItems", value = {"api/v1/cartItems"})
public class CartItemController implements CartItemApi{

    private final CartItemService service;

    private final CartItemModelAssembler assembler;

    /**
     * Creates a new cart item with the provided creation DTO.
     *
     * @param creationDto The CartItemCreationDto containing the necessary information to create a cart item.
     * @return The ResponseEntity with the created cart item model.
     * @throws CartItemException If an error occurs while creating the cart item.
     */
    @PostMapping()
    @Override
    public ResponseEntity<CartItemModel> createCartItem(@RequestBody @Validated CartItemCreationDto creationDto) {

        try
        {
            /*create the cart item*/
            CartItem cartItem = service.createCartItem(creationDto);

            /*get the model of the cart item*/
            CartItemModel model = assembler.toModel(cartItem);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .cacheControl(CacheControl.maxAge(2, TimeUnit.DAYS))
                    .eTag(cartItem.getUpdatedOn().toString())
                    .body(model);
        }catch (CartItemException e){

            throw new CartItemException(e.getMessage());
        }
    }

    /**
     * Retrieves a cart item by its ID.
     *
     * @param itemId The ID of the cart item to retrieve.
     * @return The ResponseEntity with the requested cart item.
     * @throws CartItemException If an error occurs while retrieving the cart item.
     */
    @GetMapping(value = {"{itemId}"})
    @Override
    public ResponseEntity<CartItem> getCartItemById(@PathVariable("itemId") final long itemId ) {

        /*get the cart item*/
        CartItem cartItem = service.getCartItemById(itemId);
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(2, TimeUnit.DAYS))
                .eTag(cartItem.getUpdatedOn().toString())
                .body(cartItem);
    }

    @GetMapping
    public String hello(){

        return "hello";
    }
}
