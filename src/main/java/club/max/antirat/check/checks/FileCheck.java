package club.max.antirat.check.checks;

import club.max.antirat.check.Check;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;

import java.io.File;
import java.util.HashMap;

public class FileCheck extends Check {
    public FileCheck(HashMap<String, ClassNode> nodes) {
        super(nodes);
    }

    @Override
    public String getCheckName() {
        return "FILE_CHECK";
    }

    @Override
    public void runOnMethod(MethodNode method, ClassNode classNode) {
        super.runOnMethod(method, classNode);
        for (AbstractInsnNode insn : method.instructions){

            if (insn instanceof TypeInsnNode){
                TypeInsnNode casted = ((TypeInsnNode) insn);
                if (casted.desc.equalsIgnoreCase("java/io/File")) {
                    out("Found File: [" + classNode.name + ": " + method.name + "]");
                }
            }
        }
    }
}
