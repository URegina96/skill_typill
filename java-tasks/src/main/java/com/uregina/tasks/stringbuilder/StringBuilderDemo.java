package com.uregina.tasks.stringbuilder;

public class StringBuilderDemo {

    public static void main(String[] args) {
        UndoableStringBuilder sb = new UndoableStringBuilder("Hello");
        sb.append(", world").append('!');
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.undo();
        System.out.println(sb);

        sb.insert(0, ">> ").replace(3, 8, "Hi");
        System.out.println(sb);

        sb.undo().undo();
        System.out.println(sb);
    }
}
