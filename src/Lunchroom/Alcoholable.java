package Lunchroom;

import java.time.LocalTime;

interface Alcoholable {
    final static LocalTime TIME_ALCOHOL = LocalTime.of(22,00);

    default boolean isAlcoholicDrink()
    {
        return (getAlcoholVol()>0) ? true: false;
    }
    double getAlcoholVol();
}
