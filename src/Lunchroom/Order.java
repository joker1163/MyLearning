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

    default   public MenuItem[] remove(MenuItem item, MenuItem[] items, int size)
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
}
