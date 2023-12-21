package org.kamar.mpi_ecom_web.item.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


/**
 * This class represents a cart item model.
 * It extends the RepresentationModel class, which is part of the Spring HATEOAS framework.
 * RepresentationModel is a base class for representing RESTful resources.
 *
 * @author kamar baraka.
 */
@Getter
@Setter
@Component
public class CartItemModel extends RepresentationModel<CartItemModel> {

    private String itemName;
    private BigDecimal price;
}
