package business;

import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface IDeliveryServiceProcessing {
     List<MenuItem> ImportFromCSV(String csvFileName);
     DefaultTableModel createTable(List<MenuItem> list);
     List<MenuItem> getMenu();
     void InsertProduct(MenuItem item);
     void DeleteProduct(int row);
     void ModifyProduct(int row, MenuItem item);
     void CreateProduct(List<MenuItem> items, String name);
     void CreateOrder(Orders order, List<MenuItem> items);
     void generateBill(Orders order, List<MenuItem> menuItemList);
     void generateOrdersInIntervalReport(Time start, Time end);
     void generateProductsMoreThanNreport(int n);
     void generateProductOfDayReport(Date date);
     List<MenuItem> filterItems(String title,Double minRating,int minCalories,int minProteins,int minFats,int minSodium,int minPrice,double maxRating,int maxCalories,int maxProteins,int maxFats,int maxSodium,int maxPrice);
}
