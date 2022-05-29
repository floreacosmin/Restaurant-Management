package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class AdministratorView extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton ProductButton;
    private JButton ModifyButton;
    private JButton DeleteButton;
    private JButton ViewAllButton;
    private JButton GenerateReportsButton;
    private JButton CreateProductButton;
    private JButton importCSVButton;
    private JScrollPane scrollPane;
    private JTextField MenNameField;
    private JButton backButton;
    /**
     * Create the frame.
     */
    public AdministratorView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        this.setTitle("Admin View");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ProductButton = new JButton("Add product");
        ProductButton.setBounds(30, 50, 120, 30);
        contentPane.add(ProductButton);

        DeleteButton = new JButton("Delete Product");
        DeleteButton.setBounds(30, 100, 120, 30);
        contentPane.add(DeleteButton);

        ModifyButton = new JButton("Modify Product");
        ModifyButton.setBounds(30, 150, 120, 30);
        contentPane.add(ModifyButton);

        ViewAllButton = new JButton("View All");
        ViewAllButton.setBounds(30, 250, 120, 30);
        contentPane.add(ViewAllButton);

        GenerateReportsButton = new JButton("Generate Reports");
        GenerateReportsButton.setBounds(30, 300, 120, 30);
        contentPane.add(GenerateReportsButton);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(170, 50, 370, 300);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        CreateProductButton = new JButton("Create Product");
        CreateProductButton.setBounds(30, 200, 120, 30);
        contentPane.add(CreateProductButton);

        importCSVButton = new JButton("Import CSV");
        importCSVButton.setBounds(30, 350, 120, 30);
        contentPane.add(importCSVButton);

        JLabel MenLabel = new JLabel("New menu name:");
        MenLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        MenLabel.setBounds(30, 400, 120, 30);
        contentPane.add(MenLabel);

        MenNameField = new JTextField();
        MenNameField.setBounds(180, 400, 200, 30);
        contentPane.add(MenNameField);
        MenNameField.setColumns(10);

        backButton = new JButton("Back");
        backButton.setBounds(30, 475, 100, 25);
        contentPane.add(backButton);
    }

    public void setTable(DefaultTableModel tModel) {
        table = new JTable(tModel);
        scrollPane.setViewportView(table);
    }

    public JTable getTable() {
        return table;
    }

    public JButton getProductButton() {
        return ProductButton;
    }

    public JButton getModifyButton() {
        return ModifyButton;
    }

    public JButton getDeleteButton() {
        return DeleteButton;
    }

    public JButton getViewAllButton() {
        return ViewAllButton;
    }

    public JButton getGenerateReportsButton() {
        return GenerateReportsButton;
    }

    public JButton getCreateProductButton() {
        return CreateProductButton;
    }

    public JButton getImportCSVButton() {
        return importCSVButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JTextField getMenNameField() {
        return MenNameField;
    }


}

