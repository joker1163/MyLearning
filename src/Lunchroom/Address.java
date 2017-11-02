package Lunchroom;

public final class Address {
     private final String cityName;
     private final int zipCode;
     private final String streetName;
     private final int buildingNumber;
     private final char buildingLetter;
     private final int apartmentNumber;
     public static final Address add=new Address();  // зачем он тут нужен?

     Address()
     {
         cityName="";
         zipCode=-1;
         streetName="";
         buildingNumber=-1;
         buildingLetter=' ';
         apartmentNumber=-1;

     }

     Address(String streetName, int buildingNumber, char buildingLetter, int apartmentNumber)
     {
         cityName="Самара";
         zipCode=-1;
         this.streetName=streetName;
         this.buildingLetter=buildingLetter;
         this.buildingNumber=buildingNumber;
         this.apartmentNumber=apartmentNumber;
     }

    Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber)
    {
        this.cityName=cityName;
        this.zipCode=zipCode;
        this.streetName=streetName;
        this.buildingLetter=buildingLetter;
        this.buildingNumber=buildingNumber;
        this.apartmentNumber=apartmentNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    @Override
    public String toString()
    {
        return "Address: " +
                ((!getCityName().isEmpty()) ? "<" + getCityName() + "> ": " ")
                + ((getZipCode()!=-1) ? "<" + getZipCode() + ">, ": " , ")
                + (!(getStreetName().isEmpty()) ? "<" + getStreetName() + "> ": " ")
                + ((getBuildingNumber()!= -1)? "<" + getBuildingNumber() + "> ": " ")
                + ((getBuildingLetter()!= ' ')? "<" + getBuildingLetter() + "> ": " ")
                + ((getApartmentNumber()!= -1)? "<" + getApartmentNumber() + "> ": " ");
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Address))return false;
         Address tmp = (Address) obj;
        if (!getCityName().equals(tmp.getCityName())) return false;
        if (getApartmentNumber()!= tmp.getApartmentNumber())return false;
        if (getZipCode()!= tmp.getZipCode())return false;
        if (getBuildingNumber()!= tmp.getBuildingNumber())return false;
        if (!getStreetName().equals(tmp.getStreetName())) return false;
        if (getBuildingLetter()!= tmp.getBuildingLetter())return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        return getStreetName().hashCode()^
                ((Integer)getBuildingNumber()).hashCode()^
                getCityName().hashCode()^
                ((Integer)getApartmentNumber()).hashCode()^
                ((Integer)getZipCode()).hashCode()^
                ((Character)getBuildingLetter()).hashCode();
    }
}
