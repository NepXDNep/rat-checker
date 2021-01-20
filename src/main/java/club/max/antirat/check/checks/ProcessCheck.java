package club.max.antirat.check.checks;

import club.max.antirat.check.Check;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashMap;

public class ProcessCheck extends Check {
    public ProcessCheck(HashMap<String, ClassNode> nodes) {
        super(nodes);
    }

    //Checks for use of processes


    @Override
    public String getCheckName() {
        return "PROCESS_CHECK";
    }

    @Override
    public void runOnMethod(MethodNode method, ClassNode classNode) {
        super.runOnMethod(method, classNode);
        for (AbstractInsnNode insn : method.instructions){
            if (insn instanceof MethodInsnNode){
                if (((MethodInsnNode) insn).owner.equalsIgnoreCase("java/lang/Process") || ((MethodInsnNode) insn).owner.equalsIgnoreCase("java/lang/ProcessBuilder")){
                    out("Process found: [" + classNode.name + ": " + method.name + ": " + ((MethodInsnNode) insn).name + "]");
                }
            }
        }
    }
}
