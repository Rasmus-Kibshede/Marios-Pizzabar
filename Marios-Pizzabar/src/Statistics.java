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
    public ArrayList<HashMap<String, Double>> addToMap(ArrayList<String> storage) {
        ArrayList<HashMap<String, Double>> stats = new ArrayList<>();
        HashMap<String, Double> statisticEarned = new HashMap<>();
        HashMap<String, Double> statisticAmount = new HashMap<>();

        // Split every element in storage, then add to map. Key values get multiplied by the occurrences of the same key name
        for (int i = 0; i < storage.size(); i++) {
            String[] arr = storage.get(i).split("_");
            String name = arr[0];
            double price = Double.parseDouble(arr[1]);
            statisticEarned.put(name, price * Collections.frequency(storage, storage.get(i)));
            statisticAmount.put(name, (double) Collections.frequency(storage, storage.get(i)));
        }
        stats.add(statisticEarned);
        stats.add(statisticAmount);
        return stats;
    }

    // Martin
    public void iterateMap(ArrayList<HashMap<String, Double>> statistic) {
        ArrayList<String> earned = new ArrayList<>();
        ArrayList<String> amount = new ArrayList<>();
        ArrayList<String> sorted = new ArrayList<>();

        Iterator it = statistic.get(0).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String s = "$" + pair.getValue() + " \t " + pair.getKey();
            earned.add(s);
            it.remove();
        }

        Iterator it2 = statistic.get(1).entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry pair = (Map.Entry) it2.next();
            double convert = (double) pair.getValue();
            String s2 = String.valueOf((int) convert);
            amount.add(s2);
            it2.remove();
        }

        for (int i = 0; i < earned.size(); i++) {
            sorted.add(amount.get(i) + ": " + earned.get(i));
        }

        Collections.sort(sorted, Collections.reverseOrder());
        for (String s : sorted) {
            ui.printString(s);
        }
    }

    public void showStatistics() {

        Statistics stats = new Statistics();
        ArrayList<String> storage = stats.fileToList("statistics.txt");
        ArrayList<HashMap<String, Double>> map = stats.addToMap(storage);
        stats.iterateMap(map);
    }
}
