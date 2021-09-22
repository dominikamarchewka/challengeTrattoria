package Models;

public enum Topping {
    SALAMI {
        public float getPrice() {
            return 5;
        }
    }, HAM {
        public float getPrice() {
            return 5;
        }
    }, MUSHROOM {
        public float getPrice() {
            return 3;
        }
    }, OLIVES {
        public float getPrice() {
            return 3;
        }
    };

    public abstract float getPrice();
}