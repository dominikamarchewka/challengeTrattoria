package Service;

import Models.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private static final Scanner scanner_ = new Scanner(System.in);
    private final Order order = new Order();
    private List<Topping> toppingList;
    private PizzaType pizzaType;
    private int quantity = 1;
    private String name;
    private Pizza pizza;

    void getTypeOfPizza() {
        System.out.println("What kind of pizza would you like to eat? Please select the number you prefer: " +
                "\n1. Margherita (tomatoes, mozzarella cheese, fresh basil)" +
                "\n2. Capriciosa (tomatoes, mozzarella cheese, ham, mushrooms)" +
                "\n3. Calzone (oven-baked folded pizza with mozzarella cheese, salami, egg)");
        try{
            int chooseType = scanner_.nextInt();
            if (chooseType < 1 || chooseType > 3) {
                System.out.println("Please choose correct number!");
                getTypeOfPizza();
            } else {
                switch (chooseType) {
                    case 1:
                        pizzaType = PizzaType.MARGHERITA;
                        break;
                    case 2:
                        pizzaType = PizzaType.CAPRICIOSA;
                        break;
                    case 3:
                        pizzaType = PizzaType.CALZONE;
                        break;
                }
            }
        } catch (InputMismatchException e){
            System.out.println("Please enter correct number!");
            getTypeOfPizza();
        }
    }

    void getToppingsForPizza() {
        toppingList = new ArrayList<>();
        System.out.println("We can upgrade your pizza with the following toppings: salami, ham, mushroom, olives." +
                "\nHow many toppings would you like to add? Please select the number from 0 to 5: ");
        try {
            int numberOfToppings = scanner_.nextInt();

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
                int toppingChoose = scanner_.nextInt();
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
        } catch (InputMismatchException e){
            System.out.println("Please enter correct number!");
            getToppingsForPizza();
        }
    }

    void getPizzaQuantity() {
        System.out.println("Thank you for choosing! How many times do we have to prepare a given pizza?");
        try {
            quantity = scanner_.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Please enter correct number!");
            getPizzaQuantity();
        }
    }

    void createPizza() {
        pizza = new PizzaBuilder().withType(pizzaType).withToppingList(toppingList).withQuantity(quantity).build();
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
        name = scanner_.next();
        if (name.isEmpty()) {
            System.out.println("Please enter your name, it should be at least one character!");
            name = scanner_.next();
        }
        System.out.println("Thank you " + name + "!");
        getUserOrder();
        while (true) {
            System.out.println("Would you like to get another pizza? Please type Yes or No");
            String option = scanner_.next().toUpperCase();
            if (option.equals("YES")) {
                getUserOrder();
            } else if (option.equals("NO")) {
                System.out.println("Thank you for choosing our restaurant! We are starting to prepare your order. "
                        + "Your total price to pay is: " + order.getTotalPrice());
                break;
            }
        }
    }
}
