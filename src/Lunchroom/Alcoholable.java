package Lunchroom;

interface Alcoholable {
    default boolean isAlcoholicDrink()
    {
        if (getAlcoholVol()>0) return true;
        else return false;
    }
    double getAlcoholVol();
}
