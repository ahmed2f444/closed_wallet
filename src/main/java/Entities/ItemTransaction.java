package Entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item_transaction")
@IdClass(ItemTransactionId.class)
public class ItemTransaction {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "refund_status")
    private String refundStatus;

    // Constructors
    public ItemTransaction() {}

    public ItemTransaction(Transaction transaction, Item item, String refundStatus) {
        this.transaction = transaction;
        this.item = item;
        this.refundStatus = refundStatus;
    }

    // Getters and setters
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }
}

