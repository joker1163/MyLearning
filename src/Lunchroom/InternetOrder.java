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
    public boolean remove(String itemName)
    {
        if(head==null) {
            return false;
        }
        if (head==tail)
        {
            if (head.value.getName().equals(itemName))
            {
                head=tail=null;
                size=0;
                return true;
            }
        }
        if (head.value.getName().equals(itemName))
        {
            head=head.next;
            size--;
            return true;
        }
        else {
            ListNode t = head;
            while (t.next!=null)
            {

                if(t.next.value.getName().equals(itemName))
                {
                    if (tail==t.next)
                    {
                        tail=t;
                    }
                    t.next=t.next.next;
                    size--;
                    return true;
                }
                else                 t=t.next;
            }
        }
        return false;
    }
    public boolean remove(MenuItem item)
    {
        if(head==null) {
            return false;
        }
        if (head==tail)
        {
            if (head.value.equals(item))
            {
                head=tail=null;
                size=0;
                return true;
            }
        }
        if (head.value == item)
        {
            head=head.next;
            size--;
            return true;
        }
        else {
            ListNode t = head;
            while (t.next!=null)
            {

                if(t.next.value == item)
                {
                    if (tail==t.next)
                    {
                        tail=t;
                    }
                    t.next=t.next.next;
                    size--;
                    return true;
                }
                else                 t=t.next;
            }
        }
        return false;
    }
    public int removeAll(String itemName)
    {
        int n=0;
        if(head==null) {
            return n;
        }
        if (head==tail)
        {
            if (head.value.getName().equals(itemName))
            {
                head=tail=null;
                size=0;

                return ++n;
            }
        }
        if (head.value.getName().equals(itemName))
        {
            head=head.next;
            size--;
            return ++n;
        }
        else {
            ListNode t = head;
            while (t.next!=null)
            {

                if(t.next.value.getName().equals(itemName))
                {
                    if (tail==t.next)
                    {
                        tail=t;
                    }
                    t.next=t.next.next;
                    size--;
                   n++;
                }
                else                 t=t.next;
            }
        }
        return n;
    }
    public int removeAll(MenuItem item)
    {
        int n=0;

        if(head==null) {
            return n;
        }
        if (head==tail)
        {
            if (head.value.equals(item))
            {
                head=tail=null;
                size=0;
                return ++n;
            }
        }
        if (head.value == item)
        {
            head=head.next;
            size--;
            return ++n;
        }
        else {
            ListNode t = head;
            while (t.next!=null)
            {

                if(t.next.value == item)
                {
                    if (tail==t.next)
                    {
                        tail=t;
                    }
                    t.next=t.next.next;
                    size--;
                    n++;
                }
                else                 t=t.next;
            }
        }

        return n;
    }
    public int itemsQuantity()
    {
        return size;
    }
    public int itemQuantity(String itemName)
    {
        int n=0;
        ListNode t = head;
        while (t.next!=null)
        {

            if(t.next.value.getName().equals(itemName))
            {
               n++;
            }
            else                 t=t.next;
        }

        return n;
    }
    public int itemQuantity(MenuItem item)
    {
        int n=0;
        ListNode t = head;
        while (t.next!=null)
        {

            if(t.next.value.equals(item))
            {
                n++;
            }
            else                 t=t.next;
        }

        return n;
    }
    public MenuItem[] getItems();
    public double costTotal();
    public String[] itemsNames();
    public MenuItem[] sortedDishesByCostDesc();

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

}
