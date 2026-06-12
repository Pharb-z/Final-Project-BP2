package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.MainAppGUI;
import model.*;
import node.OrderNode;

public class MemberDisplayPanel extends JPanel {

    private AppData data;

    public MemberDisplayPanel(AppData data) {

        this.data = data;

        setLayout(new BorderLayout());

        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(
                BorderFactory.createTitledBorder("Member Menu"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // ===== TITLE =====

        JLabel title = new JLabel(
                "Pesanan Member",
                JLabel.CENTER);

        title.setFont(
                new Font("Arial",
                        Font.BOLD,
                        18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        card.add(title, gbc);

        // ===== TABEL =====

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

        if (data.orderList != null
                && data.currentMember != null) {

            OrderNode current = data.orderList.getHead();

            while (current != null) {

                if (current.order.getStatus() == 0
                        && current.order.getBuyer()
                                .equalsIgnoreCase(
                                        data.currentMember.name)) {

                    model.addRow(new Object[] {
                            current.order.getId(),
                            current.order.getBuyer(),
                            current.order.getService(),
                            current.order.getPrice(),
                            current.order.getType(),
                            current.order.getQty(),
                            current.order.getSubtotal(),
                            "Menunggu"
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

        JButton confirmButton = new JButton("Konfirmasi Pesanan");

        buttonPanel.add(backButton);
        buttonPanel.add(confirmButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;

        card.add(buttonPanel, gbc);

        add(card, BorderLayout.CENTER);

        // ===== BUTTON KEMBALI =====

        backButton.addActionListener(e -> {

            MainAppGUI.showMemberMenu();

        });

        // ===== KONFIRMASI PESANAN =====

        confirmButton.addActionListener(e -> {

            OrderNode current = data.orderList.getHead();

            boolean adaPesanan = false;

            while (current != null) {

                if (current.order.getStatus() == 0
                        && current.order.getBuyer()
                                .equalsIgnoreCase(
                                        data.currentMember.name)) {

                    current.order.setStatus(1);

                    adaPesanan = true;
                }

                current = current.getNext();
            }

            if (adaPesanan) {

                JOptionPane.showMessageDialog(
                        this,
                        "Pesanan berhasil dikonfirmasi!");

                MainAppGUI.showMemberDisplay();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Tidak ada pesanan yang dapat dikonfirmasi.");
            }
        });
    }
}