package gui;

import java.awt.*;
import javax.swing.*;
import main.*;
import model.*;

public class LandingPage extends JPanel {

    public LandingPage(AppData data) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        setLayout(new BorderLayout());

        // PANEL UTAMA (CARD)
        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(BorderFactory.createTitledBorder("Login Page"));

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel("Laundry Bu Yuli", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        card.add(title, gbc);

        JLabel caption = new JLabel("Pilih menu untuk masuk ke halaman yang diinginkan", JLabel.CENTER);
        caption.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        card.add(caption, gbc);

        //Menu
        JPanel btnPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JButton buyerMenuButton = new JButton("Pembeli");
        JButton memberMenuButton = new JButton("Member");
        JButton adminMenuButton = new JButton("Admin");
        JButton ownerMenuButton = new JButton("Owner");

        btnPanel.add(buyerMenuButton);
        btnPanel.add(memberMenuButton);
        btnPanel.add(adminMenuButton);
        btnPanel.add(ownerMenuButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        card.add(btnPanel, gbc);
        add(card);

        buyerMenuButton.addActionListener(e -> {
            MainAppGUI.showCustomerLogin();
        });
        memberMenuButton.addActionListener(e -> {
            MainAppGUI.showMemberLogin();
        });
        adminMenuButton.addActionListener(e -> {
            MainAppGUI.showAdminLogin();
        });
        ownerMenuButton.addActionListener(e -> {
            MainAppGUI.showOwnerLogin();
        });

    }
}
