package Lunchroom;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import java.time.LocalDate;
public final class Customer {
    private final String firstName;
    private final String secondName;
    private final LocalDate birthDate;
    private final Address address;

    public static final Customer customer = new Customer(LocalDate.now().minusYears(21));
    public static final Customer customer_ = new Customer(LocalDate.now().minusYears(14));


    Customer()
    {
        address = Address.add;
        firstName = "";
        secondName="";
        birthDate = LocalDate.of(0000,00,00);
    }

    Customer(LocalDate age)
    {
        address = Address.add;
        firstName = "";
        secondName="";
        this.birthDate = age;
    }

    Customer(String firstName, String secondName,LocalDate age, Address address)
    {
        this.address = address;
        this.firstName = firstName;
        this.secondName=secondName;
        this.birthDate =age;
    }

    public int getAge() {
        return this.birthDate.getYear()- LocalDate.now().getYear();
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
                +  ((birthDate!= LocalDate.of(0000,00,00))? "<" + birthDate.toString() + "> ": " , ")
                + address.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Customer))return false;
        Customer tmp = (Customer) obj;
        if (!firstName.equals(tmp.getFirstName())) return false;
        if (!secondName.equals(getSecondName()))return false;
        if (getAge()!= tmp.getAge())return false;
        if (address.equals(((Address)tmp.getAddress())))return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        return firstName.hashCode()^
                ((Integer)getAge()).hashCode()^
                secondName.hashCode()^
                address.hashCode();
    }
}
