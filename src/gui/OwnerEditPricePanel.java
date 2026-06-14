package gui;

import java.awt.*;
import javax.swing.*;

import main.*;
import model.*;
import node.*;

public class OwnerEditPricePanel extends JPanel {

    private AppData data;

    public OwnerEditPricePanel(AppData data) {

        this.data = data;

        setLayout(new BorderLayout());

        JPanel card = new JPanel(new GridBagLayout());

        card.setBorder(
                BorderFactory.createTitledBorder(
                        "Ubah Harga Layanan"));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);

        // ===== TITLE =====

        JLabel title = new JLabel(
                "Ubah Harga Layanan",
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

        // ===== COMBOBOX =====

        JLabel serviceLabel = new JLabel("Pilih Layanan :");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;

        card.add(serviceLabel, gbc);

        JComboBox<String> serviceCombo = new JComboBox<>();

        ServiceNode current = data.serviceKiloan.getHead();

        while (current != null) {

            serviceCombo.addItem(
                    current.idService
                            + " - "
                            + current.nameService);

            current = current.getNext();
        }

        current = data.serviceSatuan.getHead();

        while (current != null) {

            serviceCombo.addItem(
                    current.idService
                            + " - "
                            + current.nameService);

            current = current.getNext();
        }

        gbc.gridx = 1;

        card.add(serviceCombo, gbc);

        // ===== HARGA BARU =====

        JLabel priceLabel = new JLabel("Harga Baru :");

        gbc.gridx = 0;
        gbc.gridy = 2;

        card.add(priceLabel, gbc);

        JTextField priceField = new JTextField(15);

        gbc.gridx = 1;

        card.add(priceField, gbc);

        // ===== BUTTON =====

        JPanel buttonPanel = new JPanel(
                new FlowLayout());

        JButton saveButton = new JButton("Simpan");

        JButton backButton = new JButton("Kembali");

        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        card.add(buttonPanel, gbc);

        add(card, BorderLayout.CENTER);

        // =======================
        // SIMPAN
        // =======================

        saveButton.addActionListener(e -> {

            try {

                double newPrice = Double.parseDouble(
                        priceField.getText());

                String selected = (String) serviceCombo.getSelectedItem();

                String serviceId = selected.split(" - ")[0];

                ServiceNode service = data.serviceKiloan
                        .searchService(
                                serviceId);

                if (service == null) {

                    service = data.serviceSatuan
                            .searchService(
                                    serviceId);
                }

                if (service != null) {

                    service.price = newPrice;

                    JOptionPane.showMessageDialog(
                            this,
                            "Harga berhasil diubah!");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Masukkan harga yang valid!");
            }
        });

        // =======================
        // KEMBALI
        // =======================

        backButton.addActionListener(e -> {

            MainAppGUI.showOwnerMenu();

        });
    }
}