package prm2t.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JFrame{
    private String text = "";
    private JTextField textField;

    public MainPanel(){
        super("Testowanie danych liczbowych");
        setLocation(1300,150);
        setSize(new Dimension(300,100));
        setLayout(new FlowLayout());

        InputPanel inputPanel = new InputPanel();
        inputPanel.setVisible(false);
        inputPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                text = inputPanel.getInput();
                textField.setText(text);
            }
        });


        JButton inputButton = new JButton("Wpisz:");
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputPanel.setVisible(true);
            }
        });
        add(inputButton);

        textField = new JTextField(10);
        textField.setEditable(false);
        add(textField);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }



}
