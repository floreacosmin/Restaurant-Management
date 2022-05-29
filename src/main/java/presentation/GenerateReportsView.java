package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GenerateReportsView extends JFrame {

    private JPanel contentPane;
    private JTextField startField;
    private JTextField endField;
    private JTextField nField;
    private JTextField xField;
    private JTextField yField;
    private JTextField dayField;
    private JButton ordersReportButton;
    private JButton productsOrderedButton;
    private JButton clientsReportButton;
    private JButton productsDayButton;


    /**
     * Create the frame.
     */
    public GenerateReportsView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100,500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Generate report");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(110, 11, 200, 30);
        contentPane.add(lblNewLabel);

        ordersReportButton = new JButton("Generate");
        ordersReportButton.setBounds(30, 101, 200, 30);
        contentPane.add(ordersReportButton);

        productsOrderedButton = new JButton("Generate");
        productsOrderedButton.setBounds(30, 180, 200, 30);
        contentPane.add(productsOrderedButton);

        clientsReportButton = new JButton("Generate");
        clientsReportButton.setBounds(30, 260, 200, 30);
        contentPane.add(clientsReportButton);

        productsDayButton = new JButton("Generate");
        productsDayButton.setBounds(30, 340, 200, 30);
        contentPane.add(productsDayButton);

        JLabel lblGenerateOrdersIn = new JLabel("Generate orders in time interval report");
        lblGenerateOrdersIn.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblGenerateOrdersIn.setBounds(30, 50, 270, 20);
        contentPane.add(lblGenerateOrdersIn);

        JLabel lblStartTime = new JLabel("Start time:");
        lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblStartTime.setBounds(30, 70, 70, 20);
        contentPane.add(lblStartTime);

        startField = new JTextField();
        startField.setBounds(100, 70, 100, 20);
        contentPane.add(startField);
        startField.setColumns(10);

        JLabel lblEndTime = new JLabel("End time:");
        lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEndTime.setBounds(212, 70, 70, 20);
        contentPane.add(lblEndTime);

        endField = new JTextField();
        endField.setColumns(10);
        endField.setBounds(290, 70, 100, 20);
        contentPane.add(endField);

        JLabel lblGenerateProductsOrdered = new JLabel("Generate products ordered more then n times report");
        lblGenerateProductsOrdered.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblGenerateProductsOrdered.setBounds(30, 140, 360, 20);
        contentPane.add(lblGenerateProductsOrdered);

        JLabel lblN = new JLabel("n:");
        lblN.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblN.setBounds(30, 158, 25, 20);
        contentPane.add(lblN);

        nField = new JTextField();
        nField.setColumns(10);
        nField.setBounds(51, 159, 100, 20);
        contentPane.add(nField);

        JLabel lblGenerateClientsThat = new JLabel("Generate clients that have ordered more than x times of value > y");
        lblGenerateClientsThat.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblGenerateClientsThat.setBounds(30, 221, 429, 20);
        contentPane.add(lblGenerateClientsThat);

        JLabel lblX = new JLabel("x:");
        lblX.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblX.setBounds(30, 238, 25, 20);
        contentPane.add(lblX);

        xField = new JTextField();
        xField.setColumns(10);
        xField.setBounds(51, 239, 100, 20);
        contentPane.add(xField);

        yField = new JTextField();
        yField.setColumns(10);
        yField.setBounds(290, 239, 100, 20);
        contentPane.add(yField);

        JLabel lblY = new JLabel("y:");
        lblY.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblY.setBounds(255, 238, 25, 20);
        contentPane.add(lblY);

        JLabel lblGenerateReportOf = new JLabel("Generate report of products ordered in a day");
        lblGenerateReportOf.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblGenerateReportOf.setBounds(30, 301, 360, 20);
        contentPane.add(lblGenerateReportOf);

        JLabel lblDay = new JLabel("Day:");
        lblDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDay.setBounds(30, 318, 70, 20);
        contentPane.add(lblDay);

        dayField = new JTextField();
        dayField.setColumns(10);
        dayField.setBounds(100, 319, 100, 20);
        contentPane.add(dayField);
    }

    public JTextField getStartField() {
        return startField;
    }

    public JTextField getEndField() {
        return endField;
    }

    public JTextField getnField() {
        return nField;
    }

    public JTextField getxField() {
        return xField;
    }

    public JTextField getyField() {
        return yField;
    }

    public JTextField getDayField() {
        return dayField;
    }

    public JButton getOrdersReportButton() {
        return ordersReportButton;
    }

    public JButton getProductsOrderedButton() {
        return productsOrderedButton;
    }

    public JButton getClientsReportButton() {
        return clientsReportButton;
    }

    public JButton getProductsDayButton() {
        return productsDayButton;
    }
}
