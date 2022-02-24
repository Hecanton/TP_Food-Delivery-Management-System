package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewLogin extends JFrame {
    private JTextField insertId     = new JTextField(2);
    private JTextField insertUserName = new JTextField(7);
    private JTextField insertPassword = new JTextField(10);

    private JButton    loginBtn = new JButton("Login");
    private JButton    registerBtn    = new JButton("Register");


    public ViewLogin(){
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(100,70));
        add (content);

        JPanel content2=new JPanel();
        JPanel content3=new JPanel();
        JPanel content4=new JPanel();
        JPanel content5=new JPanel();

        content3.setLayout(new BorderLayout(10,10));
        content2.setLayout(new FlowLayout());
        content4.setLayout(new FlowLayout());
        content5.setLayout(new FlowLayout());

        content2.add(new JLabel("ID"));
        content2.add(insertId);
        content2.add(new JLabel("UserName"));
        content2.add(insertUserName);
        content2.add(new JLabel("Password"));
        content2.add(insertPassword);

        JLabel productsLabel = new JLabel("LOGIN",JLabel.CENTER);
        productsLabel.setFont(new Font("Serif", Font.PLAIN, 24));
        content4.add(productsLabel);
        content5.add(loginBtn);
        content5.add(registerBtn);




        content3.add(content4,"North");
        content3.add(content2,"Center");
        content3.add(content5,"South");

        content.add(content3,"North");

        this.setLocation(500,200);
        this.setContentPane(content);
        this.setSize(1000,10000);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.setTitle("Login View");
    }
    public String getIdInput() { return insertId.getText();}
    public String getUserNameInput() { return insertUserName.getText();}
    public String getPasswordInput() { return insertPassword.getText(); }

    public void addLoginListener(ActionListener actionListener){
        loginBtn.addActionListener(actionListener);
    }

    public void addRegisterListener(ActionListener actionListener) {
        registerBtn.addActionListener(actionListener);
    }
}
