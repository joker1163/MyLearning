package Lunchroom;

public final class Drink extends MenuItem implements Alcoholable {
    private final double alcoholVol;
    private final DrinkTypeEnum type;

    Drink(String name, DrinkTypeEnum type)
    {
        super(name,0,"");
        this.type = type;
        this.alcoholVol = 0;
    }
    Drink(double cost, String name, DrinkTypeEnum type, String description)
    {
        super(name,cost,description);
        this.type = type;
        this.alcoholVol = 0;
    }

    Drink(double cost, String name, DrinkTypeEnum type, String description,  double alcoholVol)
    {
        super(name,cost,description);
        this.type = type;
        this.alcoholVol = alcoholVol;
    }

    public DrinkTypeEnum getType() {
        return type;
    }
    public double getAlcoholVol()
    {
        return alcoholVol;
    }

    @Override

    public String toString()
    {
        return "Drink: "
                + "<" + type + ">"
                + ((!getName().isEmpty()) ? "<" + getName() + "> ": " , ")
                +  ((getCost()>0)? "<" + getCost() + "> ": " , ") + " р. "
                +  (isAlcoholicDrink()? "Alchohol:  <" + getAlcoholVol() + "> %. ": " ")
                +  ((!getDescription().isEmpty()) ? " <" + getDescription() + ">. ": ".");
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Drink))return false;
        Drink tmp = (Drink) obj;
        if (getType() != tmp.getType()) return false;
        if (getCost()!= tmp.getCost())return false;
        if (getAlcoholVol() != tmp.getAlcoholVol()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return getName().hashCode() ^
                ((Double) getCost()).hashCode() ^
                getDescription().hashCode() ^
                ((Double)getAlcoholVol()).hashCode();
    }
}
