package club.max.antirat.check.checks;

import club.max.antirat.check.Check;
import org.objectweb.asm.tree.ClassNode;

import java.util.HashMap;

public class URLCheck extends Check {
    public URLCheck(HashMap<String, ClassNode> nodes) {
        super(nodes);
    }

    @Override
    public String getCheckName() {
        return "URL_CHECK";
    }
}
