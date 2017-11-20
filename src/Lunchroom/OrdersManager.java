package Lunchroom;

import java.time.LocalDate;
import java.util.ArrayList;

interface OrdersManager {
    public int itemsQuantity(String itemName);
    public int itemsQuantity(MenuItem item);
    public Order[] getOrders();
    public double ordersCostSummary();
    public int ordersQuantity();
    public int getNumberOrdersInDay(LocalDate date);
    public ArrayList getOrdersInDay(LocalDate date);
    public ArrayList getOrdersCustomer(Customer customer);
}
