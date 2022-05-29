package presentation;


import business.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller implements ActionListener {
    private LoginView loginView;
    private AdministratorView administratorView;
    private ClientView clientView;
    private AddProductView addProductView;
    private ModifyProductView modifyProductView;
    private SearchProductView searchProductView;
    private GenerateReportsView generateReportsView;
    private DeliveryService deliveryService;
    private DefaultTableModel tableModel;
    private EmployeeView employeeView;

    public  Controller(){
        loginView = new LoginView();
        administratorView = new AdministratorView();
        addProductView = new AddProductView();
        modifyProductView = new ModifyProductView();
        searchProductView = new SearchProductView();
        generateReportsView = new GenerateReportsView();
        clientView = new ClientView();
        employeeView = new EmployeeView();
        deliveryService = new DeliveryService();
        tableModel = new DefaultTableModel();


        loginView.setVisible(true);
        loginView.getLoginButton().addActionListener(this);

        deliveryService.addObserver(employeeView);

        administratorView.getImportCSVButton().addActionListener(this);
        administratorView.getViewAllButton().addActionListener(this);
        administratorView.getProductButton().addActionListener(this);
        administratorView.getDeleteButton().addActionListener(this);
        administratorView.getModifyButton().addActionListener(this);
        administratorView.getCreateProductButton().addActionListener(this);
        administratorView.getGenerateReportsButton().addActionListener(this);
        administratorView.getBackButton().addActionListener(this);

        clientView.getBackButton().addActionListener(this);
        clientView.getCreateOrderButton().addActionListener(this);
        clientView.getSearchButton().addActionListener(this);

        addProductView.getExitButton().addActionListener(this);
        addProductView.getInsertButton().addActionListener(this);

        modifyProductView.getExitButton().addActionListener(this);
        modifyProductView.getInsertButton().addActionListener(this);

        searchProductView.getSearchButton().addActionListener(this);
        searchProductView.getExitButton().addActionListener(this);

        generateReportsView.getOrdersReportButton().addActionListener(this);
        generateReportsView.getProductsOrderedButton().addActionListener(this);
        generateReportsView.getClientsReportButton().addActionListener(this);
        generateReportsView.getProductsDayButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        // login operations
        if (actionEvent.getSource() == loginView.getLoginButton()) {
            String username = loginView.getUserField().getText();
            String password = loginView.getPassField().getText();

            List<Users> user = deliveryService.getUsers().stream()
                    .filter(x -> x.getUsername().compareTo(username) == 0)
                    .filter(x -> x.getPassword().compareTo(password) == 0)
                    .collect(Collectors.toList());


            if(user.get(0).getType() == 0){
                administratorView.setVisible(true);
            }
            else{
                if(user.get(0).getType() == 1){
                    employeeView.setVisible(true);
                }
                else{
                    clientView.setClient(user.get(0));
                    tableModel =  deliveryService.createTable(deliveryService.getMenu());
                    clientView.setTable1(tableModel);
                    clientView.setVisible(true);
                }
            }

        }
        // admin operations
        if (actionEvent.getSource() == administratorView.getImportCSVButton()){
              deliveryService.ImportFromCSV("src/products.csv");
              //ArrayList<MenuItem> itm =(ArrayList<MenuItem>) deliveryService.getMenu();
        }

        if (actionEvent.getSource() == administratorView.getViewAllButton()){
            tableModel =  deliveryService.createTable(deliveryService.getMenu());
            administratorView.setTable(tableModel);
        }

        if (actionEvent.getSource() == administratorView.getProductButton()){
            addProductView.setVisible(true);
        }

        if (actionEvent.getSource() == addProductView.getExitButton()){
            addProductView.setVisible(false);
        }

        if (actionEvent.getSource() == addProductView.getInsertButton()){
            MenuItem item = getItemRow(addProductView.getTitleField(), addProductView.getRatingField(), addProductView.getCaloriesField(), addProductView.getProteinsField(), addProductView.getFatsField(), addProductView.getSodiumField(), addProductView.getPriceField());
            deliveryService.InsertProduct(item);
            tableModel =  deliveryService.createTable(deliveryService.getMenu());
            administratorView.setTable(tableModel);
            System.out.println(item);
        }

        if (actionEvent.getSource() == administratorView.getBackButton()){
            loginView.setVisible(true);
            administratorView.setVisible(false);
        }


        if (actionEvent.getSource() == administratorView.getDeleteButton()) {
            int row = administratorView.getTable().getSelectedRow();
            deliveryService.DeleteProduct(row);
            tableModel =  deliveryService.createTable(deliveryService.getMenu());
            administratorView.setTable(tableModel);
        }

        if(actionEvent.getSource() == administratorView.getModifyButton()){
            modifyProductView.setVisible(true);
            int row = administratorView.getTable().getSelectedRow();
            JTable table = administratorView.getTable();

            String title = table.getModel().getValueAt(row, 0).toString();
            Double rating = Double.parseDouble(table.getModel().getValueAt(row, 1).toString());
            int calories = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
            int proteins = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
            int fats = Integer.parseInt(table.getModel().getValueAt(row, 4).toString());
            int sodium = Integer.parseInt(table.getModel().getValueAt(row, 5).toString());
            int price = Integer.parseInt(table.getModel().getValueAt(row, 6).toString());

            modifyProductView.setTitleField(title);
            modifyProductView.setRatingField(rating.toString());
            modifyProductView.setCaloriesField(Integer.toString(calories));
            modifyProductView.setProteinsField(Integer.toString(proteins));
            modifyProductView.setFatsField(Integer.toString(fats));
            modifyProductView.setSodiumField(Integer.toString(sodium));
            modifyProductView.setPriceField(Integer.toString(price));
        }

        if (actionEvent.getSource() == modifyProductView.getExitButton()){
            modifyProductView.setVisible(false);
        }

        if(actionEvent.getSource() == modifyProductView.getInsertButton()){
            int row = administratorView.getTable().getSelectedRow();
            MenuItem item = getItemRow(modifyProductView.getTitleField(), modifyProductView.getRatingField(), modifyProductView.getCaloriesField(), modifyProductView.getProteinsField(), modifyProductView.getFatsField(), modifyProductView.getSodiumField(), modifyProductView.getPriceField());
            deliveryService.ModifyProduct(row, item);
            //modifyProductView.setVisible(false);
            tableModel =  deliveryService.createTable(deliveryService.getMenu());
            administratorView.setTable(tableModel);
        }

        if(actionEvent.getSource() == administratorView.getCreateProductButton()){
            int rows[] = administratorView.getTable().getSelectedRows();
            JTable table = administratorView.getTable();
            List<MenuItem> items = new ArrayList<>();
            for(int row : rows) {
                String title = table.getModel().getValueAt(row, 0).toString();
                Double rating = Double.parseDouble(table.getModel().getValueAt(row, 1).toString());
                int calories = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
                int proteins = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
                int fats = Integer.parseInt(table.getModel().getValueAt(row, 4).toString());
                int sodium = Integer.parseInt(table.getModel().getValueAt(row, 5).toString());
                int price = Integer.parseInt(table.getModel().getValueAt(row, 6).toString());
                items.add(new MenuItem(title,rating,calories,proteins,fats,sodium,price));
            }
            deliveryService.CreateProduct(items, administratorView.getMenNameField().getText());
            tableModel =  deliveryService.createTable(deliveryService.getMenu());
            administratorView.setTable(tableModel);
        }


        if(actionEvent.getSource() == administratorView.getGenerateReportsButton()) {
            generateReportsView.setVisible(true);
        }
        //orders in interval
        if(actionEvent.getSource() == generateReportsView.getOrdersReportButton()) {
            Time start = Time.valueOf(generateReportsView.getStartField().getText());
            Time end = Time.valueOf(generateReportsView.getEndField().getText());
            deliveryService.generateOrdersInIntervalReport(start, end);
        }

        if(actionEvent.getSource() == generateReportsView.getProductsOrderedButton()) {
            int n  = Integer.parseInt(generateReportsView.getnField().getText());
            deliveryService.generateProductsMoreThanNreport(n);
        }

        if(actionEvent.getSource() == generateReportsView.getClientsReportButton()) {
            int x  = Integer.parseInt(generateReportsView.getxField().getText());
            int y  = Integer.parseInt(generateReportsView.getyField().getText());
        }

        if(actionEvent.getSource() == generateReportsView.getProductsDayButton()) {
            Date day= Date.valueOf(generateReportsView.getDayField().getText());

            deliveryService.generateProductOfDayReport(day);
        }




        //Client

        if(actionEvent.getSource() == clientView.getSearchButton()) {
            searchProductView.setVisible(true);
        }

        if (actionEvent.getSource() == clientView.getBackButton()){
            loginView.setVisible(true);
            clientView.setVisible(false);
        }

        if(actionEvent.getSource() == clientView.getCreateOrderButton()){
            int rows[] = clientView.getTable().getSelectedRows();
            JTable table = clientView.getTable();
            int orderId = deliveryService.getOrders().size() + 1;
            Orders newOrder = new Orders(orderId, (int)clientView.getClient().getId());
            List<MenuItem> items = new ArrayList<>();
            for(int row : rows) {
                String title = table.getModel().getValueAt(row, 0).toString();
                Double rating = Double.parseDouble(table.getModel().getValueAt(row, 1).toString());
                int calories = Integer.parseInt(table.getModel().getValueAt(row, 2).toString());
                int proteins = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
                int fats = Integer.parseInt(table.getModel().getValueAt(row, 4).toString());
                int sodium = Integer.parseInt(table.getModel().getValueAt(row, 5).toString());
                int price = Integer.parseInt(table.getModel().getValueAt(row, 6).toString());
                items.add(new MenuItem(title,rating,calories,proteins,fats,sodium,price));
            }
            deliveryService.CreateOrder(newOrder,items);

            clientView.setBillField(deliveryService.getOrderTxt(newOrder, items));
//            tableModel =  deliveryService.createTable(deliveryService.getMenu());
//            clientView.setTable1(tableModel);
        }

        if (actionEvent.getSource() == searchProductView.getExitButton()){
            searchProductView.setVisible(false);
        }

        if (actionEvent.getSource() == searchProductView.getSearchButton()){
            String title = searchProductView.getTitleField().getText();
            Double minRating = Double.parseDouble(searchProductView.getRatingField().getText());
            int minCalories = Integer.parseInt(searchProductView.getCaloriesField().getText());
            int minProteins = Integer.parseInt(searchProductView.getProteinsField().getText());
            int minFats = Integer.parseInt(searchProductView.getFatsField().getText());
            int minSodium = Integer.parseInt(searchProductView.getSodiumField().getText());
            int minPrice = Integer.parseInt(searchProductView.getPriceField().getText());
            Double maxRating = Double.parseDouble(searchProductView.getRatingField1().getText());
            int maxCalories = Integer.parseInt(searchProductView.getCaloriesField1().getText());
            int maxProteins = Integer.parseInt(searchProductView.getProteinsField1().getText());
            int maxFats = Integer.parseInt(searchProductView.getFatsField1().getText());
            int maxSodium = Integer.parseInt(searchProductView.getSodiumField1().getText());
            int maxPrice = Integer.parseInt(searchProductView.getPriceField1().getText());
            List<MenuItem> filteredList = deliveryService.filterItems(title, minRating,minCalories,minProteins,minFats,minSodium,minPrice,maxRating,maxCalories,maxProteins,maxFats,maxSodium,maxPrice);


            tableModel =  deliveryService.createTable(filteredList);
            clientView.setTable1(tableModel);
        }


    }

    private MenuItem getItemRow(JTextField titleField, JTextField ratingField, JTextField caloriesField, JTextField proteinsField, JTextField fatsField, JTextField sodiumField, JTextField priceField) {
        String new_title = titleField.getText();
        Double new_rating = Double.parseDouble(ratingField.getText());
        int new_calories = Integer.parseInt(caloriesField.getText());
        int new_proteins = Integer.parseInt(proteinsField.getText());
        int new_fats = Integer.parseInt(fatsField.getText());
        int new_sodium = Integer.parseInt(sodiumField.getText());
        int new_price = Integer.parseInt(priceField.getText());

        return new MenuItem(new_title,new_rating,new_calories,new_proteins,new_fats,new_sodium,new_price);
    }


}
