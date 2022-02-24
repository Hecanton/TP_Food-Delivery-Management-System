package BusinessLogic;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem{
    private ArrayList<MenuItem>productItems ;

    public CompositeProduct(int id, String title, double rating, int calories, int proteins, int fat, int sodium, int price, ArrayList<MenuItem> productItems) {
        super(id, title, rating, calories, proteins, fat, sodium, price);
        this.productItems = productItems;
    }

    public int computePrice(){
        int pret=0;
        for(int i=0;i<productItems.size();i++){
            pret=pret+productItems.get(i).computePrice();
        }
        return pret;
    }
}
