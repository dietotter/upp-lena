package gui;

import com.company.DemoLogic;
import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddPatientDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nameField;
    private JTextField passportField;
    private JTextField birthdayField;

    public AddPatientDialog(MainFrame mainFrame, View currentView) {
        setTitle("Додати пацієнта");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(null);
        setMinimumSize(getPreferredSize());

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(mainFrame, currentView);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
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

    private void onOK(MainFrame mainFrame, View currentView) {
        // add your code here
        Patient patient = new Patient(passportField.getText(), nameField.getText(), birthdayField.getText());

        mainFrame.getDemoLogic().addPatient(patient);
        mainFrame.changeView(currentView, new PatientsForm(mainFrame));

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
