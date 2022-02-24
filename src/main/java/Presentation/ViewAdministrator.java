package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewAdministrator extends JFrame {
    private JTextField insertId     = new JTextField(2);
    private JTextField insertTitle = new JTextField(7);
    private JTextField insertProtein = new JTextField(10);
    private JTextField insertRating     = new JTextField(10);
    private JTextField insertCalories     = new JTextField(2);
    private JTextField insertFat     = new JTextField(2);
    private JTextField insertSodium     = new JTextField(2);
    private JTextField insertPrice     = new JTextField(2);

    private JTextField insertCompositeID     = new JTextField(2);
    private JTextField insertAllID     = new JTextField(4);
    private JTextField insertCompositeTitle     = new JTextField(7);

    private JTextField insertStartHour    = new JTextField(2);
    private JTextField insertEndHour     = new JTextField(2);
    private JTextField insertMinOrder    = new JTextField(2);
    private JTextField insertDateReport    = new JTextField(6);

    private JTextField insertMinOrderCount    = new JTextField(2);
    private JTextField insertMinOrderValue    = new JTextField(2);

    private JTextArea result = new JTextArea(10,40);

    private JButton    clientsBtn = new JButton("CLIENTS REPORT");

    private JButton    dateBtn = new JButton("DATE REPORT");

    private JButton    countBtn = new JButton("COUNT REPORT");

    private JButton    hourBtn = new JButton("HOUR REPORT");

    private JButton    addBtn = new JButton("ADD");
    private JButton    deleteBtn    = new JButton("DELETE");
    private JButton    modifyBtn = new JButton("MODIFY");
    private JButton    importBtn    = new JButton("IMPORT");


    private JButton    compositeBtn = new JButton("INSERT COMPOSITE PRODUCTS");



    public ViewAdministrator(){
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

        content2.add(new JLabel("ID"));
        content2.add(insertId);
        content2.add(new JLabel("Title"));
        content2.add(insertTitle);
        content2.add(new JLabel("Rating"));
        content2.add(insertRating);
        content2.add(new JLabel("Calories"));
        content2.add(insertCalories);
        content2.add(new JLabel("Protein"));
        content2.add(insertProtein);
        content2.add(new JLabel("Fat"));
        content2.add(insertFat);
        content2.add(new JLabel("Sodium"));
        content2.add(insertSodium);
        content2.add(new JLabel("Price"));
        content2.add(insertPrice);

        JLabel clientLabel = new JLabel("ADMINISTRATOR",JLabel.CENTER);
        clientLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        content4.add(clientLabel);
        content5.add(addBtn);
        content5.add(deleteBtn);
        content5.add(modifyBtn);
        content5.add(importBtn);
        content5.add(deleteBtn);

        content7.add(new JLabel("ID"));
        content7.add(insertCompositeID);
        content7.add(new JLabel("CompositeID"));
        content7.add(insertAllID);
        content7.add(new JLabel("Title"));
        content7.add(insertCompositeTitle);

        content7.add(compositeBtn);

        content8.add(new JLabel("Start Hour"));
        content8.add(insertStartHour);
        content8.add(new JLabel("End Hour"));
        content8.add(insertEndHour);
        content8.add(hourBtn);

        content8.add(new JLabel("Min Orders Count"));
        content8.add(insertMinOrder);
        content8.add(countBtn);

        content8.add(new JLabel("Date Raport"));
        content8.add(insertDateReport);
        content8.add(dateBtn);

        content8.add(new JLabel("Min Order Count"));
        content8.add(insertMinOrderCount);
        content8.add(new JLabel("Min Order Value"));
        content8.add(insertMinOrderValue);
        content8.add(clientsBtn);

        result.setEditable(false);
        JScrollPane scroll = new JScrollPane(result);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        content9.add(new JScrollPane(scroll));

        content3.add(content4,"North");
        content3.add(content2,"Center");
        content3.add(content5,"South");

        content6.add(content7,"North");
        content6.add(content8,"Center");
        content6.add(content9,"South");


        content.add(content3,"North");
        content.add(content6,"Center");




        this.setLocation(150,200);
        this.setContentPane(content);
        this.setSize(1000,10000);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.setTitle("Admin View");
    }

    public void setMenu(String menu){ result.setText(menu);}

    public String getId1Input() { return insertId.getText();}
    public String getTitleInput() { return insertTitle.getText();}
    public String getRatingInput() { return insertRating.getText(); }
    public String getCaloriesInput() { return insertCalories.getText(); }
    public String getProteinInput() { return insertProtein.getText();}
    public String getFatInput() { return insertFat.getText();}
    public String getSodiumInput() { return insertSodium.getText(); }
    public String getPriceInput() { return insertPrice.getText(); }

    public String getCompositeIdInput() { return insertCompositeID.getText();}
    public String getALLIdInput() { return insertAllID.getText();}
    public String getCompositeTitleInput() { return insertCompositeTitle.getText();}

    public String getStartHourInput() { return insertStartHour.getText();}
    public String getEndHourInput() { return insertEndHour.getText();}

    public String getMinOrderCountInput() { return insertMinOrder.getText();}

    public String getDateRaportInput() { return insertDateReport.getText();}

    public String getMinOrderCount2Input() { return insertMinOrderCount.getText();}
    public String getMinOrderValueInput() { return insertMinOrderValue.getText();}

    public void addADDListener(ActionListener actionListener){
        addBtn.addActionListener(actionListener);
    }
    public void addModifyListener(ActionListener actionListener){
        modifyBtn.addActionListener(actionListener);
    }
    public void addImportListener(ActionListener actionListener){
        importBtn.addActionListener(actionListener);
    }
    public void addDeleteListener(ActionListener actionListener){
        deleteBtn.addActionListener(actionListener);
    }
    public void addInsertCompositeListener(ActionListener actionListener){
        compositeBtn.addActionListener(actionListener);
    }
    public void addHourReportListener(ActionListener actionListener){
        hourBtn.addActionListener(actionListener);
    }
    public void addCountReportListener(ActionListener actionListener){
        countBtn.addActionListener(actionListener);
    }
    public void addDateRaportListener(ActionListener actionListener){
        dateBtn.addActionListener(actionListener);
    }
    public void addClientRaportListener(ActionListener actionListener){
        clientsBtn.addActionListener(actionListener);
    }
}
