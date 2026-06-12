package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

                String statusText;

                switch (current.order.getStatus()) {
                    case 0:
                        statusText = "Menunggu";
                        break;
                    case 1:
                        statusText = "Diproses";
                        break;
                    case 2:
                        statusText = "Selesai";
                        break;
                    default:
                        statusText = "-";
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
    }
}
