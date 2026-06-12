package gui;

import java.awt.*;
import javax.swing.*;
import main.*;
import model.*;
import node.MemberNode;

public class MemberLoginPanel extends JPanel {

    private AppData data;

    public MemberLoginPanel(AppData data) {
        this.data = data;

        setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(
                BorderFactory.createTitledBorder("Member Login Page"));

        // ===== TITLE =====
        JLabel title = new JLabel("Member Login", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        card.add(title, gbc);

        // ===== Nama =====
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        card.add(new JLabel("Nama: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField nameField = new JTextField(15);
        card.add(nameField, gbc);

        // ===== Password =====
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        card.add(new JLabel("Password: "), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JPasswordField passwordField = new JPasswordField(15);

        card.add(passwordField, gbc);

        // ===== Button =====
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
        gbc.anchor = GridBagConstraints.CENTER;

        card.add(buttonPanel, gbc);

        add(card, BorderLayout.CENTER);

        // ===== LOGIN =====
        loginButton.addActionListener(e -> {

            String name = nameField.getText().trim();

            String password = new String(passwordField.getPassword());

            if (name.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Mohon isi semua data",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            MemberNode member = data.memberList.verifLogin(name, password);

            if (member != null) {

                data.currentMember = member;

                JOptionPane.showMessageDialog(
                        this,
                        "Login berhasil!");

                MainAppGUI.showMemberMenu();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Nama atau Password salah!",
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