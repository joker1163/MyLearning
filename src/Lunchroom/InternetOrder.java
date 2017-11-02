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
}
