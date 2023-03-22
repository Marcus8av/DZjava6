import java.util.*;

public class info {

    public info() {
        Set<Laptop> laptops = initNotebooks();
        System.out.println("Всего ноутбуков: " + laptops.size());
        Map<Integer, String> filter = inputFilters();
        Set<Laptop> filteredLaptops = Laptop.filter(laptops, filter);
        System.out.println("Всего совпадений по вашему запросу: " + filteredLaptops.size() + "\n");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }

    }

    private Map<Integer, String> inputFilters() {
        Map<Integer, String> filters = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            Map<Integer, String> filterList = Laptop.initFilterList();
            System.out.println("Введите значение к каждому из фильтров или поставтье '-' если вам этот фильтр не нужен");
            for (var filter : filterList.entrySet()) {
                System.out.printf(filter.getValue() + ": ");
                String value = scanner.next();
                filters.put(filter.getKey(), value);
            }
        } catch (Exception e) {
            System.out.printf("Ошибка: %s", e.getMessage());
        }
        return filters;
    }

    private Set<Laptop> initNotebooks() {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add((new Laptop("Samsung", "A154"))
                .setRAMSize(6)
                .setHardDriveSize(1024)
                .setOS("Windows"));
        laptops.add((new Laptop("HP", "H478"))
                .setRAMSize(4)
                .setHardDriveSize(512)
                .setOS("Windows"));
        laptops.add((new Laptop("Acer", "A444"))
                .setRAMSize(2)
                .setHardDriveSize(512)
                .setOS("Linux"));
        laptops.add((new Laptop("Apple", "M2"))
                .setRAMSize(6)
                .setHardDriveSize(2048)
                .setOS("MacOS"));
        laptops.add((new Laptop("Huawei", "N145"))
                .setRAMSize(4)
                .setHardDriveSize(1024)
                .setOS("Linux"));
        laptops.add((new Laptop("Asus", "L9856"))
                .setRAMSize(8)
                .setHardDriveSize(512)
                .setOS("Windows"));
        return laptops;
    }

}