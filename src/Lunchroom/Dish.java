package Lunchroom;

public final class Dish extends MenuItem {
 //   private double cost;
   // private String name;
  //  private String description;

    Dish(String name, String description)
    {
        super(name,description);
    }
    Dish(String name, double cost, String description)
    {
        super(name,cost,description);
    }

    /*public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/

    @Override
    public String toString()
    {
        return String.format("Dish: %-10s %-5sр. %-30s",
                ((!getName().isEmpty()) ? getName() : ",")
                ,((getCost()>0)? (double)getCost()  : " , ") + ""
                ,(!getDescription().isEmpty()) ?  getDescription() : " ");
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Dish))return false;
        Dish tmp = (Dish) obj;
        if (!getName().equals(tmp.getName())) return false;
        if (getCost()!= tmp.getCost())return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        return getName().hashCode()^
                ((Double)getCost()).hashCode()^
                getDescription().hashCode();
    }

}
