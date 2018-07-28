package net.thimmwork

data class Dependency(val src: String, val tgt: String) {
    override fun toString() = "$src --> $tgt"
}
