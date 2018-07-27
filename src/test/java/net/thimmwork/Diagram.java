package net.thimmwork;

import java.util.ArrayList;
import java.util.List;

public class Diagram {
    private final Object[] contents;

    public Diagram(Object[] contents) {
        this.contents = contents;
    }

    public List<String> getLines() {
        List<String> lines = new ArrayList<>(contents.length + 2);
        lines.add("@startuml");
        for (Object it: contents) {
            lines.add(it.toString());
        }
        lines.add("@enduml");
        return lines;
    }
}
