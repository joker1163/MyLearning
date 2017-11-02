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
                ((!getSecondName().isEmpty()) ? "<" + getSecondName() + "> ": " ")
                +  ((!getFirstName().isEmpty()) ? "<" + getFirstName() + ">, ": " , ")
                +  ((getAge()!= -1)? "<" + getAge() + "> ": " , ")
                + ((Address)getAddress()).toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Customer))return false;
        Customer tmp = (Customer) obj;
        if (!getFirstName().equals(tmp.getFirstName())) return false;
        if (!getSecondName().equals(getSecondName()))return false;
        if (getAge()!= tmp.getAge())return false;
        if (((Address)getAddress()).equals(((Address)tmp.getAddress())))return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        return getFirstName().hashCode()^
                ((Integer)getAge()).hashCode()^
                getSecondName().hashCode()^
                getAddress().hashCode();
    }
}
