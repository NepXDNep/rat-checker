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
    public boolean enabled = true;

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
        if (enabled) {
            nodes.forEach((s, n) -> {
                runOnClass(s, n);
            });
            out("FINISHED CHECK");
        }
    }

    public void runOnClass(String className, ClassNode node){
   //     out(className);
        for (MethodNode methodNode : node.methods){
   //         out(methodNode.name + " " + methodNode.desc);
            runOnMethod(methodNode, node);
        }
    }

    public void runOnMethod(MethodNode method, ClassNode classNode){

    }

    public void setNodes(HashMap<String, ClassNode> nodes) {
        this.nodes = nodes;
    }
}
