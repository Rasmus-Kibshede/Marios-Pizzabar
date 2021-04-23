import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    UI ui = new UI();

    // Martin
    public ArrayList<String> fileToList(String pathname) {
        // Store every line of a file to a list
        ArrayList<String> storage = new ArrayList<>();

        try {
            Scanner input = new Scanner(new File(pathname));
            while (input.hasNextLine()) {
                String text = input.nextLine();
                storage.add(text);
            }
            input.close();
        } catch (FileNotFoundException e) {
            ui.printColorString("red", "File not found");
        }
        return storage;
    }

    // Martin
    public HashMap<String, Double> addToMap(ArrayList<String> storage) {
        HashMap<String, Double> statistic = new HashMap<>();

        // Split every element in storage, then add to map. Key values get multiplied by the occurrences of the same key name
        for (int i = 0; i < storage.size(); i++) {
            String[] arr = storage.get(i).split("_");
            String name = arr[0];
            double price = Double.parseDouble(arr[1]);
            statistic.put(name, price * Collections.frequency(storage, storage.get(i)));
        }
        return statistic;
    }

    // Martin
    public void iterateMap(HashMap<String, Double> statistic) {
        ArrayList<String> lst = new ArrayList<>();

        // Iterates over the map, then adds it to lst
        Iterator it = statistic.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String s = "$" + pair.getValue() + " \t " + pair.getKey();
            lst.add(s);
            it.remove();
        }

        for (int i = 0; i < lst.size(); i++) {
            ui.printString((i + 1) + ": " + lst.get(i));
        }
    }

    public void showStatistics() {
        Statistics stats = new Statistics();
        ArrayList<String> storage = stats.fileToList("statistics.txt");
        HashMap<String, Double> map = stats.addToMap(storage);
        stats.iterateMap(map);
    }
}
