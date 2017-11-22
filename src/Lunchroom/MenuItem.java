package Lunchroom;

abstract class MenuItem {
    private double cost;
    private String name;
    private String description;

    protected MenuItem(String name, String description)
    {
        this.name=name;
        this.description=description;
        this.cost=0;
    }
    protected MenuItem(String name, double cost, String description)
    {
        if (cost < 0 )  throw new IllegalArgumentException("Мы сами оплачиваем еду?");
        this.name=name;
        this.description=description;
        this.cost=cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override

    public String toString()
    {
        return String.format("<%-8s>, <%-5.2f> р.",((!name.isEmpty()) ? name : " , ")
               ,((cost>0)? cost : "") + " р.");
    }

    @Override
    public boolean equals(Object obj)
    {

        MenuItem tmp = (MenuItem) obj;
        if (!name.equals(tmp.getName())) return false;
        if (cost!= tmp.getCost())return false;
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode() ^
                ((Double) cost).hashCode() ^
                description.hashCode();
    }


}
