package gui;

import java.awt.*;
import javax.swing.*;
import main.MainAppGUI;
import model.*;

public class AdminLoginPanel extends JPanel {

    private AppData data;

    public AdminLoginPanel(AppData data) {

        this.data = data;

        setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // PANEL UTAMA
        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(
                BorderFactory.createTitledBorder("Admin Login Page"));

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel("Admin Login", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        card.add(title, gbc);

        // ===== NAMA =====
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.anchor = GridBagConstraints.EAST;

        card.add(new JLabel("Nama : "), gbc);

        JTextField nameField = new JTextField(15);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;

        card.add(nameField, gbc);

        // ===== PASSWORD =====
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.anchor = GridBagConstraints.EAST;

        card.add(new JLabel("Password : "), gbc);

        JPasswordField passwordField = new JPasswordField(15);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;

        card.add(passwordField, gbc);

        // ===== BUTTON =====
        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        0));

        JButton backButton = new JButton("Kembali");
        JButton loginButton = new JButton("Login");

        buttonPanel.add(backButton);
        buttonPanel.add(loginButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        card.add(buttonPanel, gbc);

        add(card, BorderLayout.CENTER);

        // ===== LOGIN =====
        loginButton.addActionListener(e -> {

            String name = nameField.getText().trim();

            String password = new String(
                    passwordField.getPassword());

            if (name.isEmpty()
                    || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Mohon isi semua data!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            if (name.equalsIgnoreCase(data.admin.name)
                    && password.equals(data.admin.password)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Admin Berhasil!");

                MainAppGUI.showAdminMenu();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Nama atau Password Salah!",
                        "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // ===== KEMBALI =====
        backButton.addActionListener(e -> {

            MainAppGUI.showLandingPage();

        });
    }
}
