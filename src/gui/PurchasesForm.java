package gui;

import com.company.DemoLogic;
import model.Doctor;
import model.DrugInRecipe;
import model.Purchase;
import model.Recipe;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class PurchasesForm implements View {

    private JList list;
    private JButton returnButton;
    private JPanel mainPanel;
    private JTextPane infoPane;
    private JButton addButton;

    public PurchasesForm(MainFrame mainFrame, List<Purchase> purchases) {

        // set up list with demo data
        setUpList(purchases);

        returnButton.addActionListener((ActionEvent e) -> {
            mainFrame.changeView(this, new MainMenu(mainFrame));
        });

        addButton.addActionListener((ActionEvent e) -> {
            new AddPurchaseDialog().setVisible(true);
        });
    }

    private void setUpList(List<Purchase> purchases) {
        list.setListData(purchases.toArray());
        list.setSelectedIndex(0);

        infoPane.setText(((Purchase) list.getSelectedValue()).detailedToString());

        list.addListSelectionListener((ListSelectionEvent e) -> {
            String info = ((Purchase) list.getSelectedValue()).detailedToString();

            infoPane.setText(info);
        });
    }

    public JPanel getView() {
        return mainPanel;
    }

    public String getTitle() {
        return "Покупки";
    }

}
