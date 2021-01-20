package club.max.antirat.check.checks;

import club.max.antirat.check.Check;
import org.objectweb.asm.tree.*;

import java.util.HashMap;

public class SystemCheck extends Check {
    public SystemCheck(HashMap<String, ClassNode> nodes) {
        super(nodes);
    }
    //Checks for System.getProperty, System.getEnv, and System.getProperties


    @Override
    public String getCheckName() {
        return "SYSTEM_CHECK";
    }

    @Override
    public void runOnMethod(MethodNode method, ClassNode classNode) {
        super.runOnMethod(method, classNode);
        for (AbstractInsnNode insn : method.instructions){
            if (insn instanceof MethodInsnNode) {

                if (((MethodInsnNode) insn).name.equalsIgnoreCase("getProperty") || ((MethodInsnNode) insn).name.equalsIgnoreCase("getenv") || ((MethodInsnNode) insn).name.equalsIgnoreCase("getProperties")){
                    out("Found system property/env method: [" + classNode.name + ": " + method.name + ": " + ((MethodInsnNode) insn).name + "]");
                }
        //        out("Found  reference: [" + classNode.name + ": " + method.name + "]");
            }
        }
    }
}
