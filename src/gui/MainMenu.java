package gui;

import model.Purchase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu implements View {

    private JPanel mainPanel;
    private JButton patientMenuButton;
    private JButton purchaseMenuButton;

    public MainMenu(MainFrame mainFrame) {

        patientMenuButton.addActionListener((ActionEvent e) -> {
            mainFrame.changeView(this, new PatientsForm(mainFrame));
        });

        purchaseMenuButton.addActionListener((ActionEvent e) -> {
            mainFrame.changeView(this, new PurchasesForm(mainFrame, new ArrayList<Purchase>(Arrays.asList(mainFrame.getDemoLogic().getPurchasesArr()))));
        });
    }

    public JPanel getView() {
        return mainPanel;
    }

    public String getTitle() {
        return "Головне меню";
    }

}
