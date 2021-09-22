import Models.PizzaType;
import Service.OrderService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<PizzaType> pizzaTypes = new ArrayList<>();
        pizzaTypes.add(PizzaType.MARGHERITA);
        pizzaTypes.add(PizzaType.CAPRICIOSA);
        pizzaTypes.add(PizzaType.CALZONE);
        OrderService orderService = new OrderService(pizzaTypes);
        orderService.startApp();
    }
}
