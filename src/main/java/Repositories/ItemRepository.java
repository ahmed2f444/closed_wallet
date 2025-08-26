
package Repositories;

import Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Custom methods
    List<Item> findByNameContaining(String name);
    List<Item> findByPriceBetween(Double minPrice, Double maxPrice);
}
