package eg.eandintern.closedwallet.controllers;

import Entities.Item;
import Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/items")
@CrossOrigin // Optional: if testing from frontend (e.g., React, Angular)
public class itemController {

    @Autowired
    private ItemRepository itemRepository;

    // ✅ Add a new item
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item addItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    // 🗑️ Delete an item by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable("id") Long id) {
        itemRepository.deleteById(id);
    }

    // 🔍 Optional: Get all items (helpful for testing)
    @GetMapping
    public Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
