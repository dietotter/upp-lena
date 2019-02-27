package gui;

import com.company.DemoLogic;
import model.Patient;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;

public class PatientsForm implements View {

    private JPanel mainPanel;
    private JList list;
    private JButton seePurchasesButton;
    private JButton returnButton;
    private JTextPane infoPane;
    private JButton deleteButton;
    private JButton addButton;

    public PatientsForm(MainFrame mainFrame) {

        // set up list with demo data
        setUpList(mainFrame.getDemoLogic());

        returnButton.addActionListener((ActionEvent e) -> {
            mainFrame.changeView(this, new MainMenu(mainFrame));
        });

        seePurchasesButton.addActionListener((ActionEvent e) -> {
            mainFrame.changeView(this, new PurchasesForm(mainFrame, ((Patient) list.getSelectedValue()).getPurchases()));
        });

        addButton.addActionListener((ActionEvent e) -> {
            new AddPatientDialog(mainFrame, this).setVisible(true);
        });

        deleteButton.addActionListener((ActionEvent e) -> {
            new DeletePatientDialog().setVisible(true);
        });
    }

    private void setUpList(DemoLogic demoLogic) {
        list.setListData(demoLogic.getPatientsArr());
        list.setSelectedIndex(0);

        infoPane.setText(((Patient) list.getSelectedValue()).detailedToString());

        list.addListSelectionListener((ListSelectionEvent e) -> {

            infoPane.setText(((Patient) list.getSelectedValue()).detailedToString());
        });
    }

    public JPanel getView() {
        return mainPanel;
    }

    public String getTitle() {
        return "Пацієнти";
    }

}
