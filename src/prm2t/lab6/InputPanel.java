package prm2t.lab6;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InputPanel extends JFrame {
    JTextField textField;
    private String input = "";
    private JLabel errorLabel;

    public InputPanel(){
        super("Input");
        setLocation(1300,250);
        setSize(new Dimension(300,150));
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Podaj wartość numeryczną:");

        textField = new JTextField(10);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkInput(textField.getText())){
                    input = textField.getText();
                    clear();
                    setVisible(false);
                }else{
                    input = "";
                    clear();
                    errorLabel.setText("Niepoprawny input");
                }
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input = "";
                clear();
                setVisible(false);
            }
        });

        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);

        add(label);
        add(textField);
        add(okButton);
        add(cancelButton);
        add(errorLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //zmien zeby program sie nie zamykal
        setVisible(true);
    }

    private boolean checkInput(String input){
        char[] chars = input.toCharArray();
        for(char c:chars){
            if((int)c < 48 || (int)c > 57){
                return false;
            }
        }
        return true;
    }

    private void clear(){
        textField.setText("");
        errorLabel.setText("");
    }

    public String getInput() {
            return input;
    }


}
