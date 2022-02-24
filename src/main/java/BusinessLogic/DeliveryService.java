package BusinessLogic;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * This class implements the functionalities of the management sistem
 * @invariant isWellFormed()
 */
public class DeliveryService implements IDeliveryServicePeocessing{
    /**
     * The menu
     */
    ArrayList<MenuItem> menu = new ArrayList<>();

    /**
     * Orders with ordered products
     */
    Map<Order, List<MenuItem>> service = new HashMap<>();

    /**
     * List of users
     */
    ArrayList<User> regUsers = new ArrayList<>();
    boolean loggedIn = false;
    int userId = -1;

    /**
     * @invariant isWellFormed()
     * @return
     */
    public boolean isWellFormed(){
        return menu != null && service != null && regUsers !=null;
     }

    public void setUserId(String name){
        for(User usr : regUsers){
            if(usr.getUser().equals(name)){
                userId =usr.getId();
            }
        }
    }

    public int getUserId(){
        return userId;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    @Override
    /*
    public void importMenu() {
        assert isWellFormed();
        Scanner scanner;
        try{
            scanner = new Scanner(new FileInputStream(new File("products.csv")));
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return;
        }
        scanner.nextLine();
        int id=1;
        while (scanner.hasNext()){
            int ok=0;
            String s = scanner.nextLine();
            String title = s.split(",")[0];
            double rating = Double.parseDouble(s.split(",")[1]);
            int cal = Integer.parseInt(s.split(",")[2]);
            int prot = Integer.parseInt(s.split(",")[3]);
            int fat = Integer.parseInt(s.split(",")[3]);
            int sod = Integer.parseInt(s.split(",")[4]);
            int pri = Integer.parseInt(s.split(",")[5]);

            for(MenuItem m :menu){
                if(m.getTitle().equals(title)){
                    ok=1;
                    break;
                }
            }
            if(ok==0){
                menu.add(new BaseProduct(id,title,rating,cal,prot,fat,sod,pri));
                id++;
            }
        }
        scanner.close();
        assert isWellFormed();
    }
*/
    public void importMenu() {
        assert isWellFormed();
        List<BaseProduct> men = new ArrayList<>();
        int i=1;
        try (Stream<String> fisier = Files.lines(Paths.get("products.csv"))){
            men = fisier.skip(1).map(line -> line.split(","))
                    .map(line -> new BaseProduct(0,line[0],Double.parseDouble(line[1]),Integer.parseInt(line[2]),Integer.parseInt(line[3]),Integer.parseInt(line[4]),Integer.parseInt(line[5]),Integer.parseInt(line[6])))
                    .distinct().collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }

        for(MenuItem item:men){
            int ok=0;
            for (MenuItem item2:men){
                if(item.getTitle().equals(item2.getTitle()))
                    ok++;
            }
            if(ok<=1){
            item.setId(i++);
            menu.add(item);
            }
        }


    }
    public void addInMenu(int id,String title,double rating,int calories,int protein,int fat,int sodium,int price){
        assert isWellFormed();
        //assert menu.stream().noneMatch(menuItem -> menuItem.getId() == id);
        assert title != null && rating > 0 && calories > 0 && protein > 0 && fat >0 && sodium > 0 && price > 0;

        for(MenuItem item: menu){
            if(item.getId()==id)
                return;
        }
        menu.add(new BaseProduct(id, title, rating, calories, protein, fat, sodium, price));
        assert isWellFormed();
    }

    public void addToComposite(int id,String title,double rating, int calories, int proteins, int fat, int sodium, int price, int[] ids){
        assert isWellFormed();
        ArrayList<Integer> id_uri = new ArrayList<>();
        for(Integer inte: ids){
            id_uri.add(inte);
        }

        assert id_uri.stream().anyMatch((id2 -> menu.stream().anyMatch(menuItem -> menuItem.getId()==id2)));

        ArrayList<MenuItem> compItems =(ArrayList<MenuItem>) menu.stream().filter(menuItem -> id_uri.stream().anyMatch(id2 -> id2 == menuItem.getId())).collect(toList());
        menu.add(new CompositeProduct(id, title,rating,calories,proteins,fat ,sodium,price,compItems));

        assert menu.stream().anyMatch(menuItem -> menuItem.getId() == id);
        assert isWellFormed();
    }

    public String timeIntervalReport(int startH,int endH){
        assert startH >= 0 ;
        assert endH >=0 ;
        assert startH < endH;
        assert endH <=24;
        ArrayList<Order> orders =(ArrayList<Order>) service.keySet().stream().filter(order -> order.getTime() >= startH && order.getTime() <= endH).collect(toList());
        String ord="";
        for(Order or:orders){
            ord=ord+or.toString()+"\n";
        }
        assert isWellFormed();
        return ord;
    }

    @Override
    public void deleteFromMenu(int id) {
        assert menu.stream().anyMatch(menuItem -> menuItem.getId() == id);
        assert isWellFormed();
        menu.remove(menu.stream().filter(menuItem -> menuItem.getId() == id).collect(Collectors.toList()).get(0));
        assert menu.stream().noneMatch(menuItem -> menuItem.getId() == id);
        assert isWellFormed();
    }

    public void updateMenuItem(int id,String title,double rating,int calories,int protein,int fat,int sodium,int price){
        assert menu.stream().anyMatch(menuItem -> menuItem.getId() == id && menuItem instanceof BaseProduct);
        assert title != null && rating > 0 && calories > 0 && protein > 0 && fat >0 && sodium > 0 && price > 0;
        assert isWellFormed();
        BaseProduct baseProduct = (BaseProduct) menu.stream()
                .filter(menuItem -> menuItem.getId() == id).collect(Collectors.toList()).get(0);
        baseProduct.setTitle(title);
        baseProduct.setRating(rating);
        baseProduct.setCalories(calories);
        baseProduct.setProteins(protein);
        baseProduct.setFat(fat);
        baseProduct.setSodium(sodium);
        baseProduct.setPrice(price);
        assert isWellFormed();
    }

    public String numberOfOrders(int nr){
        assert nr>=0;
        assert isWellFormed();
        long numar=0;
        String nrord="";
        for(MenuItem item:menu){
            numar = service.entrySet().stream().filter(p->p.getValue().contains(item)).count();
            if(numar>=nr)
                nrord = nrord + item.getTitle()+"\n";
        }
        assert isWellFormed();
        return nrord;
    }

    public String usersReport(int nr,int min){
        assert isWellFormed();
        assert nr>=0 && min >=0;
        ArrayList<User> selUsers = (ArrayList<User>) regUsers.stream().
                filter(user -> service.keySet().stream()
                        .filter(order -> order.getUserId() == user.getId() && service.get(order).stream().map(menuItem -> menuItem.computePrice())
                                .mapToInt(Integer::intValue).sum() >= min).count() >= nr).collect(toList());
        String usr="";
        for(User user:selUsers){
            usr=usr+user.toString()+"\n";
        }
        assert isWellFormed();
        return usr;
    }

    public String dateReport(Date date){
        assert isWellFormed();
        assert date != null;
        ArrayList<MenuItem> dupProd = new ArrayList<>();
        service.keySet().stream().filter(order -> order.getDate().equals(date)).forEach(order -> dupProd.addAll(service.get(order)));
        Map<MenuItem, Integer> nrApar = new HashMap<>();
        for(MenuItem menuItem:dupProd){
            Integer nr=nrApar.get(menuItem);
            if(nr==null) {
                nr=0;
            }
            nrApar.put(menuItem,nr+1);
        }
        String nApa="";
        for (MenuItem menuItem:nrApar.keySet()) {
            nApa=nApa+menuItem+" "+"Count:"+nrApar.get(menuItem)+"\n";
        }
        assert isWellFormed();
        return nApa;
    }

    @Override
    public void registerUser(int id, String username, String password) {
        assert isWellFormed();
        assert username!=null && password != null;
        assert !regUsers.stream().anyMatch(user -> user.getId() == id);
        regUsers.add(new User(id,username,password));
        assert isWellFormed();
    }

    @Override
    public boolean loginUser(String username, String password) {
        assert username!=null && password!=null;
        assert isWellFormed();
        boolean tru = regUsers.stream().filter(user -> user.getUser().equals(username)).anyMatch(user -> user.getPassword().equals(password));
        loggedIn = tru;
        if(loggedIn)
            setUserId(username);
        assert isWellFormed();
        return tru;
    }

    @Override
    public String viewMenu() {
        assert isWellFormed();
        String men="";
        for(MenuItem item:menu){
            men=men+item.toString()+"\n";
        }
        isWellFormed();
        return men;
    }

    @Override
    public void addOrder(int odredId, int userId, Date date, int time, int[] ids) {
        List<Integer>id_uri = new ArrayList<>();
        for(Integer x : ids){
            id_uri.add(x);
        }
        assert isWellFormed();
        assert id_uri.stream().filter(id -> menu.stream().anyMatch(menuItem -> menuItem.getId() == id)).count()==id_uri.size();
        assert time >=0 && time <=24 && date!=null;
        Order ord = new Order(odredId,userId,date,time);
        service.put(ord,menu.stream().filter(menuItem -> id_uri.stream().filter(id2 ->id2 == menuItem.getId())
                .count()>0).collect(Collectors.toList()));

        String clname="";
        for(User u:regUsers){
            if(u.getId()==userId)
                clname+=u.getUser();
        }
        int price=0;
        for(int i=0;i<ids.length;i++){
            int j=ids[i];
            for(MenuItem m:menu){
                if(m.getId()==j)
                    price += m.getPrice();
            }
        }

        String textBill =" Order id="+odredId+"\n Client Name="+clname+"\n Price="+price;
        try {
            FileWriter fileWriter = new FileWriter("BillNumber"+odredId+".txt");
            fileWriter.write(textBill);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        assert isWellFormed();
    }

    public String searchItem(String title,double rating,int calories,int protein,int fat,int sodium,int price){
        assert isWellFormed();
        String items="";
        for(MenuItem itm: menu){
            if(itm.getTitle().equals(title))
                items=items+itm.toString();
        }
        assert isWellFormed();
        return items;
    }

    public String searchByRating(double rating){
        assert isWellFormed();
        String items="";
        for(MenuItem itm: menu){
            if(itm.getRating()==(rating))
                items=items+itm.toString()+"\n";
        }
        assert isWellFormed();
        return items;
    }

    public String searchByCalories(int calories){
        assert isWellFormed();
        String items="";
        for(MenuItem itm: menu){
            if(itm.getCalories()==(calories))
                items=items+itm.toString()+"\n";
        }
        assert isWellFormed();
        return items;
    }

    public String searchByProtein(int protein){
        assert isWellFormed();
        String items="";
        for(MenuItem itm: menu){
            if(itm.getProteins()==(protein))
                items=items+itm.toString()+"\n";
        }
        assert isWellFormed();
        return items;
    }

    public String searchByFat(int fat){
        assert isWellFormed();
        String items="";
        for(MenuItem itm: menu){
            if(itm.getFat()==(fat))
                items=items+itm.toString()+"\n";
        }
        assert isWellFormed();
        return items;
    }

    public String searchBySodium(int sodium){
        assert isWellFormed();
        String items="";
        for(MenuItem itm: menu){
            if(itm.getSodium()==(sodium))
                items=items+itm.toString()+"\n";
        }
        assert isWellFormed();
        return items;
    }

    public String searchByPrice(int price){
        assert isWellFormed();
        String items="";
        for(MenuItem itm: menu){
            if(itm.getPrice()==(price))
                items=items+itm.toString()+"\n";
        }
        assert isWellFormed();
        return items;
    }

}
