package gui;

import java.awt.*;
import javax.swing.*;
import main.*;
import model.*;

public class CustomerLoginPanel extends JPanel {

    private AppData data;

    public CustomerLoginPanel(AppData data) {
        this.data = data;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        setLayout(new BorderLayout());

        // PANEL UTAMA (CARD)
        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(BorderFactory.createTitledBorder("Customer Login Page"));

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel("Customer Login", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        card.add(title, gbc);

        // ===== Name =====
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        card.add(new JLabel("Nama: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField nameField = new JTextField(15);
        card.add(nameField, gbc);

        // ===== Phone =====
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        card.add(new JLabel("No HP: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField phoneField = new JTextField(15);
        card.add(phoneField, gbc);

        // ===== Address =====
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        card.add(new JLabel("Alamat: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField addressField = new JTextField(15);
        card.add(addressField, gbc);

        // ===== Button Login =====
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton backButton = new JButton("Kembali");
        JButton loginButton = new JButton("Lanjutkan");
        buttonPanel.add(backButton);
        buttonPanel.add(loginButton);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        card.add(buttonPanel, gbc);
        add(card);

        // Action Listeners
        loginButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String address = addressField.getText().trim();
            String id = "CUST" + name; // Generate unique ID based on timestamp
            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Mohon isi semua data", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            data.customer = new Customer(id, name, phone, address);
            data.currentCustomer = data.customer;
            MainAppGUI.showCustomerMenu();
        });

        backButton.addActionListener(e -> {
            MainAppGUI.showLandingPage();
        });
    }
}
