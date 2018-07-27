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
    public void simpleDiagram() throws IOException {
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
                "Handle1 --> HandleJoin",
                "@enduml"
        });
        Files.write(new File("output.txt").toPath(), lines, Charset.forName("UTF-8"));
    }

    @Ignore
    @Test
    public void demoDisruptor() {
        Disruptor disruptor = new MyDisruptor();

        disruptor.start();
    }
}