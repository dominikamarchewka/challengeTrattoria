package Service;

import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Topping> toppingList;
    private final Order order = new Order();
    private Type type;
    private int quantity = 1;
    private String name;
    private Pizza pizza;

    void getTypeOfPizza() {
        System.out.println("What kind of pizza would you like to eat? Please select the number you prefer: " +
                "\n1. Margherita (tomatoes, mozzarella cheese, fresh basil)" +
                "\n2. Capriciosa (tomatoes, mozzarella cheese, ham, mushrooms)" +
                "\n3. Calzone (oven-baked folded pizza with mozzarella cheese, salami, egg)");
        int chooseType = scanner.nextInt();
        if (chooseType < 1 || chooseType > 3) {
            System.out.println("Please choose correct number!");
            getTypeOfPizza();
        } else {
            switch (chooseType) {
                case 1:
                    type = Type.MARGHERITA;
                    break;
                case 2:
                    type = Type.CAPRICIOSA;
                    break;
                case 3:
                    type = Type.CALZONE;
                    break;
            }
        }
    }

    void getToppingsForPizza() {
        toppingList = new ArrayList<>();
        System.out.println("We can upgrade your pizza with the following toppings: salami, ham, mushroom, olives." +
                "\nHow many toppings would you like to add? Please select the number from 0 to 5: ");
        int numberOfToppings = scanner.nextInt();

        if (numberOfToppings < 0 || numberOfToppings > 5) {
            System.out.println("Please enter right number!");
            getToppingsForPizza();
        }
        for (int i = 1; i <= numberOfToppings; i++) {
            System.out.println("Please select the number of the pizza topping: " +
                    "\n1. Salami" +
                    "\n2. Ham" +
                    "\n3. Mushroom" +
                    "\n4. Olives");
            int toppingChoose = scanner.nextInt();
            switch (toppingChoose) {
                case 1:
                    toppingList.add(Topping.SALAMI);
                    break;
                case 2:
                    toppingList.add(Topping.HAM);
                    break;
                case 3:
                    toppingList.add(Topping.MUSHROOM);
                    break;
                case 4:
                    toppingList.add(Topping.OLIVES);
                    break;
                default:
                    System.out.println("Please select correct number!");
                    i--;
                    break;
            }
        }
    }

    void getPizzaQuantity() {
        System.out.println("Thank you for choosing! How many times do we have to prepare a given pizza?");
        quantity = scanner.nextInt();
    }

    void createPizza() {
        if (toppingList.isEmpty()) {
            pizza = new PizzaBuilder().withType(type).withQuantity(quantity).build();
        } else {
            pizza = new PizzaBuilder().withType(type).withToppingList(toppingList).withQuantity(quantity).build();
        }
        order.setUserName(name);
        order.addPizza(pizza);
    }

    void getUserOrder() {
        getTypeOfPizza();
        getToppingsForPizza();
        getPizzaQuantity();
        createPizza();
        System.out.println(order.toString());
    }

    public void startApp() {
        System.out.println("Welcome to our virtual trattoria 'Il Gardino'! " +
                "\nTo start your order please enter your name: ");
        name = scanner.next();
        System.out.println("Thank you " + name + "!");
        getUserOrder();
        while (true) {
            System.out.println("Would you like to get another pizza? If yes, please enter 1, else enter any integer number");
            int anotherPizza = scanner.nextInt();
            switch (anotherPizza) {
                case 1:
                    getUserOrder();
                    break;
                default:
                    System.out.println("Thank you for choosing our restaurant! We are starting to prepare your order. "
                            + "Your total price to pay is: " + order.getTotalPrice());
                    System.exit(0);
            }
        }
    }
}
