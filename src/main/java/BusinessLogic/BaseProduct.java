package BusinessLogic;

public class BaseProduct extends MenuItem{

    public BaseProduct(int id, String title, double rating, int calories, int proteins, int fat, int sodium, int price) {
        super(id, title, rating, calories, proteins, fat, sodium, price);
    }

    public int computePrice(){return this.getPrice();}

    public String toString(){
        return  super.toString();
    }
}
