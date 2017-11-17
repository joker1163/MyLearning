package Lunchroom;

public class InternetOrder implements Order {
    private int size=0;
    private ListNode head=null;
    private ListNode tail=null;
    ///    private MenuItem[] items;   - если мы не парсим массив в список
    private MenuItem item;
    private Customer customer;

    private class ListNode {
       private MenuItem value;
        private ListNode next;

        ListNode(MenuItem value, ListNode next)
        {
            this.value=value;
            this.next=next;
        }

    }



    InternetOrder ()
    {
        //head=new ListNode(null,null);
       head= null;
    }

    InternetOrder( Customer customer, MenuItem[] items)
    {
        for (MenuItem i: items)
            addBack(i);
        this.customer=customer;
        //this.size=items.length;
    }


    public void addBack(MenuItem value)
    {
        if(head==null)
        {
            head = new ListNode(value, null);
            tail=head;
        }
        else
        {
            tail.next = new ListNode(value, null);
            tail=tail.next;

        }
        ++size;
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
            while (t!=null)
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
            while (t!=null)
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
            while (t!=null)
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
            while (t!=null)
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
        while (t!=null)
        {

            if(t.value.getName().equals(itemName))
            {
               n++;
                t=t.next;
            }
            else                 t=t.next;
        }

        return n;
    }
    public int itemQuantity(MenuItem item)
    {
        int n=0;
        ListNode t = head;
        while (t!=null)
        {

            if(t.value.equals(item))
            {
                n++;
                t=t.next;
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
            while (tempNode!=null)
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
        while (tempNode!=null)
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
        while (tempNode!=null)
        {
            if (!names.equals(tempNode.value.getName()))
            {
                names[t]= tempNode.value.getName();

                t++;
            }
            tempNode=tempNode.next;
        }
        String[] temp= new String[t];
        for (int i=0; i<t;i++)
        {
            temp[i]=names[i];
        }
        return temp;
    }
    public MenuItem[] sortedDishesByCostDesc(){
        return new MenuItem[10];
       /* ListNode ln;

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

/*
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
        return items;*/
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString()
    {
        String itemStr = "\n";
        ListNode tempNode = head;
        while (tempNode!=null)
        {
            itemStr+=tempNode.value.toString()+ "\n";
            tempNode=tempNode.next;
        }
        return "Internet order: " +"\n" + customer.toString()+ "\n" + size + itemStr;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof InternetOrder))return false;
        InternetOrder t = (InternetOrder)obj;
        if (!customer.equals(t.getCustomer()))return false;
        if (size != t.size)return false;  // ТУТ БЫЛО .itemsQuantity() ВМЕСТО SIZE
        //  MenuItem[] obj1 = getItems();
        //MenuItem[] obj2 = t.getItems();
        MenuItem[] item = getItems();
        MenuItem[] itemsObj = t.getItems().clone(); // делаем клон объекта
        for (int i=0;i<itemsQuantity(); i++) {
            for (int j = 0; i < itemsObj.length;  j++) {
                if (item[i].equals(itemsObj[j])) {
                    itemsObj=remove(itemsObj[j],itemsObj,t.size);  // удаляем найденные позиции из второго объекта чтобы они учитывались на следующей итерации
                    break;
                }
            }
            return false;
        }
        return true;
    }





    @Override
    public int hashCode()
    {
        MenuItem[] mi = getItems();
        if (mi.length > 0) {
            int hash = mi[0].hashCode();
            for (int i = 1; i < mi.length ; i++) {
                hash ^= mi[i].hashCode();
            }
            return hash^
                    customer.hashCode()^
                    ((Integer)size).hashCode();
        }
        return 0;
    }

}
