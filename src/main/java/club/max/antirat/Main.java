package club.max.antirat;

import club.max.antirat.gui.GUI;

import java.io.File;

public class Main {
    public static GUI gui;
    public static void main(String[] args) {
        gui = new GUI();
    }

    public static void run(File file){
        gui.log("Starting checks on " + file.getName());

    }


}
