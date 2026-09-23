public class Dog extends Animal {
    private static int count;


    public void printCount() {
        System.out.println(count);
    }

    public Dog(String name) {
        super(name);
        count++;
    }

    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Собачка не может пробежать больше 500 м.");
        } else super.run(distance);
    }

    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Собачка не может проплыть больше 10 м.");
        }
        super.swim(distance);
    }
}
