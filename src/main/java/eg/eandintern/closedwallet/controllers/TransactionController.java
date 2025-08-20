package eg.eandintern.closedwallet.controllers;

import Entities.Transaction;
import walletservices.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // 🔹 All transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // 🔹 Purchases (system-wide)
    @GetMapping("/purchases")
    public List<Transaction> getPurchaseTransactions() {
        return transactionService.getPurchaseTransactions();
    }

    // 🔹 Refunds (system-wide)
    @GetMapping("/refunds")
    public List<Transaction> getRefundTransactions() {
        return transactionService.getRefundTransactions();
    }

    // 🔹 All transactions by customer
    @GetMapping("/customer/{customerId}")
    public List<Transaction> getTransactionsByCustomer(@PathVariable Long customerId) {
        return transactionService.getTransactionsByCustomer(customerId);
    }

    // 🔹 Purchases by customer
    @GetMapping("/customer/{customerId}/purchases")
    public List<Transaction> getPurchaseTransactionsByCustomer(@PathVariable Long customerId) {
        return transactionService.getPurchaseTransactionsByCustomer(customerId);
    }

    // 🔹 Refunds by customer
    @GetMapping("/customer/{customerId}/refunds")
    public List<Transaction> getRefundTransactionsByCustomer(@PathVariable Long customerId) {
        return transactionService.getRefundTransactionsByCustomer(customerId);
    }

    // 🔹 Get purchase for a refund
    @GetMapping("/{refundId}/purchase")
    public Transaction getPurchaseForRefund(@PathVariable Long refundId) {
        return transactionService.getPurchaseForRefund(refundId);
    }

    // 🔹 Get refunds for a purchase
    @GetMapping("/{purchaseId}/refunds")
    public List<Transaction> getRefundsForPurchase(@PathVariable Long purchaseId) {
        return transactionService.getRefundsForPurchase(purchaseId);
    }
}
