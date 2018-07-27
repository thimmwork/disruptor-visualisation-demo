package net.thimmwork;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    private final String name;
    private final Object[] contents;


    public Partition(String name, Object... contents) {
        this.name = name;
        this.contents = contents;
    }

    @Override
    public String toString() {
        List<String> lines = new ArrayList<>(contents.length + 2);
        lines.add("partition " + name + " {");
        for (Object it : contents) {
            lines.add(it.toString());
        }
        lines.add("}");
        return Joiner.on("\n").join(lines);
    }
}
