package Models;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private float totalPrice = 0;
    private List<Topping> toppingList = new ArrayList<>();
    private PizzaType pizzaType;
    private int quantity;

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

    public PizzaType getType() {
        return pizzaType;
    }

    public void setType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
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
        if (toppingList.size() != 0)
            return "\n" + pizzaType +
                    ", extra toppings = " + getToppingList() +
                    ", quantity = " + quantity +
                    ", price = " + getTotalPrice();
        else return "\n" + pizzaType +
                ", quantity = " + quantity +
                ", price = " + getTotalPrice();
    }
}
