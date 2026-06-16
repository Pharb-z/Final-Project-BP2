package gui;

import java.awt.*;
import javax.swing.*;
import main.*;
import model.*;

public class MemberMenuPanel extends JPanel {

    private AppData data;

    public MemberMenuPanel(AppData data) {

        this.data = data;

        setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // PANEL UTAMA
        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(
                BorderFactory.createTitledBorder("Menu Member"));

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel("Menu Member", JLabel.CENTER);

        title.setFont(
                new Font("Arial", Font.BOLD, 18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        card.add(title, gbc);

        // ===== WELCOME =====
        JLabel welcomeLabel = new JLabel(
                "Welcome, "
                + data.currentMember.name
                + "!",
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

        JButton orderButton = new JButton("Buat Pesanan");

        JButton historyButton = new JButton("Lihat Pesanan");

        JButton changePasswordButton = new JButton("Ganti Password");

        JButton backButton = new JButton("Kembali");

        buttonPanel.add(orderButton);
        buttonPanel.add(historyButton);
        buttonPanel.add(changePasswordButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;

        card.add(buttonPanel, gbc);

        add(card);

        // ===== ACTION =====
        // Buat Pesanan
        orderButton.addActionListener(e -> {

            MainAppGUI.showMemberOrder();

        });

        // Lihat Pesanan
        historyButton.addActionListener(e -> {

            MainAppGUI.showMemberDisplay();

        });

        // Ganti Password
        changePasswordButton.addActionListener(e -> {

            String oldPassword = JOptionPane.showInputDialog(
                    this,
                    "Masukkan Password Lama:");

            if (oldPassword == null) {
                return;
            }

            if (!oldPassword.equals(data.currentMember.password)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Password lama salah!");

                return;
            }

            String newPassword = JOptionPane.showInputDialog(
                    this,
                    "Masukkan Password Baru:");

            if (newPassword == null
                    || newPassword.trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Password baru tidak boleh kosong!");

                return;
            }

            data.currentMember.password = newPassword;

            JOptionPane.showMessageDialog(
                    this,
                    "Password berhasil diubah!");
        });

        // Kembali
        backButton.addActionListener(e -> {

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Apakah Anda yakin ingin kembali ke halaman utama?",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                MainAppGUI.showLandingPage();

            }

        });
    }
}
