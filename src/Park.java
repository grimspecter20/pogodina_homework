public class Park {
    class Attraction {
        String name;
        String workTimeFrom;
        String workTimeUntil;
        int price;

        public Attraction(String name, String workTimeFrom, String workTimeUntil, int price) {
            this.name = name;
            this.workTimeFrom = workTimeFrom;
            this.workTimeUntil = workTimeUntil;
            this.price = price;
        }
    }
}
