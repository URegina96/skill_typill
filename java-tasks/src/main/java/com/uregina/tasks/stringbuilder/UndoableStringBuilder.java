package com.uregina.tasks.stringbuilder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class UndoableStringBuilder implements CharSequence {

    private static final int DEFAULT_CAPACITY = 16;

    private char[] value;
    private int count;
    private final Deque<Snapshot> history = new ArrayDeque<>();

    public UndoableStringBuilder() {
        value = new char[DEFAULT_CAPACITY];
    }

    public UndoableStringBuilder(String str) {
        value = new char[str.length() + DEFAULT_CAPACITY];
        str.getChars(0, str.length(), value, 0);
        count = str.length();
    }

    public UndoableStringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    public UndoableStringBuilder append(String str) {
        String s = String.valueOf(str);
        save();
        ensureCapacity(count + s.length());
        s.getChars(0, s.length(), value, count);
        count += s.length();
        return this;
    }

    public UndoableStringBuilder append(char c) {
        save();
        ensureCapacity(count + 1);
        value[count++] = c;
        return this;
    }

    public UndoableStringBuilder append(int i) {
        return append(String.valueOf(i));
    }

    public UndoableStringBuilder insert(int offset, String str) {
        checkOffset(offset);
        String s = String.valueOf(str);
        save();
        ensureCapacity(count + s.length());
        System.arraycopy(value, offset, value, offset + s.length(), count - offset);
        s.getChars(0, s.length(), value, offset);
        count += s.length();
        return this;
    }

    public UndoableStringBuilder delete(int start, int end) {
        if (end > count) {
            end = count;
        }
        if (start < 0 || start > end) {
            throw new StringIndexOutOfBoundsException("start " + start + ", end " + end + ", length " + count);
        }
        save();
        System.arraycopy(value, end, value, start, count - end);
        count -= end - start;
        return this;
    }

    public UndoableStringBuilder deleteCharAt(int index) {
        checkIndex(index);
        return delete(index, index + 1);
    }

    public UndoableStringBuilder replace(int start, int end, String str) {
        if (end > count) {
            end = count;
        }
        if (start < 0 || start > end) {
            throw new StringIndexOutOfBoundsException("start " + start + ", end " + end + ", length " + count);
        }
        save();
        int newCount = count + str.length() - (end - start);
        ensureCapacity(newCount);
        System.arraycopy(value, end, value, start + str.length(), count - end);
        str.getChars(0, str.length(), value, start);
        count = newCount;
        return this;
    }

    public UndoableStringBuilder reverse() {
        save();
        for (int i = 0, j = count - 1; i < j; i++, j--) {
            char tmp = value[i];
            value[i] = value[j];
            value[j] = tmp;
        }
        return this;
    }

    public void setCharAt(int index, char c) {
        checkIndex(index);
        save();
        value[index] = c;
    }

    public void setLength(int newLength) {
        if (newLength < 0) {
            throw new StringIndexOutOfBoundsException(newLength);
        }
        save();
        ensureCapacity(newLength);
        if (newLength > count) {
            Arrays.fill(value, count, newLength, '\0');
        }
        count = newLength;
    }

    public UndoableStringBuilder undo() {
        Snapshot snapshot = history.poll();
        if (snapshot != null) {
            snapshot.restore();
        }
        return this;
    }

    public boolean canUndo() {
        return !history.isEmpty();
    }

    public int capacity() {
        return value.length;
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public char charAt(int index) {
        checkIndex(index);
        return value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return toString().substring(start, end);
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }

    private void save() {
        history.push(new Snapshot(Arrays.copyOf(value, count), count));
    }

    private void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity > value.length) {
            int newCapacity = Math.max((value.length << 1) + 2, minimumCapacity);
            value = Arrays.copyOf(value, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new StringIndexOutOfBoundsException("index " + index + ", length " + count);
        }
    }

    private void checkOffset(int offset) {
        if (offset < 0 || offset > count) {
            throw new StringIndexOutOfBoundsException("offset " + offset + ", length " + count);
        }
    }

    private final class Snapshot {

        private final char[] state;
        private final int length;

        private Snapshot(char[] state, int length) {
            this.state = state;
            this.length = length;
        }

        private void restore() {
            value = Arrays.copyOf(state, Math.max(state.length, DEFAULT_CAPACITY));
            count = length;
        }
    }
}
