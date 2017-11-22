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
         if (buildingNumber<=0 || apartmentNumber <=0 || !Character.isLetter(buildingLetter))
             throw new IllegalArgumentException("Номер дома или квартиры не может быть отрицательным значением, литера дома только буква");
         cityName="Самара";
         zipCode=-1;
         this.streetName=streetName;
         this.buildingLetter=buildingLetter;
         this.buildingNumber=buildingNumber;
         this.apartmentNumber=apartmentNumber;
     }

    Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber)
    {
        if (zipCode <=0 || buildingNumber<=0 || apartmentNumber <=0 || !(Character.isLetter(buildingLetter) || buildingLetter==' '))
            throw new IllegalArgumentException("Номер дома, квартиры или индекс не может быть отрицательным значением, литера дома только буква");

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
        return String.format("Address:  <%-8s> <%-6s>, <%-12s> <%-3d> <%-1c> <%-3d>",
                ((!cityName.isEmpty()) ? cityName : " ")
                ,((zipCode!=-1) ? zipCode : "")
                ,(!(streetName.isEmpty()) ? streetName: " ")
                ,((buildingNumber!= -1)? buildingNumber :"")
                ,((buildingLetter!= ' ')? buildingLetter : ' ')
                ,((apartmentNumber!= -1)?  apartmentNumber: ""));
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Address))return false;
         Address tmp = (Address) obj;
        if (!cityName.equals(tmp.cityName)) return false;
        if (apartmentNumber!= tmp.apartmentNumber)return false;
        if (zipCode!= tmp.zipCode)return false;
        if (buildingNumber!= tmp.buildingNumber)return false;
        if (!streetName.equals(tmp.streetName)) return false;
        if (buildingLetter!= tmp.buildingLetter)return false;
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
