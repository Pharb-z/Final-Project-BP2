package gui;

import java.awt.*;
import javax.swing.*;

import main.*;
import model.*;

public class AdminMenuPanel extends JPanel {

    private AppData data;

    public AdminMenuPanel(AppData data) {

        this.data = data;

        setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(
                BorderFactory.createTitledBorder("Menu Admin"));

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel(
                "Menu Admin",
                JLabel.CENTER);

        title.setFont(
                new Font("Arial",
                        Font.BOLD,
                        18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        card.add(title, gbc);

        // ===== WELCOME =====
        JLabel welcomeLabel = new JLabel(
                "Welcome, " + data.admin.name + "!",
                JLabel.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;

        card.add(welcomeLabel, gbc);

        // ===== BUTTON =====
        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        0));

        JButton viewOrderButton = new JButton("Lihat Pesanan");

        JButton processButton = new JButton("Proses Transaksi");

        JButton logoutButton = new JButton("Logout");

        buttonPanel.add(viewOrderButton);
        buttonPanel.add(processButton);
        buttonPanel.add(logoutButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;

        card.add(buttonPanel, gbc);

        add(card, BorderLayout.CENTER);

        // ===== ACTION =====

        viewOrderButton.addActionListener(e -> {

            MainAppGUI.showAdminDisplay();
        });

        processButton.addActionListener(e -> {
            MainAppGUI.showAdminProcess();
        });

        logoutButton.addActionListener(e -> {

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Logout dari akun Admin?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                MainAppGUI.showLandingPage();

            }
        });
    }
}