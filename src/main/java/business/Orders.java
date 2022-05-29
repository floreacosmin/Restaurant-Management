package business;

import java.time.LocalDateTime;
import java.util.Objects;

public class Orders {
    private int orderID;
    private int clientID;
    private LocalDateTime orderDate;

    public Orders(int orderID, int clientID) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.orderDate = LocalDateTime.now();
    }

    public int getOrderID() {
        return orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public int hashCode() {
        return Objects.hash(orderID);
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Orders ord = (Orders) obj;
        return orderID == ord.getOrderID();
    }
}
