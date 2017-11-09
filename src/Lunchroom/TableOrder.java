package Lunchroom;

import java.awt.*;

public class TableOrder implements Order{
    private MenuItem[] items;
    private int size=0;
    private Customer customer;

    TableOrder(){
        items = new MenuItem[16];
    }
    TableOrder(Customer customer, int n){
        items = new MenuItem[n];
        this.customer=customer;
    }

    TableOrder(Customer customer, MenuItem[] item){
        this.items=item;
        size = item.length;
        this.customer=customer;
    }

    //// Добавление заказа в массив заказов
    public boolean add(MenuItem item)
    {
        if ( size >= this.items.length) {
            MenuItem[] t = new MenuItem[this.items.length*2];
            for (int i=0; i < size; i++)
            {
                t[i]= this.items[i];
            }
            this.items=t;
        }
            this.items[size] = item;
            size++;
            return true;
    }

    //удаляет заказ по имени из массива заказов
    public boolean remove(String itemName)
    {
        for (int i=0; i<size; i++)
        {
            if (this.items[i].getName().equals(itemName))
            {
                if (i!=size)
                {
                    int j;
                    for (j=i+1; j<size;j++, i++)
                    {
                        this.items[i]= this.items[j];
                    }
                    this.items[j]=null;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    // удаляет позицию из заказа
    public boolean remove(MenuItem item)
    { for (int i=0; i<size; i++)
        {
            if (this.items[i].equals(item))
            {
                if (i!=size)
                {
                    int j;
                    for (j=i+1; j<size;j++, i++)
                    {
                        this.items[i]= this.items[j];
                    }
                    this.items[j]=null;

                }
                size--;
                return true;
            }
        }
        return false;
    }



    public int removeAll(String itemName)
    {
        int n=0;
        for (int i=0; i<size; i++)
        {
            if (this.items[i].getName().equals(itemName))
            {
                n++;
                if (i!=size)
                {
                    int j;
                    for (j=i+1; j<size;j++, i++)
                    {
                        this.items[i]= this.items[j];
                    }
                    this.items[j]=null;
                }
                size--;
            }
        }
        return n;
    }


    public int removeAll(MenuItem item)
    {
        int n=0;
        for (int i=0; i<size; i++)
        {
            if (this.items[i].equals(item))
            {
                n++;
                if (i!=size)
                {
                    int j;
                    for (j=i+1; j<size;j++, i++)
                    {
                        this.items[i]= this.items[j];
                    }
                    this.items[j]=null;
                }
                size--;
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
        for (int i=0; i<size; i++) {
            if (this.items[i].getName().equals(itemName)) {
                n++;
            }
        }
        return n;
    }


    public int itemQuantity(MenuItem item)
    {
        int n=0;
        for (int i=0; i<size; i++) {
            if (this.items[i].equals(item)) {
                n++;
            }
        }
        return n;
    }



    public MenuItem[] getItems()
    {
        MenuItem[] t = new MenuItem[size];
        if (size != 0) {
            for (int i = 0; i< size; i++)
            {
                t[i]=this.items[i];
            }
        }
        return t;
    }

    public double costTotal()
    {
        double cost = 0;
        for (MenuItem i: this.items)
        {
            cost+=i.getCost();
        }
        return cost;
    }

    public String[] itemsNames()
    {
        String[] names= new String[size];
        int t=0;
        for (int i=0; i<size;i++)
        {
            if (!names.equals(this.items[i].getName()))
            {
                names[t]= this.items[i].getName();
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

    public MenuItem[] sortedDishesByCostDesc()    {
        MenuItem t;
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

    @Override
    public String toString()
   {
        String itemStr = "\n";
        for (MenuItem i: items)
            itemStr+= i.toString()+"\n";
        return "TableOrder: " + size + itemStr;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof TableOrder))return false;
        TableOrder t = (TableOrder)obj;
        if (!customer.equals(t.getCustomer()))return false;
        if (size != t.size)return false;  // ТУТ БЫЛО .itemsQuantity() ВМЕСТО SIZE
           //  MenuItem[] obj1 = getItems();
        //MenuItem[] obj2 = t.getItems();
        MenuItem[] obj2 = t.getItems().clone(); // делаем клон объекта
        for (int i=0;i<itemsQuantity(); i++) {
            for (int j = 0; i < obj2.length;  j++) {
                if (getItems()[i].equals(obj2[j])) {
                    obj2=remove(obj2[j],obj2);  // удаляем найденные позиции из второго объекта чтобы они учитывались на следующей итерации
                    break;
                }
            }
            return false;
        }
        return true;
    }

    public MenuItem[] remove(MenuItem item, MenuItem[] items)
    { for (int i=0; i<size; i++)
    {
        if (items[i].equals(item))
        {
            if (i!=size)
            {
                for (int j=i+1; j<size;j++, i++)
                {
                    items[i]= items[j];
                }

            }
            size--;
        }
    }
        return items;
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


