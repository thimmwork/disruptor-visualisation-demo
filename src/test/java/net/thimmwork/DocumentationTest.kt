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

        val diagram = disruptor(arrayOf(
                arrow(startEnd, s1),
                eventHandlerGroup("EventHandlerGroup1", arrow(s1, handle1)),
                eventHandlerGroup("EventHandlerGroup2", arrow(s1, process1), arrow(process1, process2)),
                arrow(process2, s2),
                eventHandlerGroup("EventHandlerGroup3", arrow(s2, handleJoin)),
                arrow(handle1, s2),
                arrow(handleJoin, startEnd)
        ))
        Files.write(File("dynamic-kt.txt").toPath(), diagram.lines, Charset.forName("UTF-8"))
    }
}

//DSL

fun disruptor(elements: Array<Any>): Diagram {
    return Diagram(elements)
}

fun eventHandlerGroup(name: String, vararg contents: Any) : Partition {
    return Partition(name, *contents)
}

fun arrow(src: String, tgt: String) = Dependency(src, tgt)
