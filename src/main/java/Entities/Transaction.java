package Entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    // ✅ Quoted so Oracle can accept the reserved word
    @Column(name = "\"TYPE\"")
    private String type;

    // ✅ Quoted so Oracle can accept the reserved word
    @Column(name = "\"DATE\"")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_transaction")
    private Transaction refTransaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemTransaction> itemTransactions;

    public Transaction() {}

    public Transaction(String type, Date date, Double amount, Customer customer) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.customer = customer;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Transaction getRefTransaction() {
        return refTransaction;
    }

    public void setRefTransaction(Transaction refTransaction) {
        this.refTransaction = refTransaction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ItemTransaction> getItemTransactions() {
        return itemTransactions;
    }

    public void setItemTransactions(List<ItemTransaction> itemTransactions) {
        this.itemTransactions = itemTransactions;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "orderId=" + orderId +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
