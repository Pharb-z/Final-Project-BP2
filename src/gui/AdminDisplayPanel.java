package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.*;
import model.*;
import node.*;

public class AdminDisplayPanel extends JPanel {

    private AppData data;

    public AdminDisplayPanel(AppData data) {

        this.data = data;

        setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JPanel card = new JPanel(new GridBagLayout());

        card.setBorder(
                BorderFactory.createTitledBorder("Admin Display"));

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel(
                "Daftar Pesanan Masuk",
                JLabel.CENTER);

        title.setFont(
                new Font("Arial",
                        Font.BOLD,
                        18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        card.add(title, gbc);

        // ===== TABLE =====
        String[] kolom = {
            "ID Order",
            "Customer",
            "Layanan",
            "Harga",
            "Tipe",
            "Qty",
            "Subtotal",
            "Status"
        };

        DefaultTableModel model = new DefaultTableModel(kolom, 0);

        if (data.orderList != null) {

            OrderNode current = data.orderList.getHead();

            while (current != null) {

                if (current.order.getStatus() >= 1) {

                    String statusText = "";

                    switch (current.order.getStatus()) {
                        case 0:
                            statusText = "Menunggu Konfirmasi Customer";
                            break;
                        case 1:
                            statusText = "Menunggu Diproses Admin";
                            break;
                        case 2:
                            statusText = "Selesai";
                            break;
                    }

                    model.addRow(new Object[]{
                        current.order.getId(),
                        current.order.getBuyer(),
                        current.order.getService(),
                        current.order.getPrice(),
                        current.order.getType(),
                        current.order.getQty(),
                        current.order.getSubtotal(),
                        statusText
                    });
                }

                current = current.getNext();
            }
        }

        JTable orderTable = new JTable(model);

        orderTable.setRowHeight(30);

        orderTable.setDefaultEditor(
                Object.class,
                null);

        orderTable.getTableHeader()
                .setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(orderTable);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        card.add(scrollPane, gbc);

        // ===== BUTTON =====
        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        20,
                        0));

        JButton backButton = new JButton("Kembali");
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;

        card.add(buttonPanel, gbc);

        add(card, BorderLayout.CENTER);

        // ===== KEMBALI =====
        backButton.addActionListener(e -> {

            MainAppGUI.showAdminMenu();

        });
    }
}
