package Entities;

import java.io.Serializable;
import java.util.Objects;

public class ItemTransactionId implements Serializable {
    private Long transaction;
    private Long item;

    public ItemTransactionId() {}

    public ItemTransactionId(Long transaction, Long item) {
        this.transaction = transaction;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemTransactionId)) return false;
        ItemTransactionId that = (ItemTransactionId) o;
        return Objects.equals(transaction, that.transaction) &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction, item);
    }
}
