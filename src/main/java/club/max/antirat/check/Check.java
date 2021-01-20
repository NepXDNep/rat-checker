package club.max.antirat.check;

import club.max.antirat.Main;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashMap;
import java.util.Map;

public class Check {

    public HashMap<String, ClassNode> nodes;
    public HashMap<String, MethodNode> methods;
    public String checkName;

    public Check(HashMap<String, ClassNode> nodes){
        this.nodes = nodes;
        this.checkName = "";
        this.methods = new HashMap<>();

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
        out("FINISHED CHECK");
    }

    public void runOnClass(String className, ClassNode node){
   //     out(className);
        for (MethodNode methodNode : node.methods){
   //         out(methodNode.name + " " + methodNode.desc);
            runOnMethod(methodNode);
        }
    }

    public void runOnMethod(MethodNode method){

    }
}
