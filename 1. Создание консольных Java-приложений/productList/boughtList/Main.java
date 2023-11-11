import java.util.*;

public class Main {
    public static void main(String[] args) {

        TreeMap<String, TreeMap<String, Integer>> list = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        String line = scanner.nextLine();
        while (!line.isEmpty()) {
            stringBuilder.append(line).append("\n");
            line = scanner.nextLine();
        }

        String result = stringBuilder.toString();

        String[] lines = result.split("\n");

        for (String s : lines) {
            String[] parts = s.split(" ");

            String key1 = parts[0];
            String key2 = parts[1];
            int value = Integer.parseInt(parts[2]);

            list.computeIfAbsent(key1, k -> new TreeMap<>())
                    .merge(key2, value, Integer::sum);
        }

        StringBuilder result2 = new StringBuilder();

        for (String outerKey : list.keySet()) {
            TreeMap<String, Integer> innerMap = list.get(outerKey);
            result2.append(outerKey).append(":\n");
            for (String innerKey : innerMap.keySet()) {
                result2.append(innerKey).append(" ").append(innerMap.get(innerKey)).append("\n");
            }
        }

        System.out.println(result2);
    }
}