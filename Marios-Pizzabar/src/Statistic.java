import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistic {
    private int amount;
    private String text;
    UI ui = new UI();

    public Statistic(int amount, String text) {
        this.amount = amount;
        this.text = text;
    }

    public Statistic() {
    }

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
        ArrayList<Integer> amount = new ArrayList<>();
        ArrayList<Statistic> lst = new ArrayList<>();

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
            int converted = (int) convert;
            amount.add(converted);
            it2.remove();
        }

        for (int i = 0; i < earned.size(); i++) {
            String text = ": " + earned.get(i);
            lst.add(new Statistic(amount.get(i), text));
        }

        for (Statistic s : sortB(lst)) {
            ui.printString(s.toString());
        }
    }

    public ArrayList<Statistic> sortB(ArrayList<Statistic> lst) {
        for (int i = 1; i < lst.size(); i++) {
            for (int j = 0 ; j < lst.size() - i; j++) {
                if (lst.get(j).amount < lst.get(j+1).amount) {
                    Statistic temp = lst.get(j);
                    lst.set(j, lst.get(j+1));
                    lst.set(j + 1, temp);
                }
            }
        }
        return lst;
    }

    public void showStatistics() {
        Statistic stats = new Statistic();
        ArrayList<String> storage = stats.fileToList("statistics.txt");
        ArrayList<HashMap<String, Double>> map = stats.addToMap(storage);
        stats.iterateMap(map);
    }

    public String toString() {
        return amount + text;
    }
}
