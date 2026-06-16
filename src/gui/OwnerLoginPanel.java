package gui;

import java.awt.*;
import javax.swing.*;
import main.*;
import model.*;

public class OwnerLoginPanel extends JPanel {

    private AppData data;

    public OwnerLoginPanel(AppData data) {

        this.data = data;

        setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // PANEL UTAMA
        JPanel card = new JPanel(new GridBagLayout());

        card.setBorder(
                BorderFactory.createTitledBorder("Owner Login Page"));

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel(
                "Owner Login",
                JLabel.CENTER);

        title.setFont(
                new Font("Arial",
                        Font.BOLD,
                        18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        card.add(title, gbc);

        // ===== NAMA =====
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;

        card.add(
                new JLabel("Nama : "),
                gbc);

        JTextField nameField
                = new JTextField(15);

        gbc.gridx = 1;

        card.add(
                nameField,
                gbc);

        // ===== PASSWORD =====
        gbc.gridx = 0;
        gbc.gridy = 2;

        card.add(
                new JLabel("Password : "),
                gbc);

        JPasswordField passwordField
                = new JPasswordField(15);

        gbc.gridx = 1;

        card.add(
                passwordField,
                gbc);

        // ===== BUTTON =====
        JPanel buttonPanel
                = new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                10,
                                0));

        JButton loginButton
                = new JButton("Login");

        JButton backButton
                = new JButton("Kembali");

        buttonPanel.add(loginButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        card.add(buttonPanel, gbc);

        add(card, BorderLayout.CENTER);

        // ===== LOGIN =====
        loginButton.addActionListener(e -> {

            String name
                    = nameField.getText().trim();

            String password
                    = new String(
                            passwordField.getPassword());

            if (name.equalsIgnoreCase(data.owner.name)
                    && password.equals(data.owner.password)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login berhasil!");

                MainAppGUI.showOwnerMenu();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Nama atau Password salah!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // ===== KEMBALI =====
        backButton.addActionListener(e -> {

            MainAppGUI.showLandingPage();

        });
    }
}
