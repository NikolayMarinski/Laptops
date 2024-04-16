import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {

            File file = new File("Laptops.txt");
            Scanner scanner = new Scanner(file);


            List<Laptop> laptops = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(" ");
                int year = Integer.parseInt(info[0]);
                String brand = info[1];
                int price = Integer.parseInt(info[2]);
                String city = info[3];
                String customerName = info[4];


                if (year >= 2015 && year <= 2020 && price < 2000 && (city.equals("Sofia") || city.equals("Plovdiv") || city.equals("Varna"))) {
                    laptops.add(new Laptop(year, brand, price, city, customerName));
                }
            }


            scanner.close();


            laptops.sort(Comparator.comparing(Laptop::getBrand));


            List<List<String>> groupedLaptops = new ArrayList<>();
            List<String> currentGroup = new ArrayList<>();
            String currentBrand = "";
            for (Laptop laptop : laptops) {
                if (!laptop.getBrand().equals(currentBrand)) {
                    if (!currentGroup.isEmpty()) {
                        groupedLaptops.add(new ArrayList<>(currentGroup));
                        currentGroup.clear();
                    }
                    currentBrand = laptop.getBrand();
                }
                currentGroup.add(laptop.getCustomerName());
            }
            groupedLaptops.add(new ArrayList<>(currentGroup));


            groupedLaptops.sort((g1, g2) -> Integer.compare(g2.size(), g1.size()));


            File outputFile = new File("Results.txt");
            PrintWriter writer = new PrintWriter(outputFile);

            int count = 0;
            for (List<String> group : groupedLaptops) {
                if (count >= 3) break;
                String brand = laptops.get(0).getBrand();
                writer.println(brand + ": " + String.join(", ", group));
                count++;
            }


            writer.close();

            System.out.println("Results successfully saved.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}