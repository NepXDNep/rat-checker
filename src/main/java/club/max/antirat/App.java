package club.max.antirat;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class App {

    HashMap<String, ClassNode> nodes;

    public App(File file){
        try {
            ClassReader reader;
            ClassNode node;
            nodes = new HashMap<>();
            JarFile jar = new JarFile(file);
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()){
                JarEntry entry = entries.nextElement();
                try {
 //                   System.out.println(entry.getName());
 //                   Main.gui.log("Loading: " + entry.getName());
                    if (!entry.getName().endsWith(".class")) {

                    } else {
                        node = new ClassNode();
                        reader = new ClassReader(jar.getInputStream(entry));
                        reader.accept(node, ClassReader.EXPAND_FRAMES);
                        nodes.put(node.name, node);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (Exception e){e.printStackTrace();}
    }

    public HashMap<String, ClassNode> getNodes(){
        return nodes;
    }
}
