package Lunchroom;

interface Order {
    public boolean add(MenuItem item);
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
    public String toString();
    public boolean equals(Object obj);
    public int hashCode();
}
