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
    public MenuItem[] getItems()
    {
        MenuItem[] tempItems = new MenuItem[size];
        int i=0;
        if (size != 0) {
            ListNode tempNode = head;
            while (tempNode.next!=null)
            {
                tempItems[i]= tempNode.value;
                i++;
                tempNode=tempNode.next;
            }
        }
        return tempItems;
    }
    public double costTotal(){
        double cost = 0;
        ListNode tempNode = head;
        while (tempNode.next!=null)
        {
            cost+= tempNode.value.getCost();
            tempNode=tempNode.next;
        }
        return cost;
    }
    public String[] itemsNames()
    {
        String[] names= new String[size];
        int t=0;
        ListNode tempNode = head;
        while (tempNode.next!=null)
        {
            if (!names.equals(tempNode.value.getName()))
            {
                names[t]= tempNode.value.getName();
                tempNode=tempNode.next;
                t++;
            }
        }
        String[] temp= new String[t];
        for (int i=0; i<t;i++)
        {
            temp[i]=names[i];
        }
        return temp;
    }
    public MenuItem[] sortedDishesByCostDesc(){
        ListNode ln;

        MenuItem t;

        for (ListNode i=head; i.next!=null;i=i.next) {
            if (i.next!=tail)
            {
                if (i.value.getCost()<i.next.value.getCost())
                {
                    ln = i.next;
                    i.next=i;
                    i=ln;
                    t=items[j-1];
                    items[j-1] =items[j];
                    items[j]=t;
                }
            }
        }
        ListNode tempNode = head;
        while (tempNode.next!=null)
        {

        }


        for(int i=0; i< size;i++ )
        {
            for(int j=size-1; j>i; j--)
            {
                if (items[j].getCost()>items[j-1].getCost())
                {
                    t=items[j-1];
                    items[j-1] =items[j];
                    items[j]=t;
                }
            }
        }
        return items;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

}
