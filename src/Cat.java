public class Cat extends Animal {
    private static int count;
    private boolean isWellFed;

    public void printCount() {
        System.out.println(count);
    }

    public Cat(String name) {
        super(name);
        count++;
        isWellFed = false;
    }

    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Котик не может пробежать больше 200 м.");
        } else super.run(distance);
    }

    public void swim(int distance) {
        System.out.println("Кот плавать не умеет :(");
    }

    public void eatFromPlate(Plate plate, int howMuch) {
        if (howMuch > plate.food) {
            System.out.println("Котику "+ name+" не хватает еды, положите еще :(");
        } else {
            isWellFed = true;
            plate.food = plate.food - howMuch;
            System.out.println("Котик " + name+" покушал");
        }
    }

    public void isFeeded() {
        if (isWellFed) {
            System.out.println("Котик " + name + " сыт");
        } else System.out.println("Котик " + name + " остался голодным");
    }
}
