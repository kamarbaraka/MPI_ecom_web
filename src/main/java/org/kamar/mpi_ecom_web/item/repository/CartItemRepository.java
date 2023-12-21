package org.kamar.mpi_ecom_web.item.repository;

import org.kamar.mpi_ecom_web.item.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CartItemRepository is an interface that extends the JpaRepository interface.
 * It provides methods for performing CRUD operations on the CartItem entity in the database.
 *
 * This interface is annotated with the @Repository annotation, which indicates that it is a repository component
 * and enables automatic exception translation in the persistence layer.
 *
 * Example usage:
 *
 * CartItemRepository cartItemRepository = ...; // initialize the repository
 *
 * // Save a new CartItem entity
 * CartItem item = new CartItem();
 * item.setItemName("Item 1");
 * item.setPrice(BigDecimal.valueOf(10.99));
 * item.setQuantity(1);
 * cartItemRepository.save(item);
 *
 * // Retrieve all CartItem entities
 * List<CartItem> items = cartItemRepository.findAll();
 *
 * // Find a CartItem by its itemId
 * Optional<CartItem> optionalItem = cartItemRepository.findById(itemId);
 * if (optionalItem.isPresent()) {
 *     CartItem item = optionalItem.get();
 *     // perform operations on the item
 * }
 *
 * // Delete a CartItem
 * cartItemRepository.deleteById(itemId);
 *
 * @author kamar baraka.
 */

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
