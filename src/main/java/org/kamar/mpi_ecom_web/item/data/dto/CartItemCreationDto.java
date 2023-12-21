package org.kamar.mpi_ecom_web.item.data.dto;

import jakarta.validation.constraints.NotNull;

/**
 * Represents a data transfer object (DTO) for creating a cart item.
 * It contains the necessary information required for creating a cart item, such as the item name and price.
 *
 * @author kamar baraka.
 */
public record CartItemCreationDto(
        @NotNull
        String itemName,
        @NotNull
        double price
) {
}
