
interface Welcome {
    void display();
}

interface GST {
    double calculate(double price);
}

interface TotalBill {
    double calculate(double price, int quantity);
}

interface Discount {
    double calculate(double amount);
}

interface FinalAmount {
    double calculate(double amount);
}

    class Main {
    public static void main(String[] args) {

        // 1. Welcome Message (No Parameters)
        Welcome w = () -> System.out.println("Welcome to Shopping Application!");

        // 2. Calculate 18% GST (One Parameter)
        GST g = price -> price * 0.18;

        // 3. Calculate Total Bill (Multiple Parameters)
        TotalBill t = (price, quantity) -> price * quantity;

        // 4. Calculate 10% Discount (Single Expression)
        Discount d = amount -> amount * 0.10;

        // 5. Final Payable Amount (Multiple Statements)
        FinalAmount f = amount -> {
            double discount = amount * 0.10;
            double finalAmount = amount - discount;
            return finalAmount;
        };

        double price = 1000;
        int quantity = 2;

        w.display();

        double gst = g.calculate(price);
        System.out.println("18% GST: " + gst);

        double total = t.calculate(price, quantity);
        System.out.println("Total Bill: " + total);

        double discount = d.calculate(total);
        System.out.println("10% Discount: " + discount);

        double payable = f.calculate(total);
        System.out.println("Final Payable Amount: " + payable);
    }
}
