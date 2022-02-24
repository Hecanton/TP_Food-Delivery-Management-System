package BusinessLogic;

public class MenuItem {
    private int id;
    private String title;
    private double rating;
    private int calories;
    private int proteins;
    private int fat;
    private int sodium;
    private int price;

    public MenuItem(){ }

    public MenuItem(int id, String title, double rating, int calories, int proteins, int fat, int sodium, int price) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int computePrice(){return -1;}

    public String toString(){
        return "MenuItem: " + "id=" + id + " ,tile=" + title + " ,price=" +computePrice() + ". ";
    }

}
