package Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String userName;
    private List<Pizza> pizzaList = new ArrayList<>();
    private float totalPrice;

    public Order(String userName, List<Pizza> pizzaList, float totalPrice) {
        this.userName = userName;
        this.pizzaList = pizzaList;
        this.totalPrice = totalPrice;
    }

    public Order() {
    }

    public void addPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public float getTotalPrice() {
        for (Pizza pizza : pizzaList) {
            totalPrice += pizza.getTotalPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return userName + " your order: " +
                pizzaList;
    }
}
