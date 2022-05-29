package presentation;

import business.DeliveryService;
import business.MenuItem;
import business.Observable;
import business.Orders;
import presentation.Observer;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class EmployeeView extends JFrame implements Observer {

    private JPanel contentPane;
    private JList list;
    private DefaultListModel defListM;
    JScrollPane scrollPane;

    /**
     * Create the frame.
     */
    public EmployeeView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 60, 520, 300);
        contentPane.add(scrollPane);

        list = new JList();
        scrollPane.setViewportView(list);

        JLabel lblNewLabel = new JLabel("Orders");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(255, 10, 70, 35);
        contentPane.add(lblNewLabel);
    }

    @Override
    public void update(Observable o) {
        DeliveryService deliveryService =(DeliveryService) o;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        defListM = new DefaultListModel();

        for(Orders ord : deliveryService.getOrders().keySet()){
                String s = "ORDER ID: " + ord.getOrderID() + "    CLIENT ID: " + ord.getClientID() + "      ORDER DATE: " + dtf.format(ord.getOrderDate());
                defListM.add(defListM.size(),s);
                for(MenuItem menuItem : deliveryService.getOrders().get(ord)){
                    defListM.add(defListM.size(), "       " + menuItem.getTitle() + "\n");
            }
        }

        list.setModel(defListM);
        list.update(list.getGraphics());
        scrollPane.setViewportView(list);
    }
}
