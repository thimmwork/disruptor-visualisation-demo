package net.thimmwork

import java.util.ArrayList

class Diagram(private val contents: Array<Any>) {

    val lines: List<String>
        get() {
            val lines = ArrayList<String>(contents.size + 2)
            lines += "@startuml"
            contents.forEach { lines += it.toString() }
            lines += "@enduml"
            return lines
        }
}
