package club.max.antirat.gui;

import club.max.antirat.Main;
import club.max.antirat.check.Check;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConfigGui extends JFrame {

    JPanel panel;
//    JCheckBox darkMode;
    ArrayList<JCheckBox> components;

    public ConfigGui(){

        setTitle("Config");

        components = new ArrayList<>();
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(1, 1));
        add(panel);

        for (Check c : Main.checks){
            JCheckBox box = new JCheckBox(c.getCheckName());
            box.setSelected(true);
            box.addActionListener(e -> {
                if (((JCheckBox) e.getSource()).isSelected()){
                    c.enabled = true;
                } else {
                    c.enabled = false;
                }
            });
            components.add(box);
        }

        JCheckBox darkMode = new JCheckBox("DARK MODE");
        darkMode.addActionListener(e -> {
            if (((JCheckBox) e.getSource()).isSelected()){
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                    updateUI();
                } catch (Exception ex){}
            } else {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                    updateUI();
                } catch (Exception ex){}
            }
        });
        components.add(darkMode);

        for (JCheckBox c : components){
            panel.add(c);
        }

        panel.setLayout(new GridLayout((components.size() + 1) / 2, 2));

        panel.updateUI();

        setResizable(false);
        pack();

    }

    public void updateUI(){
        panel.updateUI();
        for (JCheckBox c : components){
            c.updateUI();
        }
        Main.gui.updateUI();
    }
}
