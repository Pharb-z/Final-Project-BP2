package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.*;
import model.*;
import node.*;

public class AdminProcessPanel extends JPanel {

    private AppData data;

    public AdminProcessPanel(AppData data) {

        this.data = data;

        setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(
                BorderFactory.createTitledBorder("Proses Transaksi"));

        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel(
                "Proses Transaksi Laundry",
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

        DefaultTableModel model =
                new DefaultTableModel(kolom, 0);

        if (data.orderList != null) {

            OrderNode current =
                    data.orderList.getHead();

            while (current != null) {

                if (current.order.getStatus() == 1) {

                    model.addRow(new Object[] {
                            current.order.getId(),
                            current.order.getBuyer(),
                            current.order.getService(),
                            current.order.getPrice(),
                            current.order.getType(),
                            current.order.getQty(),
                            current.order.getSubtotal(),
                            "Menunggu Diproses"
                    });
                }

                current = current.getNext();
            }
        }

        JTable orderTable = new JTable(model);

        orderTable.setRowHeight(30);
        orderTable.setDefaultEditor(Object.class, null);

        orderTable.getTableHeader()
                .setReorderingAllowed(false);

        orderTable.getTableHeader()
                .setResizingAllowed(false);

        JScrollPane scrollPane =
                new JScrollPane(orderTable);

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

        JButton processButton =
                new JButton("Proses Pesanan");

        JButton backButton =
                new JButton("Kembali");

        buttonPanel.add(processButton);
        buttonPanel.add(backButton);

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

            MainAppGUI.showAdminMenu();

        });

        // ===== PROSES PESANAN =====

        processButton.addActionListener(e -> {

            int selectedRow =
                    orderTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Pilih pesanan terlebih dahulu!");

                return;
            }

            String orderId =
                    model.getValueAt(
                            selectedRow,
                            0).toString();

            OrderNode current =
                    data.orderList.getHead();

            while (current != null) {

                if (current.order.getId()
                        .equals(orderId)) {

                    current.order.setStatus(2);

                    break;
                }

                current = current.getNext();
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Pesanan berhasil diproses!");

            MainAppGUI.showAdminProcess();
        });
    }
}