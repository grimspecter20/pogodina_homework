//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16 Pro", "15.09.2024", "Apple Inc.", "USA", 4999, false);
        productsArray[2] = new Product("Xiaomi 15 Ultra", "20.03.2025", "Xiaomi", "China", 3999, true);
        productsArray[3] = new Product("Sony WH-1000XM6", "10.05.2025", "Sony", "Japan",  2499, false);
        productsArray[4] = new Product("MacBook Air M4", "05.03.2025", "Apple Inc.", "USA", 7999, false);

        for (Product product : productsArray){
            product.printInfo();
            System.out.println();
        }
    }
}