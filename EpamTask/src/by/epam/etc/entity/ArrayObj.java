package by.epam.etc.entity;

public class ArrayObj {
    private int[] arr;

    public ArrayObj (int[] arr){
        this.arr = arr;
    }

    public int size(){
        return arr.length;
    }

    public void setElement (int index, int value){
        arr[index] = value;
    }

    public int getElement (int index){
        return arr[index];
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i: arr) {
            string.append(i);
        }
        return string.toString();
    }


}
