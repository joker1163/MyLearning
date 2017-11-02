package Lunchroom;

public class Test {
    public static void main(String[] args) {
//

        Drink dr = new Drink(500, "Сок", DrinkTypeEnum.JUICE, "Бакал сока", 0);
        System.out.println(dr.toString());
      /*  Address add1 = new Address("Москва", 443012, "Ленинградская",
                30, 'A', 125);
        Address add3 = new Address("Ленинградская",
                30, 'A', 125);
        Address add2 = new Address("Москва", 443012, "Ленинградская",
                30, 'A', 125);
     //   Order t=new Order();
        System.out.println(add3.hashCode());
      /*  OrderManager om=new OrderManager(5);
        Order one = new Order(new Dish[]{new Dish("Селедка под шубой", 45, "Салат"),
                new Dish("Макароны по флотски", 105, "Горячее второе"),
                new Dish("Макароны по аджикски", 125, "Горячее второе")});

        Order two = new Order(new Dish[] { new Dish("Щи",84,"Суп"),
                new Dish("Бифштекс",140,"Горячее второе")});
        //one.add();

        for (Dish i: one.sortedDishesByCostDesc())
        {
            System.out.println("Блюдо: "  + i.getName() + " Стоимость: " + i.getCost() + " Описание: " + i.getDescription());
        }
        om.add(two,2);
        om.add(one,1);
       // System.out.println(om.dishQuanity("Макароны по флотски"));
        //for (int i=0; i< om.)
        //   System.out.println(om.getOrder(2));

        //  Dish[] test =;
        //  for (Dish i: om.getOrder(2).getDishes())
        //    System.out.println("Блюдо: "  + i.getName() + " Стоимость: " + i.getCost() + " Описание: " + i.getDescription());*/

    }

}
