package club.max.antirat.check.checks;

import club.max.antirat.check.Check;
import org.objectweb.asm.tree.*;

import java.util.HashMap;
import java.util.Map;

public class URLCheck extends Check {
    public URLCheck(HashMap<String, ClassNode> nodes) {
        super(nodes);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void runOnClass(String className, ClassNode node) {
        super.runOnClass(className, node);
 //       Thread thread = new Thread();
    }

    @Override
    public void runOnMethod(MethodNode method, ClassNode classNode) {
        super.runOnMethod(method, classNode);
        for (AbstractInsnNode insn : method.instructions){

            if (insn instanceof TypeInsnNode){
                TypeInsnNode casted = ((TypeInsnNode) insn);
                if (casted.desc.equalsIgnoreCase("java/net/URL")) {
                    out("Found url: [" + classNode.name + ": " + method.name + "]");
                }
            }
        }
    }

    @Override
    public String getCheckName() {
        return "URL_CHECK";
    }
}
