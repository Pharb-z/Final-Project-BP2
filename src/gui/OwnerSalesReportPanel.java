package gui;

import java.awt.*;
import javax.swing.*;

import main.*;
import model.*;

public class OwnerSalesReportPanel extends JPanel {

        private AppData data;

        private String buatGrafik(double nilai) {

                int jumlahX = (int) (nilai / 10000);

                String grafik = "";

                for (int i = 0; i < jumlahX; i++) {
                        grafik += "X";
                }

                return grafik;
        }

        public OwnerSalesReportPanel(AppData data) {

                this.data = data;

                setLayout(new BorderLayout());

                JPanel card = new JPanel();
                card.setLayout(
                                new BoxLayout(
                                                card,
                                                BoxLayout.Y_AXIS));

                JLabel title = new JLabel(
                                "Laporan Penjualan Harian",
                                JLabel.CENTER);

                title.setFont(
                                new Font(
                                                "Arial",
                                                Font.BOLD,
                                                20));

                title.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                card.add(Box.createVerticalStrut(20));
                card.add(title);
                card.add(Box.createVerticalStrut(20));

                JLabel totalLabel = new JLabel(
                                "Total Pendapatan : Rp "
                                                + String.format("%,.0f", data.totalPendapatan));

                JLabel cbLabel = new JLabel(
                                "Cuci Basah : "
                                                + buatGrafik(data.totalCuciBasahKiloan)
                                                + " Rp "
                                                + String.format("%,.0f",
                                                                data.totalCuciBasahKiloan));

                JLabel ckKiloanLabel = new JLabel(
                                "Cuci Kering (Kiloan) : "
                                                + buatGrafik(data.totalCuciKeringKiloan)
                                                + " Rp "
                                                + String.format("%,.0f",
                                                                data.totalCuciKeringKiloan));

                JLabel ckSatuanLabel = new JLabel(
                                "Cuci Kering (Satuan) : "
                                                + buatGrafik(data.totalCuciKeringSatuan)
                                                + " Rp "
                                                + String.format("%,.0f",
                                                                data.totalCuciKeringSatuan));

                JLabel cksKiloanLabel = new JLabel(
                                "Cuci Kering + Setrika (Kiloan) : "
                                                + buatGrafik(data.totalCuciKeringSetrikaKiloan)
                                                + " Rp "
                                                + String.format("%,.0f",
                                                                data.totalCuciKeringSetrikaKiloan));

                JLabel cksSatuanLabel = new JLabel(
                                "Cuci Kering + Setrika (Satuan) : "
                                                + buatGrafik(data.totalCuciKeringSetrikaSatuan)
                                                + " Rp "
                                                + String.format("%,.0f",
                                                                data.totalCuciKeringSetrikaSatuan));

                JLabel setrikaKiloanLabel = new JLabel(
                                "Setrika (Kiloan) : "
                                                + buatGrafik(data.totalSetrikaKiloan)
                                                + " Rp "
                                                + String.format("%,.0f",
                                                                data.totalSetrikaKiloan));

                JLabel setrikaSatuanLabel = new JLabel(
                                "Setrika (Satuan) : "
                                                + buatGrafik(data.totalSetrikaSatuan)
                                                + " Rp "
                                                + String.format("%,.0f",
                                                                data.totalSetrikaSatuan));
                // agar tengah
                totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                cbLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                ckKiloanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                ckSatuanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                cksKiloanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                cksSatuanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                setrikaKiloanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                setrikaSatuanLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                // ===== TAMBAHKAN KE PANEL =====

                card.add(totalLabel);

                card.add(Box.createVerticalStrut(10));

                card.add(cbLabel);
                card.add(Box.createVerticalStrut(5));

                card.add(ckKiloanLabel);
                card.add(Box.createVerticalStrut(5));

                card.add(ckSatuanLabel);
                card.add(Box.createVerticalStrut(5));

                card.add(cksKiloanLabel);
                card.add(Box.createVerticalStrut(5));

                card.add(cksSatuanLabel);
                card.add(Box.createVerticalStrut(5));

                card.add(setrikaKiloanLabel);
                card.add(Box.createVerticalStrut(5));

                card.add(setrikaSatuanLabel);

                card.add(Box.createVerticalStrut(30));
                JButton backButton = new JButton("Kembali");

                backButton.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                card.add(backButton);

                JPanel wrapper = new JPanel(new GridBagLayout());
                wrapper.add(card);

                add(wrapper, BorderLayout.CENTER);

                backButton.addActionListener(e -> {

                        MainAppGUI.showOwnerMenu();

                });
        }
}