package business;


import presentation.Observer;

import javax.swing.table.DefaultTableModel;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliveryService implements IDeliveryServiceProcessing, Observable {
    private Map<Orders, List<MenuItem>> orders;
    private List<MenuItem> menu;
    private List<Users> users;
    private List<Observer> observers;

    public DeliveryService() {
        orders = new HashMap<Orders, List<MenuItem>>();
        menu = new ArrayList<>();
        observers = new ArrayList<>();
        users = ImportUsers("src/users.csv");
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }


    public List<Users> ImportUsers(String csvFileName) {
        ArrayList<Users> users = new ArrayList<>();
        Stream<String> lines = null;

        try {
            lines = Files.lines(Paths.get(csvFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<String>> items = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
        items.remove(0);
        items.forEach(value -> {
            Users item = new Users((Long.parseLong(value.get(0))), value.get(1), value.get(2), Integer.parseInt(value.get(3)));
            try {
                users.add(item);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // menu = menuItems;
        return users;

    }

    public List<MenuItem> ImportFromCSV(String csvFileName) {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        Stream<String> lines = null;

        try {
            lines = Files.lines(Paths.get(csvFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<String>> items = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
        items.remove(0);
        items.forEach(value -> {
            MenuItem item = new BaseProduct(value.get(0), (Double.parseDouble((value.get(1)))), (Integer.parseInt(value.get(2))), (Integer.parseInt(value.get(3))), (Integer.parseInt(value.get(4))), (Integer.parseInt(value.get(5))), (Integer.parseInt(value.get(6))));
            //System.out.println(item);
            try {
                if (item.searchItemInList(menuItems) == 0) {
                    menuItems.add(item);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        menu = menuItems;
        for (MenuItem men : menuItems) {
            System.out.println(men);
        }
        return menuItems;

    }

    public DefaultTableModel createTable(List<MenuItem> list) {
        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("Title");
        columnNames.add("Rating");
        columnNames.add("Calories");
        columnNames.add("Proteins");
        columnNames.add("Fats");
        columnNames.add("Sodium");
        columnNames.add("Price");
        // Object[][] obj = new Object[list.size()][numberOfFields];
        List<Object[]> obj = new ArrayList<>();
        for (MenuItem item : list) {

            obj.add(new Object[]{item.getTitle(), item.getRating(), item.getCalories(), item.getProteins(), item.getFats(), item.getSodium(), item.getPrice()});
        }

        DefaultTableModel tModel = new DefaultTableModel(obj.toArray(new Object[][]{}), columnNames.toArray());

        return tModel;
    }

    public void InsertProduct(MenuItem item) {
        if (item.searchItemInList(menu) == 0) {
            menu.add(item);
        }
    }

    public void DeleteProduct(int row) {
        menu.remove(row);
    }

    public void ModifyProduct(int row, MenuItem item) {
        menu.set(row, item);
    }

    public void CreateProduct(List<MenuItem> items, String name) {
        CompositeProduct newProduct = new CompositeProduct(name);
        newProduct.setRating(newProduct.ComputeRating(items));
        newProduct.setCalories(newProduct.ComputeCalories(items));
        newProduct.setProteins(newProduct.ComputeProteins(items));
        newProduct.setFats(newProduct.ComputeProteins(items));
        newProduct.setSodium(newProduct.ComputeSodium(items));
        newProduct.setPrice(newProduct.ComputePrice(items));
        newProduct.setCompItem(items);
        menu.add(newProduct);
    }

    public List<MenuItem> filterItems(String title, Double minRating, int minCalories, int minProteins, int minFats, int minSodium, int minPrice, double maxRating, int maxCalories, int maxProteins, int maxFats, int maxSodium, int maxPrice) {
        List<MenuItem> filteredList = this.menu;
        filteredList = filteredList.stream().filter(x -> x.getTitle().toLowerCase(Locale.ROOT).contains(title.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getRating() >= minRating).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getCalories() >= minCalories).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getProteins() >= minProteins).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getFats() >= minFats).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getSodium() >= minSodium).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getPrice() >= minPrice).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getRating() <= maxRating).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getCalories() <= maxCalories).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getProteins() <= maxProteins).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getFats() <= maxFats).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getSodium() <= maxSodium).collect(Collectors.toList());
        filteredList = filteredList.stream().filter(x -> x.getPrice() <= maxPrice).collect(Collectors.toList());

        return filteredList;
    }


    public void CreateOrder(Orders order, List<MenuItem> items) {
        this.orders.put(order, items);
        generateBill(order, items);
        notifyObservers(this);
    }

    public void generateBill(Orders order, List<MenuItem> menuItemList) {
        String str = "Order " + (order.getOrderID());
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            FileWriter fileWriter = new FileWriter(str + ".txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Users user = users.stream()
                    .filter(x -> x.getId() == order.getClientID())
                    .collect(Collectors.toList())
                    .get(0);

            bufferedWriter.write(str + "\n\n" + user.getUsername() + "\n\n Order date: " + dateFormat.format(order.getOrderDate()) + "\n\n Your order is:\n\n");

            int total = 0;
            for (MenuItem product : menuItemList) {
                bufferedWriter.write(product.getTitle() + "     " + product.getPrice() + " RON\n");
                total = total + product.getPrice();
            }

            bufferedWriter.write("\nPret total:   " + total + " RON");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void generateOrdersInIntervalReport(Time start, Time end) {
        try {
            FileWriter fileWriter = new FileWriter("Report1.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Orders placed from " + start + " to " + end + ":\n\n");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            List<Orders> orderList = this.getOrders().keySet()
                    .stream()
                    .filter(x -> x.getOrderDate().getHour() > start.getHours() || x.getOrderDate().getHour() == start.getHours() && x.getOrderDate().getMinute() > start.getMinutes() || x.getOrderDate().getHour() == start.getHours() && x.getOrderDate().getMinute() == start.getMinutes() && x.getOrderDate().getSecond() >= start.getSeconds())
                    .filter(x -> x.getOrderDate().getHour() < end.getHours() || x.getOrderDate().getHour() == end.getHours() && x.getOrderDate().getMinute() < end.getMinutes() || x.getOrderDate().getHour() == end.getHours() && x.getOrderDate().getMinute() == end.getMinutes() && x.getOrderDate().getSecond() <= end.getSeconds())
                    .collect(Collectors.toList());

            for (Orders order : orderList) {
                List<MenuItem> menuItemList = this.orders.get(order);
                bufferedWriter.write("ORDER ID:  " + order.getOrderID() + "                 ORDER DATE: " + dateFormat.format(order.getOrderDate()) + "\n    CLIENT ID:  " + order.getClientID() + "\n      Order contains:\n");
                for (MenuItem item : menuItemList) {
                    bufferedWriter.write("             " + item.getTitle() + "   PRICE: " + item.getPrice() + "\n");
                }
                bufferedWriter.write("\n             PRICE: " + (new CompositeProduct(null)).ComputePrice(menuItemList) + "\n\n\n");
            }

            bufferedWriter.write("DATE: " + dateFormat.format(LocalDateTime.now()));
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void generateProductsMoreThanNreport(int n) {
        try {
            FileWriter fileWriter = new FileWriter("Report2.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(" Products ordered more than " + n + " times" + ":\n\n");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            Map<String, Integer> frequency = new HashMap<>();

            for (Orders order :  this.orders.keySet()) {
                List<MenuItem> menuItemList = this.orders.get(order);
                for (MenuItem item : menuItemList) {
                    frequency.computeIfPresent(item.getTitle(), (key, value) -> value + 1);
                    frequency.putIfAbsent(item.getTitle(), 1);
                }
            }

            for (String item : frequency.keySet()) {
                if (frequency.get(item) > n) {
                    bufferedWriter.write("   " + item + "was ordered " + frequency.get(item) + " times\n");
                }
            }

            bufferedWriter.write("DATE: " + dateFormat.format(LocalDateTime.now()));
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void generateProductOfDayReport(Date date) {
        try {
            FileWriter fileWriter = new FileWriter("Report4.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            bufferedWriter.write("Products ordered on day: " + date + ":\n\n");

            List<Orders> orderList = this.getOrders().keySet()
                    .stream()
                    .filter(x -> x.getOrderDate().getDayOfMonth() == date.getDate() && x.getOrderDate().getMonthValue() == (date.getMonth() + 1) && x.getOrderDate().getYear() == (date.getYear() + 1900))
                    .collect(Collectors.toList());


            Map<String, Integer> frequency = new HashMap<>();

            for (Orders order : orderList) {
                List<MenuItem> menuItemList = this.orders.get(order);
                for (MenuItem item : menuItemList) {
                    frequency.computeIfPresent(item.getTitle(), (key, value) -> value + 1);
                    frequency.putIfAbsent(item.getTitle(), 1);
                }
            }
            for (String item : frequency.keySet()) {
                bufferedWriter.write("   " + item + "\n");
            }
            bufferedWriter.write("DATE: " + dateFormat.format(LocalDateTime.now()));
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String getOrderTxt(Orders order, List<MenuItem> items) {
        return "Order:" + "Price: " + (new CompositeProduct(null)).ComputePrice(items) + "\n" + orders.get(order).toString();
    }

    public Map<Orders, List<MenuItem>> getOrders() {
        return orders;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    @Override
    public void notifyObservers(Observable o) {
        for (Observer obs : observers) {
            obs.update(o);
        }
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }
}




