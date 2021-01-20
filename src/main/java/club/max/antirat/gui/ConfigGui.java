package club.max.antirat.gui;

import club.max.antirat.Main;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class ConfigGui extends JFrame {

    JPanel panel;
    JCheckBox darkMode;

    public ConfigGui(){
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(1, 1));
        add(panel);

        darkMode = new JCheckBox("Dark mode");
        darkMode.addActionListener(e -> {
            if (darkMode.isEnabled()){
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                    updateUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                    updateUI();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        panel.add(darkMode);
        panel.updateUI();

        setResizable(false);
        pack();
    }

    public void updateUI(){
        panel.updateUI();
        darkMode.updateUI();
        Main.gui.updateUI();
    }
}
