package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.*;
import model.*;
import node.*;

public class OwnerDisplayPanel extends JPanel {

        private AppData data;

        public OwnerDisplayPanel(AppData data) {

                this.data = data;

                setLayout(new BorderLayout());

                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

                // =========================================
                // TITLE
                // =========================================

                JLabel title = new JLabel(
                                "Laporan Penjualan Laundry",
                                JLabel.CENTER);

                title.setFont(
                                new Font("Arial",
                                                Font.BOLD,
                                                20));

                title.setAlignmentX(Component.CENTER_ALIGNMENT);

                mainPanel.add(Box.createVerticalStrut(10));
                mainPanel.add(title);
                mainPanel.add(Box.createVerticalStrut(20));

                // =========================================
                // TABEL BELUM DIPROSES
                // =========================================

                JLabel lblBelum = new JLabel(
                                "Order Belum Diproses");
                lblBelum.setAlignmentX(Component.CENTER_ALIGNMENT);
                lblBelum.setFont(
                                new Font("Arial",
                                                Font.BOLD,
                                                16));

                mainPanel.add(lblBelum);

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

                DefaultTableModel modelBelum = new DefaultTableModel(kolom, 0);

                OrderNode current = data.orderList.getHead();

                while (current != null) {

                        if (current.order.getStatus() == 0
                                        || current.order.getStatus() == 1) {

                                String statusText = "";

                                if (current.order.getStatus() == 0) {
                                        statusText = "Menunggu";
                                } else {
                                        statusText = "Belum Selesai";
                                }

                                modelBelum.addRow(new Object[] {
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

                JTable tableBelum = new JTable(modelBelum);

                tableBelum.setRowHeight(30);
                tableBelum.setDefaultEditor(
                                Object.class,
                                null);

                JScrollPane scrollBelum = new JScrollPane(tableBelum);

                scrollBelum.setPreferredSize(
                                new Dimension(800, 180));

                mainPanel.add(scrollBelum);

                mainPanel.add(Box.createVerticalStrut(20));

                // =========================================
                // TABEL SUDAH DIPROSES
                // =========================================

                JLabel lblSelesai = new JLabel(
                                "Order Sudah Diproses");
                lblSelesai.setAlignmentX(Component.CENTER_ALIGNMENT);
                lblSelesai.setFont(
                                new Font("Arial",
                                                Font.BOLD,
                                                16));

                mainPanel.add(lblSelesai);

                DefaultTableModel modelSelesai = new DefaultTableModel(kolom, 0);

                current = data.orderList.getHead();

                while (current != null) {

                        if (current.order.getStatus() == 2) {

                                modelSelesai.addRow(new Object[] {
                                                current.order.getId(),
                                                current.order.getBuyer(),
                                                current.order.getService(),
                                                current.order.getPrice(),
                                                current.order.getType(),
                                                current.order.getQty(),
                                                current.order.getSubtotal(),
                                                "Selesai"
                                });
                        }

                        current = current.getNext();
                }

                JTable tableSelesai = new JTable(modelSelesai);

                tableSelesai.setRowHeight(30);

                tableSelesai.setDefaultEditor(
                                Object.class,
                                null);

                JScrollPane scrollSelesai = new JScrollPane(tableSelesai);

                scrollSelesai.setPreferredSize(
                                new Dimension(800, 180));

                mainPanel.add(scrollSelesai);

                mainPanel.add(Box.createVerticalStrut(50));

                // =========================================
                // BUTTON
                // =========================================

                JPanel buttonPanel = new JPanel(
                                new FlowLayout(
                                                FlowLayout.CENTER));

                JButton backButton = new JButton("Kembali");

                buttonPanel.add(backButton);

                mainPanel.add(buttonPanel);

                JPanel wrapper = new JPanel(
                                new GridBagLayout());

                wrapper.add(mainPanel);

                add(wrapper, BorderLayout.CENTER);

                // =========================================
                // ACTION
                // =========================================

                backButton.addActionListener(e -> {

                        MainAppGUI.showOwnerMenu();

                });
        }
}