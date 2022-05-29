package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.*;
import java.awt.*;
/**
 * UI Class for selecting the operation on Product table
 */

public class AddProductView extends JFrame{
    private JLabel titleLabel;
    private JLabel ratingLabel;
    private JLabel caloriesLabel;
    private JLabel proteinsLabel;
    private JLabel fatsLabel;
    private JLabel sodiumLabel;
    private JLabel priceLabel;
    private JTextField titleField;
    private JTextField ratingField;
    private JTextField caloriesField;
    private JTextField proteinsField;
    private JTextField fatsField;
    private JTextField sodiumField;
    private JTextField priceField;
    private JButton insertButton;
    private JButton exitButton;
    private JTextField message;


    public AddProductView(){
        titleLabel = new JLabel("   Title  ");
        ratingLabel = new JLabel("   Rating  ");
        caloriesLabel = new JLabel("   Calories  ");
        proteinsLabel = new JLabel("   Proteins  ");
        fatsLabel = new JLabel("   Fats  ");
        sodiumLabel = new JLabel("   Sodium  ");
        priceLabel = new JLabel("   Price  ");
        titleField = new JTextField();
        ratingField = new JTextField();
        caloriesField = new JTextField();
        proteinsField = new JTextField();
        fatsField = new JTextField();
        sodiumField = new JTextField();
        priceField = new JTextField();


        priceField = new JTextField();

        insertButton = new JButton("INSERT");
        exitButton = new JButton("EXIT");

        message = new JTextField();

        this.setSize(600,350);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add product");
        this.setBackground(Color.white);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        this.setContentPane(panel1);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel2.setLayout(new GridLayout(7,2));

        panel2.add(titleLabel);
        panel2.add(titleField);
        panel2.add(ratingLabel);
        panel2.add(ratingField);
        panel2.add(caloriesLabel);
        panel2.add(caloriesField);
        panel2.add(proteinsLabel);
        panel2.add(proteinsField);
        panel2.add(fatsLabel);
        panel2.add(fatsField);
        panel2.add(sodiumLabel);
        panel2.add(sodiumField);
        panel2.add(priceLabel);
        panel2.add(priceField);


        panel3.add(insertButton);
        panel3.add(exitButton);

        panel1.add(panel2);
        panel1.add(panel3);

        message.setEditable(false);
        panel1.add(message);

        this.setVisible(false);
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getRatingField() {
        return ratingField;
    }

    public JTextField getCaloriesField() {
        return caloriesField;
    }

    public JTextField getProteinsField() {
        return proteinsField;
    }

    public JTextField getFatsField() {
        return fatsField;
    }

    public JTextField getSodiumField() {
        return sodiumField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setTitleField(String titleField) {
        this.titleField.setText(titleField);
    }

    public void setRatingField(String ratingField) {
        this.ratingField.setText(ratingField);
    }

    public void setCaloriesField(String caloriesField) {
        this.caloriesField.setText(caloriesField);
    }

    public void setProteinsField(String proteinsField) {
        this.proteinsField.setText(proteinsField);
    }

    public void setFatsField(String fatsField) {
        this.fatsField.setText(fatsField);
    }

    public void setSodiumField(String sodiumField) {
        this.sodiumField.setText(sodiumField);
    }

    public void setPriceField(String priceField) {
        this.priceField.setText(priceField);
    }

    public void setMessage(JTextField message) {
        this.message = message;
    }
}
