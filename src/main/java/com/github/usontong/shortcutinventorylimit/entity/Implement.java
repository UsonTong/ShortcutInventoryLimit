package com.github.usontong.shortcutinventorylimit.entity;

public class Implement {
    private ImplementFunction implementFunction;//违规后运作方式
    private int toggle;//运作方式为toggle 跳转到的快捷栏 0-9

    public Implement(ImplementFunction implementFunction, int toggle) {
        this.implementFunction = implementFunction;
        this.toggle = toggle;
    }

    public ImplementFunction getImplementFunction() {
        return implementFunction;
    }

    public int getToggle() {
        return toggle;
    }

    @Override
    public String toString() {
        return "Implement{" +
                "implementFunction=" + implementFunction +
                ", toggle=" + toggle +
                '}';
    }
}
