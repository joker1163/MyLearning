package Lunchroom;

interface Alcoholable {
    default boolean isAlcoholicDrink()
    {
        return (getAlcoholVol()>0) ? true: false;
    }
    double getAlcoholVol();
}
