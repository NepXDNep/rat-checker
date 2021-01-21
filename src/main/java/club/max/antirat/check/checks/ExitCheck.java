package club.max.antirat.check.checks;

import club.max.antirat.check.Check;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashMap;

public class ExitCheck extends Check {
    public ExitCheck(HashMap<String, ClassNode> nodes) {
        super(nodes);
    }

    @Override
    public String getCheckName() {
        return "EXIT_CHECK";
    }

    @Override
    public void runOnMethod(MethodNode method, ClassNode classNode) {
        super.runOnMethod(method, classNode);

        for (AbstractInsnNode insn : method.instructions){
            if (insn instanceof MethodInsnNode) {
                if (((MethodInsnNode) insn).name.equalsIgnoreCase("exit") || ((MethodInsnNode) insn).desc.toLowerCase().contains("exit") || ((MethodInsnNode) insn).desc.toLowerCase().contains("security")){
                    out("Found exit/security method: [" + classNode.name + ": " + method.name + ": " + ((MethodInsnNode) insn).name + "]");
                }
            }
        }

    }
}
