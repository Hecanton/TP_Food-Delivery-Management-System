package BusinessLogic;

import java.util.Date;

public interface IDeliveryServicePeocessing {

    /**
     * Delete an item form menu
     * @pre menu.stream().anyMatch(menuItem -> menuItem.getId() == id)
     * @param id
     * @post menu.stream().noneMatch(menuItem -> menuItem.getId() == id)
     */
    void deleteFromMenu(int id);

    /**
     * Edits an item form menu
     * @pre title != null && rating > 0 && calories > 0 && protein > 0 && fat >0 && sodium > 0 && price > 0
     * @param id
     * @param title
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     */
    void updateMenuItem(int id,String title,double rating,int calories,int protein,int fat,int sodium,int price);

    /**
     * Adds an new item in the menu
     * @pre title != null && rating > 0 && calories > 0 && protein > 0 && fat >0 && sodium > 0 && price > 0
     * @param id
     * @param title
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     */
    void addInMenu(int id,String title,double rating,int calories,int protein,int fat,int sodium,int price);

    /**
     * Imports the initial set of items
     */
    void importMenu();

    /**
     * Creates a new composite item
     * @pre params!=null
     * @param id
     * @param title
     * @param rating
     * @param calories
     * @param proteins
     * @param fat
     * @param sodium
     * @param price
     * @param ids
     * @post menu.stream().anyMatch(menuItem -> menuItem.getId() == id)
     */
    void addToComposite(int id,String title,double rating, int calories, int proteins, int fat, int sodium, int price,int[] ids);

    /**
     * Creates the new user
     * @pre username!=null && password != null
     * @pre !regUsers.stream().anyMatch(user -> user.getId() == id)
     * @param id
     * @param username
     * @param password
     */
    void registerUser(int id,String username,String password);

    /**
     * Creates the posibility to log in
     * @pre username!=null && password!=null
     * @param username
     * @param password
     * @return
     */
    boolean loginUser(String username,String password);

    /**
     * Creates a string with all items from menu
     * @return
     */
    String viewMenu();

    /**
     * Creates an new order
     * @param odredId
     * @param userId
     * @param date
     * @param time
     * @param ids
     * @pre time >=0 && time <=24 && date!=null
     * @pre id_uri.stream().filter(id -> menu.stream().anyMatch(menuItem -> menuItem.getId() == id)).count()==id_uri.size()
     */
    void addOrder(int odredId, int userId, Date date, int time, int[] ids);

    /**
     * Gets the current Client's id
     * @return
     */
    int getUserId();

    /**
     * Checks if a user may login
     * @return
     */
    boolean isLoggedIn();

    /**
     * Makes a search by a input keyword
     * @param title
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     * @return
     */
    String searchItem(String title,double rating,int calories,int protein,int fat,int sodium,int price);

    /**
     * Make a search in menu by rating
     * @param rating
     * @return
     */
    String searchByRating(double rating);

    /**
     * Makes a search in menu items by calories
     * @param calories
     * @return
     */
    String searchByCalories(int calories);

    /**
     * Makes a search in menu items by Proteins
     * @param protein
     * @return
     */
    String searchByProtein(int protein);

    /**
     * Makes a search in menu items by fats
     * @param fat
     * @return
     */
    String searchByFat(int fat);

    /**
     * Makes a search in menu items by the input of sodium
     * @param sodium
     * @return
     */
    String searchBySodium(int sodium);

    /**
     * Makes a search in menu items by input of price
     * @param price
     * @return
     */
    String searchByPrice(int price);

    /**
     * Generates a raport ordered between a given hour interval
     * @param startH
     * @param endH
     * @return
     * @pre startH >= 0 && endH >=0 && startH < endH && endH <=24
     */
    String timeIntervalReport(int startH,int endH);

    /**
     * Generates a raport of orders
     * @pre nr>=0
     * @param nr
     * @return
     */
    String numberOfOrders(int nr);

    /**
     * Generates a raport by the number of orders and a specified value of the orders
     * @pre nr>=0 && min >=0
     * @param nr
     * @param min
     * @return
     */
    String usersReport(int nr,int min);

    /**
     * @pre date != null
     * @param date
     * @return
     */
    String dateReport(Date date);
}
