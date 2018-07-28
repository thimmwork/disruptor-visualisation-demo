package net.thimmwork

import org.junit.Test
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files

class DocumentationTest {
    @Test
    fun dynamicDiagram() {
        val startEnd = "(*)"
        val s1 = "=== S1 ==="
        val s2 = "=== S2 ==="
        val handle1 = "Handle1"
        val process1 = "Process1"
        val process2 = "Process2"
        val handleJoin = "HandleJoin"
        val line1 = Dependency(startEnd, s1)
        val line2 = Dependency(process2, s2)
        val line3 = Dependency(handle1, s2)
        val line4 = Dependency(handleJoin, startEnd)

        val eventHandlerGroup1 = Partition("EventHandlerGroup1", Dependency(s1, handle1))
        val eventHandlerGroup2 = Partition("EventHandlerGroup2",
                Dependency(s1, process1),
                Dependency(process1, process2)
        )
        val eventHandlerGroup3 = Partition("EventHandlerGroup3", Dependency(s2, handleJoin))
        val diagram = Diagram(arrayOf(line1, eventHandlerGroup1, eventHandlerGroup2, line2, eventHandlerGroup3, line3, line4))
        Files.write(File("dynamic-kt.txt").toPath(), diagram.lines, Charset.forName("UTF-8"))
    }
}