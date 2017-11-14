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

    }

    public int itemsQuantity(String itemName)
    {

    }
    public int itemsQuantity(MenuItem item)
    {

    }
    public Order[] getOrders()
    {

    }
    public double ordersCostSummary()
    {

    }
    public int ordersQuantity()
    {

    }

}
