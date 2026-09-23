public class Product {
    String name;
    String date;
    String maker;
    String country;
    int price;
    boolean reserved;

    public Product(String name, String date, String maker, String country, int price, boolean reserved) {
        this.name = name;
        this.date = date;
        this.maker = maker;
        this.country = country;
        this.price = price;
        this.reserved = reserved;
    }

    public void printInfo() {
        System.out.println("Название товара: " + name);
        System.out.println("Дата производства: " + date);
        System.out.println("Производитель: " + maker);
        System.out.println("Страна производства: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " + reserved);
    }
}
