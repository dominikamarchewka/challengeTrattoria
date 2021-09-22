package Models;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private float totalPrice = 0;
    private List<Topping> toppingList = new ArrayList<>();
    private Type type;
    private int quantity;

    public Pizza(float totalPrice, List<Topping> toppingList, Type type, int quantity) {
        this.totalPrice = totalPrice;
        this.toppingList = toppingList;
        this.type = type;
        this.quantity = quantity;
    }

    public Pizza() {
    }

    public float getTotalPrice() {
        return totalPrice * quantity;
    }

    public List<Topping> getToppingList() {
        return this.toppingList;
    }

    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addToPrice(float price) {
        this.totalPrice = totalPrice + price;
    }

    @Override
    public String toString() {
        if (toppingList.size() != 0) {
            return type +
                    ", extra toppings = " + getToppingList() +
                    ", quantity = " + quantity +
                    ", price = " + getTotalPrice();
        } else return type +
                ", quantity = " + quantity +
                ", price = " + getTotalPrice();
    }
}
