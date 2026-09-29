package com.uregina.tasks.stringbuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UndoableStringBuilderTest {

    @Test
    void undoRevertsOperationsInReverseOrder() {
        UndoableStringBuilder sb = new UndoableStringBuilder();
        sb.append("abc").append(1).append('!');
        assertEquals("abc1!", sb.toString());

        sb.undo();
        assertEquals("abc1", sb.toString());
        sb.undo();
        assertEquals("abc", sb.toString());
        sb.undo();
        assertEquals("", sb.toString());
        assertFalse(sb.canUndo());
    }

    @Test
    void undoWithEmptyHistoryDoesNothing() {
        UndoableStringBuilder sb = new UndoableStringBuilder("text");
        sb.undo();
        assertEquals("text", sb.toString());
    }

    @Test
    void insertDeleteReplaceReverse() {
        UndoableStringBuilder sb = new UndoableStringBuilder("hello world");
        sb.insert(0, "[").append("]");
        assertEquals("[hello world]", sb.toString());

        sb.replace(1, 6, "bye");
        assertEquals("[bye world]", sb.toString());

        sb.delete(4, 10);
        assertEquals("[bye]", sb.toString());

        sb.reverse();
        assertEquals("]eyb[", sb.toString());

        sb.undo().undo().undo();
        assertEquals("[hello world]", sb.toString());
    }

    @Test
    void growsBeyondInitialCapacity() {
        UndoableStringBuilder sb = new UndoableStringBuilder();
        String longText = "x".repeat(100);
        sb.append(longText);
        assertEquals(100, sb.length());
        sb.undo();
        assertEquals(0, sb.length());
    }

    @Test
    void setCharAtAndSetLength() {
        UndoableStringBuilder sb = new UndoableStringBuilder("cat");
        sb.setCharAt(0, 'b');
        sb.setLength(2);
        assertEquals("ba", sb.toString());
        sb.undo();
        assertEquals("bat", sb.toString());
        sb.undo();
        assertEquals("cat", sb.toString());
    }

    @Test
    void invalidIndexDoesNotAddSnapshot() {
        UndoableStringBuilder sb = new UndoableStringBuilder("abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> sb.insert(10, "x"));
        assertFalse(sb.canUndo());
    }
}
