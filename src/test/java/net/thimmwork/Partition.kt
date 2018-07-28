package net.thimmwork

import com.google.common.base.Joiner

import java.util.ArrayList
import java.util.Arrays

class Partition(private val name: String, private vararg val contents: Any) {

    override fun toString(): String {
        val lines = ArrayList<String>(contents.size + 2)
        lines += "partition $name {"
        contents.forEach { lines += it.toString() }
        lines += "}"
        return Joiner.on("\n").join(lines)
    }
}
