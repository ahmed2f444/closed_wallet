package Repositories;

import Entities.Customer;
import Entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    // Custom methods can be added here
    Wallet findByCustomer(Customer customer);
}
