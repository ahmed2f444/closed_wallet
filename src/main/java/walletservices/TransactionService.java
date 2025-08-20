package walletservices;

import Entities.Transaction;
import Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // 🔹 All transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // 🔹 Purchases (system-wide)
    public List<Transaction> getPurchaseTransactions() {
        return transactionRepository.findByType("PURCHASE");
    }

    // 🔹 Refunds (system-wide)
    public List<Transaction> getRefundTransactions() {
        return transactionRepository.findByType("REFUND");
    }

    // 🔹 All transactions for a customer
    public List<Transaction> getTransactionsByCustomer(Long customerId) {
        return transactionRepository.findByCustomer(
                new Entities.Customer() {{ setCustomerId(customerId); }}
        );
    }

    // 🔹 Purchases for a customer
    public List<Transaction> getPurchaseTransactionsByCustomer(Long customerId) {
        return getTransactionsByCustomer(customerId).stream()
                .filter(t -> "PURCHASE".equalsIgnoreCase(t.getType()))
                .toList();
    }

    // 🔹 Refunds for a customer
    public List<Transaction> getRefundTransactionsByCustomer(Long customerId) {
        return getTransactionsByCustomer(customerId).stream()
                .filter(t -> "REFUND".equalsIgnoreCase(t.getType()))
                .toList();
    }

    // 🔹 Get the purchase linked to a refund
    public Transaction getPurchaseForRefund(Long refundId) {
        Transaction refund = transactionRepository.findById(refundId)
                .orElseThrow(() -> new RuntimeException("Refund not found with ID: " + refundId));

        if (!"REFUND".equalsIgnoreCase(refund.getType())) {
            throw new RuntimeException("Transaction " + refundId + " is not a refund.");
        }

        return refund.getRefTransaction();
    }

    // 🔹 Get all refunds linked to a purchase
    public List<Transaction> getRefundsForPurchase(Long purchaseId) {
        Transaction purchase = transactionRepository.findById(purchaseId)
                .orElseThrow(() -> new RuntimeException("Purchase not found with ID: " + purchaseId));

        if (!"PURCHASE".equalsIgnoreCase(purchase.getType())) {
            throw new RuntimeException("Transaction " + purchaseId + " is not a purchase.");
        }

        return transactionRepository.findAll().stream()
                .filter(t -> t.getRefTransaction() != null
                        && t.getRefTransaction().getOrderId().equals(purchaseId))
                .toList();
    }
}
