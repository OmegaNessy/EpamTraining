package by.epam.etc.entity;

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

    //TODO: добавить override hashcode и тд.
}
