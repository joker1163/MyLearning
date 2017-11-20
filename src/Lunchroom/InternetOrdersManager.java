package Lunchroom;

import java.time.LocalDate;
import java.util.ArrayList;

public class InternetOrdersManager implements OrdersManager {

    private QueueNode head;
    private QueueNode tail;
    private int size=0;
    private class QueueNode
    {
        QueueNode next;
        QueueNode prev;
        Order value;

        QueueNode(QueueNode next, QueueNode prev, Order value)
        {
            this.next=next;
            this.prev=prev;
            this.value=value;
        }
    }

    InternetOrdersManager()
    {
      head=tail=null;
    }

    InternetOrdersManager(Order[] orders)
    {
        if(orders!=null)
        {
            for (Order i:orders)
                if (i!=null)
                add(i);
        }
    }

    public boolean add(Order order)
    {
        if (head==null)
        {
            head = new QueueNode(null,null, order);
            tail=head;
        }
        else
        {
            tail.next = new QueueNode(null,tail,order);
            tail=tail.next;
        }
        ++size;
        return true;
    }

    public Order remove()
    {
        Order t=null;
        if (head!=null)
        {
            t= head.value;
            head = head.next;
            head.prev=null;
        }
        --size;
        return t;
    }

    public Order order()
    {
        if (head!=null)
        {
           return head.value;
        }
        return null;
    }

    public int itemsQuantity(String itemName)
    {
        int count=0;
        if (head==null) return 0;
        QueueNode t = head;
        while (t!= null)        {

            if (t.value.itemQuantity(itemName)> 0)
            {
                count += t.value.itemQuantity(itemName);
            }
            t=t.next;
        }
        return count;
    }
    public int itemsQuantity(MenuItem item)
    {
        int count=0;
        if (head==null) return 0;
        QueueNode t = head;
        while (t!= null)        {

            if (t.value.itemQuantity(item)> 0)
            {
                count += t.value.itemQuantity(item);
            }
            t=t.next;
        }
        return count;
    }
    public Order[] getOrders()
    {
        Order[] tempOrder = new Order[size];
        int i = 0;
        QueueNode t = head;
        while (t!= null)
        {
            tempOrder[i] = t.value;
            i++;
            t=t.next;
        }
        return tempOrder;
    }
    public double ordersCostSummary()
    {
        double sum=0;
        QueueNode t = head;
        while (t!= null)
        {
            sum+=t.value.costTotal();
            t=t.next;
        }
        return sum;
    }
    public int ordersQuantity()
    {
        return size;
    }

    public int getNumberOrdersInDay(LocalDate date)
    {
        int number=0;
        QueueNode t = head;
        while (t!= null)
        {
            if(t.value.getTime().toLocalDate().equals(date))
                number++;
            t=t.next;
        }

        return number;
    }
    public ArrayList getOrdersInDay(LocalDate date)
    {
        ArrayList<Order> orders = new ArrayList<Order>();
        QueueNode t = head;
        while (t!= null) {
            if (t.value.getTime().toLocalDate().equals(date))
                orders.add(t.value);
            t = t.next;
        }
        return orders;

    }
    public ArrayList getOrdersCustomer(Customer customer)
    {
        ArrayList<Order> orders = new ArrayList<Order>();
        QueueNode t = head;
        while (t!= null) {
            if (t.value.getCustomer().equals(customer))
                orders.add(t.value);
        }
        return orders;
    }


}
