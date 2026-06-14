package gui;

import java.awt.*;
import javax.swing.*;

import linkedlist.OrderLL;
import main.*;
import model.*;

public class CustomerMenuPanel extends JPanel {

    private AppData data;

    public CustomerMenuPanel(AppData data) {
        this.data = data;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        setLayout(new BorderLayout());

        // PANEL UTAMA (CARD)
        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(BorderFactory.createTitledBorder("Menu Pelanggan"));

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel("Menu Pelanggan", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        card.add(title, gbc);

        JLabel welcomeLabel = new JLabel("Welcome, " + data.currentCustomer.name + "!", JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        card.add(welcomeLabel, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton orderButton = new JButton("Buat Pesanan");
        JButton historyButton = new JButton("Lihat Pesanan");
        JButton backButton = new JButton("Kembali");
        buttonPanel.add(orderButton);
        buttonPanel.add(historyButton);
        buttonPanel.add(backButton);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        card.add(buttonPanel, gbc);
        add(card);
        // Action Listeners
        orderButton.addActionListener(e -> {
            MainAppGUI.showCustomerOrder();
        });
        historyButton.addActionListener(e -> {
            MainAppGUI.showCustomerDisplay();
        });
        backButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin kembali ke halaman utama?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                MainAppGUI.showLandingPage();
            }
        });
    }
}
