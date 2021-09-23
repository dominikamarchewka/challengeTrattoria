package Models;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {
    private Pizza pizza;

    @BeforeEach
    void setUp (){
        pizza = new Pizza();
    }

    @Test
    void shouldGetTotalPrice() {
        pizza.addToPrice(30);
        pizza.setQuantity(3);
        float expected = pizza.getTotalPrice();
        assertEquals(90, expected);
    }
}
