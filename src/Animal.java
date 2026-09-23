public class Animal {
    String name;
    private static int count;


    public void printCountAnimals() {
        System.out.println(count);
    }

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }
}
