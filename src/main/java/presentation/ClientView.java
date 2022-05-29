package presentation;

import business.Users;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class ClientView extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton CreateOrderButton;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JButton backButton;
    private JButton searchButton;
    private JTextPane billField;
    private Users client;

    public ClientView() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(30, 25, 400, 250);
        contentPane.add(scrollPane1);

        table = new JTable();
        scrollPane1.setViewportView(table);

        CreateOrderButton = new JButton("Create Order");
        CreateOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 13));

        CreateOrderButton.setBounds(30, 300, 120, 25);
        contentPane.add(CreateOrderButton);

        backButton = new JButton("Back");
        backButton.setBounds(30, 425, 60, 25);
        contentPane.add(backButton);

        searchButton = new JButton("Search");
        searchButton.setBounds(190, 300, 120, 25);
        contentPane.add(searchButton);

        scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(30, 330, 400, 80);
        contentPane.add(scrollPane2);

        billField = new JTextPane();
        billField.setEditable(false);
        scrollPane2.setViewportView(billField);

    }


    public JButton getCreateOrderButton() {
        return CreateOrderButton;
    }

    public void setTable1(DefaultTableModel tModel) {
        table = new JTable(tModel);
        scrollPane1.setViewportView(table);
    }

    public void setClient(Users client) {
        this.client = client;
    }

    public JTable getTable() {
        return table;
    }

    public Users getClient() {
        return client;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBillField(String text) {
        this.billField.setText(text);
    }
}
