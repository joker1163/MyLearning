package Lunchroom;

public class InternetOrder implements Order {
    private int size=0;
    private ListNode head=null;
    private ListNode tail=null;
    private MenuItem[] items;
    private Customer customer;

    private class ListNode {
        MenuItem value;
        ListNode next;

        ListNode(MenuItem value, ListNode next)
        {
            this.value=value;
            this.next=next;
        }
    }

    InternetOrder ()
    {
        head=null;
    }

    InternetOrder(MenuItem[] items, Customer customer)
    {
        this.items=items;
        this.customer=customer;
        this.size=items.length;
    }


    public boolean add(MenuItem item)
    {
        if(head==null)
        {
            head = new ListNode(item,null);
            tail=head;
        }
        else
        {
            tail.next = new ListNode(item,null);
            tail=tail.next;

        }
        ++size;
        return true;
    }
    public boolean remove(String itemName);
    public boolean remove(MenuItem item);
    public int removeAll(String itemName);
    public int removeAll(MenuItem item);
    public int itemsQuantity();
    public int itemQuantity(String itemName);
    public int itemQuantity(MenuItem item);
    public MenuItem[] getItems();
    public double costTotal();
    public String[] itemsNames();
    public MenuItem[] sortedDishesByCostDesc();
    public void setCustomer(Customer customer);
    public Customer getCustomer();
}
