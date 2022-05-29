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

public class SearchProductView extends JFrame{
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
    private JTextField titleField1;
    private JTextField ratingField1;
    private JTextField caloriesField1;
    private JTextField proteinsField1;
    private JTextField fatsField1;
    private JTextField sodiumField1;
    private JTextField priceField1;
    private JButton SearchButton;
    private JButton exitButton;
    private JTextField message;


    public SearchProductView(){
        titleLabel = new JLabel("   Title  ");
        ratingLabel = new JLabel("   Rating  ");
        caloriesLabel = new JLabel("   Calories  ");
        proteinsLabel = new JLabel("   Proteins  ");
        fatsLabel = new JLabel("   Fats  ");
        sodiumLabel = new JLabel("   Sodium  ");
        priceLabel = new JLabel("   Price  ");
        titleField = new JTextField("0");
        ratingField = new JTextField("0");
        caloriesField = new JTextField("0");
        proteinsField = new JTextField("0");
        fatsField = new JTextField("0");
        sodiumField = new JTextField("0");
        priceField = new JTextField("0");
        titleField1 = new JTextField("xx");
        ratingField1 = new JTextField("9999999");
        caloriesField1 = new JTextField("9999999");
        proteinsField1 = new JTextField("9999999");
        fatsField1 = new JTextField("9999999");
        sodiumField1 = new JTextField("9999999");
        priceField1 = new JTextField("9999999");



        SearchButton = new JButton("SEARCH");
        exitButton = new JButton("EXIT");

        message = new JTextField();
        titleField1.setEditable(false);
        this.setSize(600,350);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add product");
        this.setBackground(Color.white);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        this.setContentPane(panel1);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel2.setLayout(new GridLayout(7,3));

        panel2.add(titleLabel);
        panel2.add(titleField);
        panel2.add(titleField1);

        panel2.add(ratingLabel);
        panel2.add(ratingField);
        panel2.add(ratingField1);

        panel2.add(caloriesLabel);
        panel2.add(caloriesField);
        panel2.add(caloriesField1);

        panel2.add(proteinsLabel);
        panel2.add(proteinsField);
        panel2.add(proteinsField1);

        panel2.add(fatsLabel);
        panel2.add(fatsField);
        panel2.add(fatsField1);

        panel2.add(sodiumLabel);
        panel2.add(sodiumField);
        panel2.add(sodiumField1);

        panel2.add(priceLabel);
        panel2.add(priceField);
        panel2.add(priceField1);

        panel3.add(SearchButton);
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

    public JButton getSearchButton() {
        return SearchButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }


    public JTextField getRatingField1() {
        return ratingField1;
    }

    public JTextField getCaloriesField1() {
        return caloriesField1;
    }

    public JTextField getProteinsField1() {
        return proteinsField1;
    }

    public JTextField getFatsField1() {
        return fatsField1;
    }

    public JTextField getSodiumField1() {
        return sodiumField1;
    }

    public JTextField getPriceField1() {
        return priceField1;
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
