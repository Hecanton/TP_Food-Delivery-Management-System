package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewClient extends JFrame {
    private JTextField insertOrderId     = new JTextField(2);
    private JTextField insertProductId = new JTextField(7);
    private JTextField insertDate = new JTextField(10);
    private JTextField insertHour     = new JTextField(10);

    private JTextField insertTitle     = new JTextField(5);
    private JTextField insertRating     = new JTextField(2);
    private JTextField insertCalories     = new JTextField(2);
    private JTextField insertProtein     = new JTextField(2);
    private JTextField insertFat     = new JTextField(2);
    private JTextField insertSodium     = new JTextField(2);
    private JTextField insertPrice     = new JTextField(2);

    private JTextArea result = new JTextArea(10,40);

    private JButton    orderBtn = new JButton("Order");
    private JButton    searchBtn = new JButton("SearchByTitle");
    private JButton    searchRateBtn = new JButton("SearchByRateing");
    private JButton    searchCalBtn = new JButton("SearchByCalories");
    private JButton    searchProtBtn = new JButton("SearchByProteins");
    private JButton    searchFatBtn = new JButton("SearchByFats");
    private JButton    searchSodiuBtn = new JButton("SearchBySodium");
    private JButton    searchPriceBtn = new JButton("SearchByPrice");
    private JButton    menuBtn = new JButton("Menu");

    public ViewClient(){
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(100,70));
        add (content);

        JPanel content2=new JPanel();
        JPanel content3=new JPanel();
        JPanel content4=new JPanel();
        JPanel content5=new JPanel();

        JPanel content6=new JPanel();
        JPanel content7=new JPanel();
        JPanel content8=new JPanel();
        JPanel content9=new JPanel();

        content3.setLayout(new BorderLayout(10,10));
        content2.setLayout(new FlowLayout());
        content4.setLayout(new FlowLayout());
        content5.setLayout(new FlowLayout());

        content6.setLayout(new BorderLayout(10,10));
        content7.setLayout(new FlowLayout());
        content8.setLayout(new FlowLayout());
        content9.setLayout(new FlowLayout());

        content2.add(new JLabel("OrderID"));
        content2.add(insertOrderId);
        content2.add(new JLabel("ProductsID"));
        content2.add(insertProductId);
        content2.add(new JLabel("Date"));
        content2.add(insertDate);
        content2.add(new JLabel("Hour"));
        content2.add(insertHour);

        JLabel clientLabel = new JLabel("CLIENT",JLabel.CENTER);
        clientLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        content4.add(clientLabel);
        content5.add(orderBtn);



        content7.add(new JLabel("Title"));
        content7.add(insertTitle);
        content7.add(new JLabel("Rating"));
        content7.add(insertRating);
        content7.add(new JLabel("Calories"));
        content7.add(insertCalories);
        content7.add(new JLabel("Protein"));
        content7.add(insertProtein);
        content7.add(new JLabel("Fat"));
        content7.add(insertFat);
        content7.add(new JLabel("Sodium"));
        content7.add(insertSodium);
        content7.add(new JLabel("Price"));
        content7.add(insertPrice);

        content8.add(searchBtn);
        content8.add(searchRateBtn);
        content8.add(searchCalBtn);
        content8.add(searchProtBtn);
        content8.add(searchFatBtn);
        content8.add(searchSodiuBtn);
        content8.add(searchPriceBtn);

        result.setEditable(false);
        JScrollPane scroll = new JScrollPane(result);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        content9.add(menuBtn);
        content9.add(new JScrollPane(scroll));


        content3.add(content4,"North");
        content3.add(content2,"Center");
        content3.add(content5,"South");

        content6.add(content7,"North");
        content6.add(content8,"Center");
        content6.add(content9,"South");


        content.add(content3,"North");
        content.add(content6,"Center");


        this.setLocation(500,200);
        this.setContentPane(content);
        this.setSize(1000,10000);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.setTitle("Client View");
    }

    public String getOrderIdInput() { return insertOrderId.getText();}
    public String getProductDInput() { return insertProductId.getText();}
    public String getDateInput() { return insertDate.getText(); }
    public String getHourInput() { return insertHour.getText(); }

    public void setMenu(String menu){ result.setText(menu);}

    public String getTitleInput() { return insertTitle.getText();}
    public String getRatingInput() { return insertRating.getText();}
    public String getCaloriesInput() { return insertCalories.getText(); }
    public String getProteinInput() { return insertProtein.getText(); }
    public String getFatInput() { return insertFat.getText(); }
    public String getSodiumInput() { return insertSodium.getText(); }
    public String getPriceInput() { return insertPrice.getText(); }

    public void addOrderListener(ActionListener actionListener){
        orderBtn.addActionListener(actionListener);
    }

    public void addSearchListener(ActionListener actionListener) {
        searchBtn.addActionListener(actionListener);
    }

    public void addSearchByRateListener(ActionListener actionListener) {
        searchRateBtn.addActionListener(actionListener);
    }

    public void addSearchByProtListener(ActionListener actionListener) {
        searchProtBtn.addActionListener(actionListener);
    }

    public void addSearchByCalListener(ActionListener actionListener) {
        searchCalBtn.addActionListener(actionListener);
    }

    public void addSearchByFatListener(ActionListener actionListener) {
        searchFatBtn.addActionListener(actionListener);
    }
    public void addSearchBySodiumListener(ActionListener actionListener) {
        searchSodiuBtn.addActionListener(actionListener);
    }
    public void addSearchByPriceListener(ActionListener actionListener) {
        searchPriceBtn.addActionListener(actionListener);
    }
    public void addMenuListener(ActionListener actionListener) {
        menuBtn.addActionListener(actionListener);
    }

}
