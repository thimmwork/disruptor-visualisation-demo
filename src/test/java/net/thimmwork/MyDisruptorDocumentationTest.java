package net.thimmwork;

import com.lmax.disruptor.dsl.Disruptor;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class MyDisruptorDocumentationTest {

    @Test
    public void staticDiagram() throws IOException {
        List<String> lines = Arrays.asList(new String[] {
                "@startuml",
                "(*) --> === S1 ===",
                "partition EventHandlerGroup1 {",
                "  === S1 === --> Handle1",
                "}",
                "partition EventHandlerGroup2 {",
                "  === S1 === --> Process1",
                "  Process1 --> Process2",
                "}",
                "Process2 --> === S2 ===",
                "partition EventHandlerGroup3 {",
                "  === S2 === --> HandleJoin",
                "}",
                "Handle1 --> === S2 ===",
                "HandleJoin --> (*)",
                "@enduml"
        });
        Files.write(new File("static.txt").toPath(), lines, Charset.forName("UTF-8"));
    }

    @Test
    public void dynamicDiagram() throws IOException {
        String startEnd = "(*)";
        String s1 = "=== S1 ===";
        String s2 = "=== S2 ===";
        String handle1 = "Handle1";
        String process1 = "Process1";
        String process2 = "Process2";
        String handleJoin = "HandleJoin";
        Dependency line1 = new Dependency(startEnd, s1);
        Dependency line2 = new Dependency(process2, s2);
        Dependency line3 = new Dependency(handle1, s2);
        Dependency line4 = new Dependency(handleJoin, startEnd);

        Partition eventHandlerGroup1 = new Partition("EventHandlerGroup1", new Dependency(s1, handle1));
        Partition eventHandlerGroup2 = new Partition("EventHandlerGroup2",
                new Dependency(s1, process1),
                new Dependency(process1, process2)
        );
        Partition eventHandlerGroup3 = new Partition("EventHandlerGroup3", new Dependency(s2, handleJoin));
        Diagram diagram = new Diagram(new Object[] { line1, eventHandlerGroup1, eventHandlerGroup2, line2, eventHandlerGroup3, line3, line4 });
        Files.write(new File("dynamic.txt").toPath(), diagram.getLines(), Charset.forName("UTF-8"));
    }

    @Ignore
    @Test
    public void demoDisruptor() {
        Disruptor disruptor = new MyDisruptor();

        disruptor.start();
    }
}