import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String name, String number) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(number);
        } else phoneBook.put(name, new ArrayList<String>(List.of(number)));
    }

    public void get(String name) {
        System.out.println("По имени " + name + " найдены номера: " + phoneBook.get(name));
    }
}

