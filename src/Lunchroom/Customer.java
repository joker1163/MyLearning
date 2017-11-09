package Lunchroom;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;

public class Customer {
    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;

    public static final Customer customer = new Customer(21);
    public static final Customer customer_ = new Customer(14);


    Customer()
    {
        address = Address.add;
        firstName = "";
        secondName="";
        age = -1;
    }

    Customer(int age)
    {
        address = Address.add;
        firstName = "";
        secondName="";
        this.age = age;
    }

    Customer(String firstName, String secondName,int age, Address address)
    {
        this.address = address;
        this.firstName = firstName;
        this.secondName=secondName;
        this.age =age;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }


    @Override
    public String toString()
    {
        return "Customer: " +
                ((!secondName.isEmpty()) ? "<" + secondName + "> ": " ")
                +  ((!firstName.isEmpty()) ? "<" + firstName + ">, ": " , ")
                +  ((age!= -1)? "<" + age + "> ": " , ")
                + address.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Customer))return false;
        Customer tmp = (Customer) obj;
        if (!firstName.equals(tmp.getFirstName())) return false;
        if (!secondName.equals(getSecondName()))return false;
        if (age!= tmp.getAge())return false;
        if (address.equals(((Address)tmp.getAddress())))return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        return firstName.hashCode()^
                ((Integer)age).hashCode()^
                secondName.hashCode()^
                address.hashCode();
    }
}
