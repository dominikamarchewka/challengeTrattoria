package Models;

public enum PizzaType {
    MARGHERITA {
        public float getPrice() {
            return 20;
        }

        public void getDetails() {
            System.out.println("Margherita: tomatoes, mozzarella cheese, fresh basil");
        }
    }, CAPRICIOSA {
        public float getPrice() {
            return 25;
        }

        public void getDetails() {
            System.out.println("Capriciosa: tomatoes, mozzarella cheese, ham, mushrooms");
        }
    }, CALZONE {
        public float getPrice() { return 30; }

        public void getDetails() {
            System.out.println("Calzone: oven-baked folded pizza with mozzarella cheese, salami, egg");
        }
    }, VEGETARIAN {
        public float getPrice() { return 25; }

        public void getDetails() {
            System.out.println("Vegetarian: vegan cheese, peppers, mushrooms, eggplant");
        }
    }, HAWAIIAN {
        public float getPrice() { return 30; }

        public void getDetails() {
            System.out.println("Hawaiian: tomatoes, mozzarella cheese, pineapple, ham");
        }
    };

    public abstract float getPrice();

    public abstract void getDetails();
}
