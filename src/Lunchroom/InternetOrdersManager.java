package Lunchroom;

public class InternetOrdersManager implements OrdersManager {

    public QueueNode head;
    public QueueNode tail;
    public int size=0;
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
        while (t.next!= null)        {

            if (t.next.value.itemQuantity(itemName)> 0)
            {
                count += t.next.value.itemQuantity(itemName);
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
        while (t.next!= null)        {

            if (t.next.value.itemQuantity(item)> 0)
            {
                count += t.next.value.itemQuantity(item);
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
        while (t.next!= null)
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
        while (t.next!= null)
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

}
