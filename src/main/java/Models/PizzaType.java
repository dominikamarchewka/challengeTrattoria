package Models;

public enum PizzaType {
    MARGHERITA {
        public float getPrice() {
            return 20;
        }
    }, CAPRICIOSA {
        public float getPrice() {
            return 25;
        }
    }, CALZONE {
        public float getPrice() {
            return 30;
        }
    };

    public abstract float getPrice();
}
