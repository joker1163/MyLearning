package Lunchroom;

public class  Test {
    public static void main(String[] args) {
//

        //// инициализация напитков
        MenuItem juice = new Drink(100, "Сок", DrinkTypeEnum.JUICE, "Бакал сока", 0);
        MenuItem coffe = new Drink(50, "Кофе", DrinkTypeEnum.COFFE, "Кофе черный расторивый", 0);
        MenuItem greenTea = new Drink(300, "Зеленый чай", DrinkTypeEnum.GREEN_TEA, "Зеленый чай с мелисой", 0);
        MenuItem beer = new Drink(150, "Пиво", DrinkTypeEnum.BEER, "Бакал чешского пива", 5.5);
        MenuItem milk = new Drink(88, "Молоко", DrinkTypeEnum.MILK, "Стакан молока", 0);

        //// инициализация блюд
        MenuItem borch = new Dish("Борщ", 88, "Тарелка борща");
        MenuItem omlette = new Dish("Яишница", 30, "Яйишница из свежих яйиц");
        MenuItem glutton = new Dish("Обжорка", 45, "Салат обжорка с курицей");
        MenuItem pasta = new Dish("Макароны по флотски", 70, "Макароны по флотски в соусе");
        MenuItem potato = new Dish("Картошка по французски", 75, "Картошка по французски с сыром");

        //// инициализация покупателей
        Customer cust1 = new Customer("Илья", "Слепушов", 25,
                new Address("Самара", 443124, "5-я просека", 110, 'д', 199));

        Customer cust2 = new Customer("Екатерина", "Слепушова", 24,
                new Address("Самара", 443064, "Карбышева", 65, ' ', 152));

        //// иниз заказов
        Order oneOrder = new TableOrder(cust1, new MenuItem[] {omlette, juice, borch,pasta});
        Order twoOrder = new TableOrder(cust1, new MenuItem[] {juice, borch,pasta,omlette});
        String[] t = twoOrder.itemsNames();
      //  for (String i:t)
        //{
            System.out.println(twoOrder.equals(oneOrder));

       // }
      //  System.out.println();


        // System.out.println(dr.toString());
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
