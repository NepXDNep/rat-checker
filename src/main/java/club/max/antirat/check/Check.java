package club.max.antirat.check;

import club.max.antirat.Main;
import org.objectweb.asm.tree.ClassNode;

import java.util.HashMap;

public class Check {

    public HashMap<String, ClassNode> nodes;
    public String checkName;

    public Check(HashMap<String, ClassNode> nodes){
        this.nodes = nodes;
        this.checkName = "";
    }

    public void out(String output){
        Main.gui.log(getCheckName() + ": " + output);
    }

    public String getCheckName() {
        return checkName;
    }

    public void run(){
        nodes.forEach((s, n) -> {
            runOnClass(s, n);
        });
    }

    public void runOnClass(String className, ClassNode node){
        out(className);
    }
}
