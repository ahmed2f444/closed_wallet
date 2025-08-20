package Repositories;

import Entities.Customer;
import Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Custom methods
    List<Transaction> findByCustomer(Customer customer);
    List<Transaction> findByType(String type);
}