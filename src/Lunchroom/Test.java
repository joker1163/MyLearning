package Lunchroom;

import java.time.LocalDate;

public class  Test {
    public static void main(String[] args) {
//
        MenuItem mi;
        //// инициализация напитков
        Drink juice = new Drink(100, "Сок", DrinkTypeEnum.JUICE, "Бакал сока", 0);
        Drink coffe = new Drink(50, "Кофе", DrinkTypeEnum.COFFE, "Кофе черный расторивый", 0);
        Drink greenTea = new Drink(300, "Зеленый чай", DrinkTypeEnum.GREEN_TEA, "Зеленый чай с мелисой", 0);
        Drink beer = new Drink(150, "Пиво", DrinkTypeEnum.BEER, "Бакал чешского пива", 5.5);
        Drink milk = new Drink(88, "Молоко", DrinkTypeEnum.MILK, "Стакан молока", 0);

        //// инициализация блюд
        Dish borch = new Dish("Борщ", 88, "Тарелка борща");
        Dish omlette = new Dish("Яишница", 30, "Яйишница из свежих яйиц");
        Dish glutton = new Dish("Обжорка", 45, "Салат обжорка с курицей");
        Dish pasta = new Dish("Макароны по флотски", 70, "Макароны по флотски в соусе");
        Dish potato = new Dish("Картошка по французски", 75, "Картошка по французски с сыром");

        //// инициализация покупателей
        Customer cust1 = new Customer("Илья", "Слепушов", LocalDate.of(1992,5,8),
                new Address("Самара", -1, "5-я просека", 110, 'д', 199));

        Customer cust2 = new Customer("Екатерина", "Слепушова", LocalDate.of(1993,5,11),
                new Address("Самара", 443064, "Карбышева", 65, ' ', 152));

        Customer cust2_ = new Customer("Екатерина", "Слепушова", LocalDate.of(1993,5,11),
                new Address("Самара", 443064, "Карбышева", 65, ' ', 152));

        //// иниз заказов
        Order oneOrder = new TableOrder(cust1, new MenuItem[] {omlette, juice, borch,pasta, juice, borch, beer});

        Order oneOrder_ = new InternetOrder(cust1, new MenuItem[] {omlette, juice, borch,pasta, juice, borch,omlette});

        Order twoOrder = new TableOrder(cust2, new MenuItem[] {juice, borch,pasta,omlette,juice});

        OrdersManager OM;
        TableOrdersManager tom1 = new TableOrdersManager(5);
        InternetOrdersManager iom1= new InternetOrdersManager();
        tom1.add(oneOrder,1);
        tom1.add(twoOrder,2);

        System.out.println(cust2.equals(cust2_));

        // tom1.add(oneOrder_,1);
     //   iom1.add(oneOrder_);
      //  iom1.add(twoOrder);
      /*  OM = tom1;

        for (Order i:   OM.getOrders())
            if (i!=null) {
                System.out.println(i.getCustomer().toString());
              //  System.out.println(i.toString());


            }


//        OM = iom1;
//        iom1.remove();
      //  System.out.println(cust2.getAddress().toString());
       /* Alcoholable a;
        tom1.add(oneOrder,3);
        tom1.addItem(potato, 3);
        Order test = tom1.getOrder(3);
        MenuItem[] test2 = test.getItems();
        for (MenuItem i:test2) {

            System.out.println(i.toString());
        }


     //   System.out.println(om.getClass());
        //  System.out.println(tom1.);
        Order[] or = tom1.getOrders();
            for (Order i:or) {
               // if (i!=null) System.out.println( new TableOrder(i.getCustomer(),i.sortedDishesByCostDesc()).toString());
                 if (i!=null) {;}

                //System.out.println(twoOrder.costTotal());
        }

    //    System.out.println(om.itemsQuantity(borch));
      //  Order twoOrder = new InternetOrder();
       // twoOrder.add(juice);
       // twoOrder.add(borch);
       // twoOrder.add(pasta);
       // twoOrder.add(omlette);

        //System.out.println(twoOrder.);
    //    String[] t = twoOrder.itemsNames();
       // for (String i:t) {
          //  System.out.println(i);
            //    System.out.println(twoOrder.costTotal());
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
