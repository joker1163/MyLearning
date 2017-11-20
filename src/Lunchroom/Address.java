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
        return String.format("Address: %-4s ",
                ((!cityName.isEmpty()) ? "<" + cityName + "> ": " ")
                ,((zipCode!=-1) ? "<" + zipCode + ">, ": " , ")
                ,(!(streetName.isEmpty()) ? "<" + streetName + "> ": " ")
                ,((buildingNumber!= -1)? "<" + buildingNumber+ "> ": " ")
                ,((buildingLetter!= ' ')? "<" + buildingLetter + "> ": " ")
                ,((apartmentNumber!= -1)? "<" + apartmentNumber + "> ": " "));
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Address))return false;
         Address tmp = (Address) obj;
        if (!cityName.equals(tmp.getCityName())) return false;
        if (apartmentNumber!= tmp.getApartmentNumber())return false;
        if (zipCode!= tmp.getZipCode())return false;
        if (buildingNumber!= tmp.getBuildingNumber())return false;
        if (!streetName.equals(tmp.getStreetName())) return false;
        if (buildingLetter!= tmp.getBuildingLetter())return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        return streetName.hashCode()^
                ((Integer)buildingNumber).hashCode()^
                cityName.hashCode()^
                ((Integer)apartmentNumber).hashCode()^
                ((Integer)zipCode).hashCode()^
                ((Character)buildingLetter).hashCode();
    }
}
