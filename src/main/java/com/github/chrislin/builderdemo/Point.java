package com.github.chrislin.builderdemo;

public class Point {
    int x;
    int y;
    int z;
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point(%d, %d, %d)".formatted(x, y, z);
    }
}