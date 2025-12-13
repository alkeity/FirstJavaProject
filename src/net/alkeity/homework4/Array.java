package net.alkeity.homework4;

import java.math.BigDecimal;
import java.util.Arrays;

public class Array<T extends Number> {
    private final int sizeIncrement = 10;
    private int size;
    private Number[] array;
    private int nextIndex;

    public Array() {
        this.nextIndex = 0;
        this.size = 10;
        this.array = new Number[size];
    }

    public void add(T item) {
        if (this.nextIndex >= this.size) resize();
        this.array[this.nextIndex++] = item;
    }

    public T get(int index) {
        return (T) this.array[index];
    }

    private void resize() {
        this.size = this.size + this.sizeIncrement;
        Number[] newArray = new Number[this.size];
        System.arraycopy(this.array, 0, newArray, 0, this.size - this.sizeIncrement);
        this.array = newArray;
    }

    public void insert(int index, Number elem) {
        if (index < 0) throw new ArrayIndexOutOfBoundsException("Index cannot be negative");
        if (this.nextIndex >= this.size) {
            this.size = this.size + this.sizeIncrement;
        }

        Number[] newArray = new Number[size];
        if (index > 0) System.arraycopy(this.array, 0, newArray, 0, index);
        newArray[index] = elem;
        System.arraycopy(this.array, index, newArray, index + 1, this.nextIndex);
        this.array = newArray;
    }


    public void printArray() {
        for (int i = 0; i < this.nextIndex; i++) {
            System.out.printf("%s ", this.array[i]);
        }
    }

    public T maxValue() {
        BigDecimal maxValue = (BigDecimal) this.array[0];
        int maxValueIndex = 0;
        for (int i = 1; i < this.nextIndex; i++) {
            if (maxValue.compareTo((BigDecimal) this.array[i]) < 0) {
                maxValueIndex = i;
                maxValue = (BigDecimal) this.array[i];
            }
        }
        return get(maxValueIndex);
    }

    public T minValue() {
        BigDecimal minValue = (BigDecimal) this.array[0];
        int minValueIndex = 0;
        for (int i = 1; i < this.nextIndex; i++) {
            if (minValue.compareTo((BigDecimal) this.array[i]) > 0) {
                minValueIndex = i;
                minValue = (BigDecimal) this.array[i];
            }
        }
        return get(minValueIndex);
    }

    public BigDecimal mean() {
        BigDecimal summ = (BigDecimal) this.array[0];
        for (int i = 0; i < this.nextIndex; i++) {
            summ = summ.add((BigDecimal) this.array[i]);
        }
        return summ.divide(BigDecimal.valueOf(this.nextIndex));
    }

    public void sortAsc() {
        for (int i = 0; i < this.nextIndex; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < this.nextIndex - i; j++) {
                BigDecimal comparable = (BigDecimal) this.array[j];
                if (comparable.compareTo((BigDecimal) this.array[j + 1]) < 0) {
                    Number tmp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    public void sortDesc() {
        for (int i = 0; i < this.nextIndex; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < this.nextIndex - i; j++) {
                BigDecimal comparable = (BigDecimal) this.array[j];
                if (comparable.compareTo((BigDecimal) this.array[j + 1]) > 0) {
                    Number tmp = this.array[j];
                    this.array[j] = this.array[j + 1];
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    public T binarySearch(T value) {
        sortAsc();
        Number result = Arrays.binarySearch(this.array, value);
        return (T) result;
    }

    public void replace(int index, T value) {
        if (index < 0) throw new ArrayIndexOutOfBoundsException("Index cannot be negative");
        if (index > this.nextIndex) throw new ArrayIndexOutOfBoundsException("Out of bounds");

        if (index == this.nextIndex) this.add(value);
        else array[index] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Array<?> array1 = (Array<?>) o;
        return size == array1.size && nextIndex == array1.nextIndex && Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + Arrays.hashCode(array);
        result = 31 * result + nextIndex;
        return result;
    }

    @Override
    public String toString() {
        return "Array{" +
                "sizeIncrement=" + sizeIncrement +
                ", size=" + size +
                ", array=" + Arrays.toString(array) +
                ", nextIndex=" + nextIndex +
                '}';
    }
}
