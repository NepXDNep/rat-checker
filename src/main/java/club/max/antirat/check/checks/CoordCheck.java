package club.max.antirat.check.checks;

import club.max.antirat.check.Check;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.ArrayList;
import java.util.HashMap;

public class CoordCheck extends Check {
    ArrayList<String> names = new ArrayList<>();

    public CoordCheck(HashMap<String, ClassNode> nodes) {
        super(nodes);
        for (int i = 0; i < namesArray.length; i++){
            names.add(namesArray[i]);
        }
    }

    //credit to theia for this list cuz im not manually going through minecraft src to make this


    @Override
    public String getCheckName() {
        return "COORD_CHECK";
    }

    String[] namesArray = new String[]{
           "field_148990_b", // 1.8.9 posX
            "field_70165_t", // 1.8.9 posX
            "field_75646_b", // 1.8.9 posX
            "field_75656_e", // 1.8.9 posX
            "field_148988_d", // 1.8.9 posZ
            "field_70161_v", // 1.8.9 posZ
            "field_75644_d", // 1.8.9 posZ
            "field_75654_g", // 1.8.9 posZ
            "field_70165_t", // 1.12.2 posX
            "field_70161_v", // 1.12.2 posZ
            "field_148990_b", // 1.13.2 posX
            "field_148988_d", // 1.13.2 posZ
            "field_148990_b", // 1.14.4 posX
            "field_148988_d", // 1.14.4 posZ
            "field_148990_b", // 1.15 posX
            "field_148988_d" // 1.15 posZ
    };

    @Override
    public void runOnMethod(MethodNode method, ClassNode classNode) {
        super.runOnMethod(method, classNode);
        for (AbstractInsnNode insn : method.instructions){
            if (insn instanceof FieldInsnNode && names.contains(((FieldInsnNode) insn).name)) {
                out("Found coord reference: [" + classNode.name + ": " + method.name + "]");
            }
        }
    }
}
