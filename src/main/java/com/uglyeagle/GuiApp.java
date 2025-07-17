package com.uglyeagle;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class GuiApp {

    public static void main(String[] args) {
        System.out.println("enters main");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }

        JFrame frame = new JFrame("Ugly Eagle GUI App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JPanel outerPanel = new JPanel(new GridBagLayout());
        outerPanel.setBackground(new Color(245, 248, 255));

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createLineBorder(new Color(46, 204, 113), 2, true));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Welcome to Ugly Eagle Interactive GUI");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(new Color(52, 152, 219));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridy = 1;
        contentPanel.add(new JLabel("Your Name:"), gbc);

        JTextField nameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        contentPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(new JLabel("Favourite Language:"), gbc);

        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Go", "Java", "JavaScript", "Python"});
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        contentPanel.add(comboBox, gbc);

        JButton greetButton = new JButton("Greet Me");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(greetButton, gbc);

        greetButton.addActionListener((ActionEvent e) -> {
            String name = nameField.getText().trim();
            String lang = (String) comboBox.getSelectedItem();
            if (!name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Hello " + name + "! You like " + lang + ".", "Greeting", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(name + " is greeted");
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter your name!", "Missing Input", JOptionPane.WARNING_MESSAGE);
            }
        });

        outerPanel.add(contentPanel);
        frame.setContentPane(outerPanel);
        frame.toFront();
        frame.repaint();

        frame.setVisible(true);
    }
}
