package by.epam.etc.entity;

import java.util.Arrays;

public class ArrayObj {
    private int[] array;

    public ArrayObj (int[] array){
        this.array = array;
    }

    public int size(){
        return array.length;
    }

    public void setElement (int index, int value){
        array[index] = value;
    }

    public int getElement (int index){
        return array[index];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i: array) {
            string.append(i);
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayObj arrayObj = (ArrayObj) o;
        return Arrays.equals(array, arrayObj.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

}
