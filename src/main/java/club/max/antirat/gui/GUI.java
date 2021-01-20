package club.max.antirat.gui;

import club.max.antirat.Main;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javafx.stage.FileChooser;
import li.flor.nativejfilechooser.NativeJFileChooser;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUI extends JFrame{
    JPanel panel;
    JPanel panel1;
    JLabel mainLabel;
    JPanel fileBoxPanel;
    JButton fileSelectButton;
    JLabel fileIndicator;
    JButton runButton;
    JButton configOpener;
    File file;
    JPanel outputPanel;
    JTextArea outputField;
    JButton openButton;

    ConfigGui configGui;


    public GUI(){
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 0);
            UIManager.put("Component.arc", 0);
            UIManager.put("CheckBox.arc", 0);
            UIManager.put("ProgressBar.arc", 0);
            UIManager.put("Button.innerFocusWidth", 0);
            UIManager.put("Button.focusWidth", 0);

        } catch (Exception e){e.printStackTrace();}
//        frame = new JFrame("ANTI RAT");

        /*
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        panel.setLayout(new GridLayout(0, 1));

         */
        setTitle("ANTI-RAT");

        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 50, 50, 50));
        panel1.setLayout(new GridLayout(0, 1));
        add(panel1);

        mainLabel = new JLabel();
        mainLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainLabel.setText("RAT CHECKER");
        mainLabel.setPreferredSize(new Dimension(250, 30));
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setVerticalAlignment(JLabel.CENTER);
        panel1.add(mainLabel);

        fileBoxPanel = new JPanel();
        fileBoxPanel.setLayout(new GridLayout(4, 1));
        fileBoxPanel.setBorder(BorderFactory.createEmptyBorder());
        panel1.add(fileBoxPanel);

        fileIndicator = new JLabel(" Please choose a file");
        fileIndicator.setBackground(new Color(200, 200, 200));
        fileIndicator.setForeground(new Color(13, 13, 13));
        fileIndicator.setOpaque(true);
        fileBoxPanel.add(fileIndicator);

        fileSelectButton = new JButton("Choose File");
        fileSelectButton.addActionListener( e -> {
            NativeJFileChooser fileChooser = new NativeJFileChooser();
            if (fileChooser.showOpenDialog(((Component) e.getSource())) == NativeJFileChooser.APPROVE_OPTION){
                file = fileChooser.getSelectedFile();
                fileIndicator.setText(" File: " + file.getName());
                if (file.getName().endsWith(".jar")) {
                    runButton.setEnabled(true);
                } else {
                    runButton.setEnabled(false);
                }
            }
        });
        fileBoxPanel.add(fileSelectButton);
        fileSelectButton.setFocusable(false);

        runButton = new JButton("Run");
        runButton.setEnabled(false);
        runButton.setMaximumSize(getSize());
        fileBoxPanel.add(runButton);
        runButton.addActionListener(e -> {
            runButton.setText("Running...");
            Main.run(file);
        });
        runButton.setFocusable(false);

        configGui = new ConfigGui();
        configOpener = new JButton("Edit config");
        configOpener.addActionListener(e -> {
            configGui.setVisible(true);
        });
        configOpener.setFocusable(false);
        fileBoxPanel.add(configOpener);


        outputPanel = new JPanel();
        outputPanel.setLayout(new GridLayout(1, 1));
        outputPanel.setBorder(BorderFactory.createEmptyBorder());
        outputPanel.setFocusable(false);
        panel1.add(outputPanel);

        outputField = new JTextArea();
        outputField.setEditable(false);
        outputField.setOpaque(true);
//        outputField.setPreferredSize(new Dimension(300, 300));
        JScrollPane scrollPane = new JScrollPane(outputField);
        scrollPane.setAutoscrolls(false);
        outputPanel.add(scrollPane);

        log("Log area");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setSize(getWidth() + 200, getHeight() + 100);
        setVisible(true);
    }

    public void log(String line){
  //      outputField.setText(outputField.getText() + line + "\n");
        outputField.append(line + "\n");
    }

    public void clear(){
        outputField.setText("");
    }

    public void updateUI(){
        panel1.updateUI();
        mainLabel.updateUI();
        fileBoxPanel.updateUI();
        fileSelectButton.updateUI();
        fileIndicator.updateUI();
        runButton.updateUI();
        configOpener.updateUI();
        outputPanel.updateUI();
        outputField.updateUI();
//        openButton.updateUI();
    }


}
