package Lunchroom;

import java.time.LocalDate;
import java.util.ArrayList;
public class TableOrdersManager implements OrdersManager{
    private Order[] orders;

    TableOrdersManager(int n){
        if (n<0) throw new NegativeSizeException("Размер заказа не может быть отрицательным числом");
        orders=new Order[n+1];
    }

    public void add(Order order, int tableNumber)
    {
          if (tableNumber > orders.length|| tableNumber < 0) { System.out.println("Нет такого стола"); return;}
        if (orders[tableNumber]==null)  orders[tableNumber] = order;
        else System.out.println("Столик " +tableNumber +" занят");
    }

    public Order getOrder(int tableNumber)
    {
        return orders[tableNumber];
    }

    public void addItem(MenuItem item, int tableNumber)
    {
        if (orders[tableNumber]== null)  orders[tableNumber] = new TableOrder();
        orders[tableNumber].add(item);
    }

    public void remove(int tableNumber)
    {
        orders[tableNumber]=null;
    }

    public int remove(Order order)
    {
        for (int i=1;i<orders.length; i++)
        {
            if (orders[i]!=null&& orders[i].equals(order)) { orders[i]=null; return i;}
        }
        return -1;
    }

    public int removeAll(Order order)
    {
        int delOrder=0;
        for (int i=1;i<orders.length; i++)
        {
            if (orders[i]==order) { orders[i]=null; delOrder++;}
        }
        return ((delOrder>0) ?  delOrder :  -1);
    }

    public int freeTableNumber()
    {
        for (int i=1;i<orders.length; i++)
        {
            if (orders[i]==null) return i;
        }
        return 0;
    }

    public int[] freeTableNumbers()
    {
        int j=0; // индекс для хранения кол-ва занятых столов, чтобы потом использовать для сокращения кол-ва элементов массива
        int[] freeTables = new int[orders.length-1];
        for (int i=1;i<orders.length; i++)
        {
            if (orders[i]==null){ freeTables[j]=i; j++;}
        }
        if (j==0) { System.out.println("Нет свободных столиков"); return null;}
        else {

            return removeNullInArray(freeTables,j);
        }

    }

    private int[] removeNullInArray(int[] array, int j)
    {
        int[] t = new int[j];
        for (int i = 0; i < t.length; i++) {
            t[i] = array[i];
        }
        return t;
    }

    public int[] busyTableNumbers()
    {
        int[] busyTables = new int[orders.length-1];
        int j=0; // индекс для хранения кол-ва занятых столов, чтобы потом использовать для сокращения кол-ва элементов массива
        for (int i=1;i<orders.length; i++)
        {
            if (orders[i]!=null){ busyTables[j]=i; j++;}
        }
        if (j==0) { System.out.println("Нет занятых столиков"); return null;}
        else {

            return removeNullInArray(busyTables,j);
        }
    }

    public Order[] getOrders()
    {
        return orders;
    }

    public int ordersQuantity()
    {
        int ordQan=0;
        for (Order i: orders)
        {
            if (i!=null)
                ordQan+= i.itemsQuantity();
        }
        return ordQan;
    }

    public double ordersCostSummary()
    {
        double sum=0;
        for (Order i: orders)
        {
            if (i!=null)
                sum+= i.costTotal();
        }
        return sum;
    }

    public int itemsQuantity(String itemName)
    {
        int quanity=0;
        int[] busyTables = busyTableNumbers();
        for (int i=0;i<busyTables.length; i++)
        {
            if (orders[busyTables[i]].itemQuantity(itemName)> 0)
            {
                quanity+= orders[busyTables[i]].itemQuantity(itemName);
            }
        }
        return quanity;
    }

    public int itemsQuantity(MenuItem item)
    {
        int quanity=0;
        int[] busyTables = busyTableNumbers();
        for (int i=0;i<busyTables.length; i++)
        {
            if (orders[busyTables[i]].itemQuantity(item)> 0)
            {
                quanity+= orders[busyTables[i]].itemQuantity(item);
            }
        }
        return quanity;
    }

    public int getNumberOrdersInDay(LocalDate date)
    {
        int number=0;
        for (Order i: orders)
            if(i!= null && i.getTime().toLocalDate().equals(date))
                number++;
        return number;
    }
    public ArrayList getOrdersInDay(LocalDate date)
    {
        ArrayList<Order> orders = new ArrayList<Order>();
        for (Order i: orders)
            if(i!= null && i.getTime().toLocalDate().equals(date))
              orders.add(i);
        return orders;

    }
    public ArrayList getOrdersCustomer(Customer customer)
    {
        ArrayList<Order> orders = new ArrayList<Order>();
        for (Order i: orders)
            if(i!= null && i.getCustomer().equals(customer))
                orders.add(i);
        return orders;
    }


}
