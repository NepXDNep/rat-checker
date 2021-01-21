package club.max.antirat;

import club.max.antirat.check.Check;
import club.max.antirat.check.checks.*;
import club.max.antirat.gui.GUI;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static GUI gui;
    public static ArrayList<Check> checks;
    public static void main(String[] args) {
        checks = new ArrayList<>();
        checks.add(new CoordCheck(null));
        checks.add(new SystemCheck(null));
        checks.add(new ProcessCheck(null));
        checks.add(new ExitCheck(null));
        checks.add(new FileCheck(null));
        checks.add(new URLCheck(null));


        gui = new GUI();
    }



    public static void run(File file){
        gui.clear();
        gui.log("Starting checks on " + file.getName());
        App app = new App(file);
        HashMap<String, ClassNode> classNodes = app.getNodes();

        for (Check check : checks) {
            check.setNodes(classNodes);
        }
        /*
        checks = new ArrayList<>();
        checks.add(new CoordCheck(classNodes));
        checks.add(new SystemCheck(classNodes));
        checks.add(new ProcessCheck(classNodes));
        checks.add(new URLCheck(classNodes));

         */


        for (Check check : checks){
            check.run();
        }
    }

}
