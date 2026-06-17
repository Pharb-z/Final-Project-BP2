package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.MainAppGUI;
import model.*;
import node.OrderNode;

public class CustomerDisplayPanel extends JPanel {

    private AppData data;

    public CustomerDisplayPanel(AppData data) {
        this.data = data;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        setLayout(new BorderLayout());

        // PANEL UTAMA (CARD)
        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(BorderFactory.createTitledBorder("Customer Menu"));

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel("Pesanan", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        card.add(title, gbc);
        // button kembali dan konfirmasi
        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 20, 0));

        JButton backButton = new JButton("Kembali");
        JButton confirmButton = new JButton("Konfirmasi Pesanan");
        JButton deleteButton = new JButton("Hapus Pesanan");

        buttonPanel.add(backButton);
        buttonPanel.add(confirmButton);
        buttonPanel.add(deleteButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;

        card.add(buttonPanel, gbc);

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

                if (current.order.getStatus() == 0
                        && current.order.getBuyer()
                                .equalsIgnoreCase(data.currentCustomer.id)) {

                    String statusText = "Menunggu";

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
        JTable orderTable = new JTable();

        orderTable.setModel(model);
        orderTable.setRowHeight(30);
        orderTable.setDefaultEditor(Object.class, null);
        orderTable.getTableHeader().setReorderingAllowed(false);
        orderTable.getTableHeader().setResizingAllowed(false);
        orderTable.setModel(model);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        card.add(scrollPane, gbc);

        add(card, BorderLayout.CENTER);

        backButton.addActionListener(e -> {
            MainAppGUI.showCustomerMenu();
        });

        // METHOD KONFIRMASI
        confirmButton.addActionListener(e -> {

            OrderNode current = data.orderList.getHead();
            boolean adaPesanan = false;
            while (current != null) {
                if (current.order.getStatus() == 0 && current.order.getBuyer().equalsIgnoreCase(data.currentCustomer.id)) {
                    current.order.setStatus(1);
                    adaPesanan = true;
                }

                current = current.getNext();
            }

            if (adaPesanan) {

                JOptionPane.showMessageDialog(this, "Semua pesanan berhasil dikonfirmasi!");
                MainAppGUI.showCustomerDisplay();

            } else {

                JOptionPane.showMessageDialog(this, "Tidak ada pesanan yang perlu dikonfirmasi.");
            }
        });
        // fungsi tombol hapus
        deleteButton.addActionListener(e -> {

            int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus semua pesanan Anda yang belum dikonfirmasi?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }

            OrderNode current = data.orderList.getHead();

            while (current != null) {

                if (current.order.getBuyer()
                        .equalsIgnoreCase(data.currentCustomer.id)
                        && current.order.getStatus() == 0) {

                    current.order.setStatus(-1);
                }

                current = current.getNext();
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Pesanan berhasil dihapus!");

            MainAppGUI.showCustomerDisplay();
        });
    }
}
