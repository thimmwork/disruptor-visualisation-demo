package net.thimmwork;

public class Dependency {
    private final String src;
    private final String tgt;

    public Dependency(String src, String tgt) {
        this.src = src;
        this.tgt = tgt;
    }

    @Override
    public String toString() {
        return src + " --> " + tgt;
    }
}
