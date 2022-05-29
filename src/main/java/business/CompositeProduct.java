package business;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct  extends MenuItem{
    private List<MenuItem> compItem;
    public CompositeProduct(String title) {
        super(title, 0, 0, 0, 0, 0, 0);
        compItem = new ArrayList<>();
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

    public List<MenuItem> getCompItem() {
        return compItem;
    }

    public void setCompItem(List<MenuItem> compItem) {
        this.compItem = compItem;
    }
}
