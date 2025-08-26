package eg.eandintern.closedwallet.controllers;

import Entities.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import walletservices.WalletService;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
@CrossOrigin
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Wallet createWallet(@PathVariable Long customerId,
                               @RequestBody(required = false) Wallet walletRequest) {
        return walletService.createWallet(customerId, walletRequest);
    }

    @GetMapping
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @GetMapping("/{walletId}")
    public Wallet getWalletById(@PathVariable Long walletId) {
        return walletService.getWalletById(walletId);
    }

    @GetMapping("/customer/{customerId}")
    public Wallet getWalletByCustomer(@PathVariable Long customerId) {
        return walletService.getWalletByCustomerId(customerId);
    }

    @PutMapping("/{walletId}/balance")
    public Wallet updateWalletBalance(@PathVariable Long walletId, @RequestBody Wallet request) {
        return walletService.updateWalletBalance(walletId, request);
    }

    @PutMapping("/{walletId}/status")
    public Wallet updateWalletStatus(@PathVariable Long walletId, @RequestBody Wallet request) {
        return walletService.updateWalletStatus(walletId, request);
    }

    @DeleteMapping("/{walletId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWallet(@PathVariable Long walletId) {
        walletService.deleteWallet(walletId);
    }
}
