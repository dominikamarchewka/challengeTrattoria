package Models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaBuilderTest {
    private Pizza pizza;
    private List<Topping> toppingList;

    @Test
    public void shouldBuildPizzaWithTypeQuantityAndToppings() {
        toppingList = new ArrayList<>();
        toppingList.add(Topping.HAM);
        toppingList.add(Topping.SALAMI);
        pizza = new PizzaBuilder().withType(PizzaType.CAPRICIOSA).withQuantity(2).withToppingList(toppingList).build();
        assertEquals(toppingList, pizza.getToppingList());
        assertEquals(PizzaType.CAPRICIOSA, pizza.getType());
        assertEquals(2, pizza.getQuantity());
        assertEquals(70.0, pizza.getTotalPrice(), 0);
    }

    @Test
    public void shouldBuildPizzaWithTypeAndQuantity() {
        pizza = new PizzaBuilder().withType(PizzaType.MARGHERITA).withQuantity(3).build();
        assertEquals(PizzaType.MARGHERITA, pizza.getType());
        assertEquals(3, pizza.getQuantity());
        assertEquals(60.0, pizza.getTotalPrice(), 0);
    }
}
