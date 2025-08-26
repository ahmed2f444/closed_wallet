package walletservices;

import Entities.Customer;
import Entities.Wallet;
import Repositories.CustomerRepository;
import Repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Create wallet
    public Wallet createWallet(Long customerId, Wallet walletRequest) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        if (walletRepository.findByCustomer(customer) != null) {
            throw new RuntimeException("This customer already has a wallet.");
        }

        Wallet wallet = new Wallet();
        wallet.setCustomer(customer);
        wallet.setBalance(walletRequest != null && walletRequest.getBalance() != null
                ? walletRequest.getBalance() : 0.0);
        wallet.setStatus(walletRequest != null ? walletRequest.getStatus() : "ACTIVE");
        wallet.setLastUpdatedBy(walletRequest != null ? walletRequest.getLastUpdatedBy() : "SYSTEM");

        return walletRepository.save(wallet);
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Wallet getWalletById(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found with ID: " + walletId));
    }

    public Wallet getWalletByCustomerId(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
        Wallet wallet = walletRepository.findByCustomer(customer);
        if (wallet == null) {
            throw new RuntimeException("Wallet not found for customer ID: " + customerId);
        }
        return wallet;
    }

    public Wallet updateWalletBalance(Long walletId, Wallet request) {
        Wallet wallet = getWalletById(walletId);
        if (request.getBalance() != null) {
            wallet.setBalance(request.getBalance());
        }
        wallet.setLastUpdatedBy(request.getLastUpdatedBy() != null ? request.getLastUpdatedBy() : "SYSTEM");
        return walletRepository.save(wallet);
    }

    public Wallet updateWalletStatus(Long walletId, Wallet request) {
        Wallet wallet = getWalletById(walletId);
        if (request.getStatus() != null) {
            wallet.setStatus(request.getStatus());
        }
        wallet.setLastUpdatedBy(request.getLastUpdatedBy() != null ? request.getLastUpdatedBy() : "SYSTEM");
        return walletRepository.save(wallet);
    }

    public void deleteWallet(Long walletId) {
        if (!walletRepository.existsById(walletId)) {
            throw new RuntimeException("Wallet not found with ID: " + walletId);
        }
        walletRepository.deleteById(walletId);
    }
}
