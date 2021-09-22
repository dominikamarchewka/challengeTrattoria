package Service;

import Models.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    private static final Scanner scanner_ = new Scanner(System.in);
    private final Order order = new Order();
    private final ArrayList<PizzaType> options;
    private List<Topping> toppingList;
    private PizzaType pizzaType;
    private int quantity = 1;
    private String name;
    private Pizza pizza;
    private boolean validInput;

    public OrderService(ArrayList<PizzaType> options) {
        this.options = options;
    }

    void getTypeOfPizza() {
        System.out.println("What kind of pizza would you like to eat? Please select the number you prefer: ");
        int number = 1;
        for (PizzaType pizzaType : options) {
            System.out.print(number + ". ");
            pizzaType.getDetails();
            System.out.println(pizzaType.getPrice());
            number++;
        }
        validInput = false;
        while (!validInput) {
            try {
                int chooseType = scanner_.nextInt();
                validInput = true;
                if (chooseType < 0 || chooseType > options.size()) {
                    System.out.println("Please choose correct number!");
                    getTypeOfPizza();
                } else {
                    pizzaType = options.get(chooseType - 1);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter correct number!");
                scanner_.next();
            }
        }
    }

    void getToppingsForPizza() {
        validInput = false;
        toppingList = new ArrayList<>();
        System.out.println("We can upgrade your pizza with the following toppings: salami, ham, mushroom, olives." +
                "\nHow many toppings would you like to add? Please select the number from 0 to 5: ");
        while (!validInput) {
            try {
                int numberOfToppings = scanner_.nextInt();
                validInput = true;
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
                    validInput = false;
                    while (!validInput) {
                        try {
                            int toppingChoose = scanner_.nextInt();
                            validInput = true;
                            switch (toppingChoose) {
                                case 1 -> toppingList.add(Topping.SALAMI);
                                case 2 -> toppingList.add(Topping.HAM);
                                case 3 -> toppingList.add(Topping.MUSHROOM);
                                case 4 -> toppingList.add(Topping.OLIVES);
                                default -> {
                                    System.out.println("Please select correct number!");
                                    i--;
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter correct number!");
                            scanner_.next();
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter correct number!");
                scanner_.next();
            }
        }
    }

    void getPizzaQuantity() {
        validInput = false;
        System.out.println("Thank you for choosing! How many times do we have to prepare a given pizza?");
        while (!validInput) {
            try {
                quantity = scanner_.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter correct number!");
                scanner_.next();
            }
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
