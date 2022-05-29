package business;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private String title;
    private double rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;
    //private List<MenuItem> items;

    public MenuItem(String title, double rating, int calories, int proteins, int fats, int sodium, int price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
        //items = new ArrayList<MenuItem>();
    }
    public MenuItem(){

    }

    public int searchItemInList(List<MenuItem> list){
        for(MenuItem item : list){
            if(item.getTitle().equals(title))
                return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return  "title='" + title + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", sodium=" + sodium +
                ", price=" + price + "\n";
    }

    public double ComputeRating(List<MenuItem> items){
        int itemsNb = items.size();
        float sum = 0;

        for(MenuItem item : items){
            sum += item.getRating();
        }
        return sum/itemsNb;
    }

    public int ComputeCalories(List<MenuItem> items){
        int sum = 0;
        for(MenuItem item : items){
            sum += item.getCalories();
        }
        return sum;
    }

    public int ComputeProteins(List<MenuItem> items){
        int sum = 0;
        for(MenuItem item : items){
            sum += item.getProteins();
        }
        return sum;
    }

    public int ComputeFats(List<MenuItem> items){
        int sum = 0;
        for(MenuItem item : items){
            sum += item.getFats();
        }
        return sum;
    }

    public int ComputeSodium(List<MenuItem> items){
        int sum = 0;
        for(MenuItem item : items){
            sum += item.getSodium();
        }
        return sum;
    }

    public int ComputePrice(List<MenuItem> items){
        int sum = 0;
        for(MenuItem item : items){
            sum += item.getPrice();
        }
        return sum;
    }

   // public void setItems(List<MenuItem> items){
//        this.items = items;
//    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public int getCalories() {
        return calories;
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getSodium() {
        return sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
