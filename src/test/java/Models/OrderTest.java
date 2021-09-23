package Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    private Order order;
    private Pizza pizza;
    private Pizza pizza2;
    private List<Topping> toppingList;
    private List<Pizza> pizzaList;

    @BeforeEach
    void setUp() {
        order = new Order();
        toppingList = new ArrayList<>();
        toppingList.add(Topping.OLIVES);
        toppingList.add(Topping.HAM);
        pizza = new PizzaBuilder().withType(PizzaType.MARGHERITA).withToppingList(toppingList).withQuantity(1).build();
        pizza2 = new PizzaBuilder().withType(PizzaType.MARGHERITA).withToppingList(toppingList).withQuantity(2).build();
        order.addPizza(pizza);
        order.addPizza(pizza2);
    }

    @Test
    void shouldAddPizzaToPizzaList(){
        pizzaList = new ArrayList<>();
        pizzaList.add(pizza);
        pizzaList.add(pizza2);
        assertEquals(pizzaList, order.getPizzaList());
    }

    @Test
    void shouldGetTotalPrice() {
         assertEquals(84, order.getTotalPrice());
    }
}