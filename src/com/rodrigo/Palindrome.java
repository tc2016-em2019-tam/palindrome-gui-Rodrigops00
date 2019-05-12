package com.rodrigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Palindrome extends JFrame {

    private ArrayList<String> array;

    public Palindrome() {
        array = new ArrayList<>();

        this.setTitle("Palindrome");
        this.setSize(200, 100);
        this.setLayout(new GridLayout(3, 1));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setComponents();

        this.setVisible(true);
    }


    private void setComponents() {
        JLabel label = new JLabel("Enter your text:");
        JTextField string = new JTextField();
        JButton button = new JButton("Check");
        JLabel result = new JLabel();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                push(string.getText());
                if (isPalindrome()) {
                    result.setText("This is a palindrome");
                } else {
                    result.setText("This isn't a palindrome");
                }
                pop();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));

        panel.add(label);
        panel.add(string);

        this.add(panel);
        this.add(button);
        this.add(result);
    }

    public void push(String x) {
        array.add(x);
    }

    public String pop() {
        return array.remove(array.size() - 1);
    }

    public boolean find(String x) {
        return array.contains(x);
    }

    @Override
    public String toString() {
        return array.toString();
    }

    public boolean isPalindrome() {
        if (array.get(0).length() != 0) {

            String string = array.get(0).replaceAll(" ", "").toLowerCase();

            for (int i = 0, j = string.length() - 1; i < string.length() / 2; i++, j--) {
                if (string.charAt(i) != string.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}