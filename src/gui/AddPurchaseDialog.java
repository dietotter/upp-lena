package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddPurchaseDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField dateField;
    private JTextField recipeNumField;
    private JButton addDrugButton;
    private JTextField drugNameField1;
    private JTextField drugQuantityField1;
    private JPanel drugPanel;

    private JTextField drugNameField2;
    private JTextField drugNameField3;
    private JTextField drugNameField4;
    private JTextField drugNameField5;
    private JTextField drugQuantityField2;
    private JTextField drugQuantityField3;
    private JTextField drugQuantityField4;
    private JTextField drugQuantityField5;

    private JTextField passportField;
    private JTextField drugstoreField;
    private JTextField statusField;

    private int visibleDrugFieldCounter = 1;

    public AddPurchaseDialog() {
        setUpDrugFields();

        setTitle("Додати покупку");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(null);
        setMinimumSize(getPreferredSize());

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // add another field for drug
        addDrugButton.addActionListener((ActionEvent e) -> {
            addDrugRow();
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void addDrugRow() {

        invalidate();

        switch (visibleDrugFieldCounter) {
            case 1:
                drugNameField2.setVisible(true);
                drugQuantityField2.setVisible(true);
                break;
            case 2:
                drugNameField3.setVisible(true);
                drugQuantityField3.setVisible(true);
                break;
            case 3:
                drugNameField4.setVisible(true);
                drugQuantityField4.setVisible(true);
                break;
            case 4:
                drugNameField5.setVisible(true);
                drugQuantityField5.setVisible(true);
        }

        visibleDrugFieldCounter++;

        validate();

        repaint();
    }

    private void setUpDrugFields() {

        drugNameField2.setVisible(false);
        drugQuantityField2.setVisible(false);

        drugNameField3.setVisible(false);
        drugQuantityField3.setVisible(false);

        drugNameField4.setVisible(false);
        drugQuantityField4.setVisible(false);

        drugNameField5.setVisible(false);
        drugQuantityField5.setVisible(false);
    }

}
