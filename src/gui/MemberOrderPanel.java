package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.*;
import model.*;
import node.ServiceNode;

public class MemberOrderPanel extends JPanel {

    private AppData data;

    public MemberOrderPanel(AppData data) {
        this.data = data;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        setLayout(new BorderLayout());

        // PANEL UTAMA (CARD)
        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(BorderFactory.createTitledBorder("Member Menu"));

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====
        JLabel title = new JLabel("Pesan Layanan", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        card.add(title, gbc);

        JTable serviceTable = new JTable();
        String[] kolom = { "ID", "Layanan", "Harga", "Tipe" };
        DefaultTableModel model = new DefaultTableModel(kolom, 0);

        ServiceNode current = data.serviceKiloan.getHead();

        while (current != null) {
            model.addRow(new Object[] {
                    current.idService,
                    current.nameService,
                    current.price,
                    current.serviceType
            });
            current = current.getNext();
        }

        current = data.serviceSatuan.getHead();

        while (current != null) {
            model.addRow(new Object[] {
                    current.idService,
                    current.nameService,
                    current.price,
                    current.serviceType
            });
            current = current.getNext();
        }

        serviceTable.setModel(model);
        serviceTable.setRowHeight(30);
        serviceTable.setDefaultEditor(Object.class, null);
        serviceTable.getTableHeader().setReorderingAllowed(false);
        serviceTable.getTableHeader().setResizingAllowed(false);
        serviceTable.setPreferredScrollableViewportSize(new Dimension(800, 200));
        JScrollPane scrollPane = new JScrollPane(serviceTable);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        card.add(scrollPane, gbc);
        JLabel chooseLabel = new JLabel("Pilih layanan : ");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        card.add(chooseLabel, gbc);
        JComboBox<String> serviceComboBox = new JComboBox<>();
        current = data.serviceKiloan.getHead();
        while (current != null) {
            serviceComboBox.addItem(current.idService + " - " + current.nameService + " (" + current.serviceType + ")");
            current = current.getNext();
        }
        current = data.serviceSatuan.getHead();
        while (current != null) {
            serviceComboBox.addItem(current.idService + " - " + current.nameService + " (" + current.serviceType + ")");
            current = current.getNext();
        }
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        card.add(serviceComboBox, gbc);

        JLabel qtyLabel = new JLabel("Berat (kg) : ");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        card.add(qtyLabel, gbc);
        JTextField qtyField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        card.add(qtyField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton orderButton = new JButton("Pesan");
        JButton backButton = new JButton("Kembali");
        buttonPanel.add(orderButton);
        buttonPanel.add(backButton);
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        card.add(buttonPanel, gbc);

        backButton.addActionListener(e -> {

            MainAppGUI.showMemberMenu();

        });
        orderButton.addActionListener(e -> {
            String selectedService = (String) serviceComboBox.getSelectedItem();
            String[] parts = selectedService.split(" - ");
            String serviceId = parts[0].trim();
            ServiceNode serviceNode = data.serviceKiloan.searchService(serviceId);
            if (serviceNode == null) {
                serviceNode = data.serviceSatuan.searchService(serviceId);
            }
            if (serviceNode != null) {
                String qtyText = qtyField.getText().trim();
                if (!qtyText.isEmpty()) {
                    try {
                        double quantity = Double.parseDouble(qtyText);
                        JOptionPane.showMessageDialog(this,
                                "Anda memesan: " + serviceNode.nameService + " (" + serviceNode.serviceType
                                        + ") dengan jumlah " + quantity,
                                "Pesanan Diterima", JOptionPane.INFORMATION_MESSAGE);
                        // Masukkan orderan ke order list
                        System.out.println("Member Login : " + data.currentMember.id);
                        data.orderList.createOrder(
                                data.currentMember.name,
                                serviceNode.nameService,
                                serviceNode.price,
                                serviceNode.serviceType,
                                (int) quantity);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Masukkan jumlah yang valid!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Masukkan jumlah!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Layanan tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(card, BorderLayout.CENTER);
    }
}
