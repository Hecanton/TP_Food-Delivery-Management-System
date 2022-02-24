package BusinessLogic;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {
    private int orderId;
    private int userId;
    private Date date;
    private int time;

    public Order(int orderId, int userId, Date date, int time) {
        this.orderId = orderId;
        this.userId = userId;
        this.date = date;
        this.time = time;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int hashCode() {
        return Objects.hash(getOrderId(), getUserId(), getDate(), getTime());}

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;
        Order ord = (Order) obj;
        return getOrderId() == ord.getOrderId() && getUserId() == ord.getUserId() && getTime() == ord.getTime() && getDate().equals(ord.getDate());
    }
    public String toString(){
        return "Order: " + " orderId=" + orderId + ", userId=" + userId + ", date=" + date + ", time=" + time +"\n";
    }
}
