package club.max.antirat;

import club.max.antirat.check.Check;
import club.max.antirat.check.checks.URLCheck;
import club.max.antirat.gui.GUI;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static GUI gui;
    static ArrayList<Check> checks;
    public static void main(String[] args) {
        gui = new GUI();
    }



    public static void run(File file){
        gui.clear();
        gui.log("Starting checks on " + file.getName());
        App app = new App(file);
        HashMap<String, ClassNode> classNodes = app.getNodes();

        checks = new ArrayList<>();
        checks.add(new URLCheck(classNodes));

        for (Check check : checks){
            check.run();
        }
    }

}
