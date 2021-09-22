package Models;

import java.util.List;

public class PizzaBuilder {

    Pizza pizza = new Pizza();

    public PizzaBuilder withType(Type type){
        pizza.setType(type);
        pizza.addToPrice(type.getPrice());
        return this;
    }

    public PizzaBuilder withToppingList(List<Topping> toppingList) {
        pizza.setToppingList(toppingList);
        for(Topping topping : toppingList){
            pizza.addToPrice(topping.getPrice());
        }
        return this;
    }

    public PizzaBuilder withQuantity(int quantity){
        pizza.setQuantity(quantity);
        return this;
    }

    public Pizza build() {
        return pizza;
    }
}