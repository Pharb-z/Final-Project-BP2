package gui;

import java.awt.*;
import javax.swing.*;

import main.*;
import model.*;
import node.*;

public class OwnerMenuPanel extends JPanel {

    private AppData data;

    private JLabel processedLabel;
    private JLabel unprocessedLabel;

    public OwnerMenuPanel(AppData data) {

        this.data = data;

        setLayout(new BorderLayout());

        JPanel card = new JPanel(new GridBagLayout());

        card.setBorder(
                BorderFactory.createTitledBorder("Owner Menu"));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====

        JLabel title = new JLabel(
                "Laporan Penjualan",
                JLabel.CENTER);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        card.add(title, gbc);

        // ===== TOTAL SUDAH DIPROSES =====

        processedLabel = new JLabel();

        gbc.gridy = 1;

        card.add(processedLabel, gbc);

        // ===== TOTAL BELUM DIPROSES =====

        unprocessedLabel = new JLabel();

        gbc.gridy = 2;

        card.add(unprocessedLabel, gbc);

        // ===== BUTTON =====

        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        10,
                        0));

        JButton laporanButton = new JButton("Lihat Laporan");
        JButton editPriceButton = new JButton("Ubah Harga Layanan");
        JButton backButton = new JButton("Logout");

        buttonPanel.add(laporanButton);
        buttonPanel.add(editPriceButton);
        buttonPanel.add(backButton);

        gbc.gridy = 3;

        card.add(buttonPanel, gbc);

        add(card, BorderLayout.CENTER);

        // tampilkan data pertama kali
        updateReport();

        // laporan
        laporanButton.addActionListener(e -> {

            MainAppGUI.showOwnerDisplay();

        });

        // ubah harga
        editPriceButton.addActionListener(e -> {
            MainAppGUI.showOwnerEditPrice();

        });

        // logout
        backButton.addActionListener(e -> {

            MainAppGUI.showLandingPage();

        });
    }

    private void updateReport() {

        double totalProcessed = 0;
        double totalUnprocessed = 0;

        OrderNode current = data.orderList.getHead();

        while (current != null) {

            double subtotal = current.order.getSubtotal();

            // status 2 = selesai
            if (current.order.getStatus() == 2) {

                totalProcessed += subtotal;

            } else {

                totalUnprocessed += subtotal;

            }

            current = current.getNext();
        }

        processedLabel.setText(
                "Total Nilai Order Sudah Diproses : Rp "
                        + totalProcessed);

        unprocessedLabel.setText(
                "Total Nilai Order Belum Diproses : Rp "
                        + totalUnprocessed);
    }
}