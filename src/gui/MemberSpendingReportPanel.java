package gui;

import java.awt.*;
import javax.swing.*;

import main.MainAppGUI;
import model.*;
import node.*;

public class MemberSpendingReportPanel extends JPanel {

        private AppData data;

        public MemberSpendingReportPanel(AppData data) {

                this.data = data;

                setLayout(new BorderLayout());

                JPanel card = new JPanel();
                card.setLayout(
                                new BoxLayout(
                                                card,
                                                BoxLayout.Y_AXIS));

                JLabel title = new JLabel(
                                "Laporan Total Belanja Member",
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

                MemberNode current = data.memberList.getHead();

                int nomor = 1;

                while (current != null) {

                        JLabel lbl = new JLabel(

                                        nomor + ". "
                                                        + current.name
                                                        + " : Rp "
                                                        + String.format(
                                                                        "%,.0f",
                                                                        current.totalBelanja)

                        );

                        lbl.setFont(
                                        new Font(
                                                        "Arial",
                                                        Font.PLAIN,
                                                        16));

                        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

                        card.add(lbl);

                        nomor++;

                        current = current.getNext();
                }

                card.add(Box.createVerticalStrut(20));

                JButton backButton = new JButton("Kembali");

                backButton.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                card.add(backButton);

                add(card, BorderLayout.CENTER);

                backButton.addActionListener(e -> {

                        MainAppGUI.showOwnerMenu();

                });
        }
}