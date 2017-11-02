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
        return ((!getName().isEmpty()) ? "<" + getName() + "> ": ",")
                +  ((getCost()>0)? "<" + getCost() + "> ": " , ") + " р.";
    }

    @Override
    public boolean equals(Object obj)
    {

        MenuItem tmp = (MenuItem) obj;
        if (!getName().equals(tmp.getName())) return false;
        if (getCost()!= tmp.getCost())return false;
        return true;
    }

    @Override
    public int hashCode() {
        return getName().hashCode() ^
                ((Double) getCost()).hashCode() ^
                getDescription().hashCode();
    }


}
