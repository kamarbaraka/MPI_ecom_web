package org.kamar.mpi_ecom_web.item.data.model;

import org.kamar.mpi_ecom_web.item.controller.CartItemApi;
import org.kamar.mpi_ecom_web.item.controller.CartItemController;
import org.kamar.mpi_ecom_web.item.entity.CartItem;
import org.kamar.mpi_ecom_web.item.exception.CartItemException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;


/**
 * The CartItemModelAssembler class is responsible for converting a CartItem entity to a CartItemModel representation.
 * It extends the RepresentationModelAssemblerSupport class from the Spring HATEOAS framework.
 *
 * @author kamar baraka.
 */
@Service
public class CartItemModelAssembler extends RepresentationModelAssemblerSupport<CartItem, CartItemModel> {

    private final CartItemModel model;

    public CartItemModelAssembler( CartItemModel model) {
        super(CartItemController.class, CartItemModel.class);
        this.model = model;
    }

    /**
     * Converts a CartItem object to a CartItemModel object.
     *
     * @param entity The CartItem object to be converted.
     * @return The corresponding CartItemModel object.
     */
    @Override
    public CartItemModel toModel(CartItem entity)  {

        /*create the model*/
        model.setItemName(entity.getItemName());
        model.setPrice(entity.getPrice());

        /*create the links */
        Link cartItemLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(CartItemController.class)
                .getCartItemById(entity.getItemId()))
                .withRel("cartItem")
                .withSelfRel();

        /*add the links*/
        model.add(cartItemLink);
        /*return the model*/
        return model;

    }
}
