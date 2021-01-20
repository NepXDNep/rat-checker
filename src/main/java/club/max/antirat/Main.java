package club.max.antirat;

import club.max.antirat.gui.GUI;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.util.HashMap;

public class Main {
    public static GUI gui;
    public static void main(String[] args) {
        gui = new GUI();
    }

    public static void run(File file){
        gui.clear();
        gui.log("Starting checks on " + file.getName());
        App app = new App(file);
        HashMap<String, ClassNode> classNodes = app.getNodes();
    }

}
