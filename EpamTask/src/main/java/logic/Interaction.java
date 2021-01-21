package logic;

import entity.ArrayObj;

public class Interaction {
    public  int min (ArrayObj arr){
        int minValue = arr.getArr()[0];
        for (int elem : arr.getArr()){
            if (elem < minValue){
                minValue = elem;
            }
        }
        return minValue;
    }

    public  int max (ArrayObj arr){
        int maxValue = arr.getArr()[0];
        for (int elem : arr.getArr()){
            if (elem > maxValue){
                maxValue = elem;
            }
        }
        return maxValue;
    }

    public  int[] replacement (ArrayObj arr, int position, int number){
        arr.getArr()[position] = number;
        return arr.getArr();
    }

    public  float average (ArrayObj arr){
        return (float)sum(arr)/arr.getArr().length;
    }

    public  int sum (ArrayObj arr){
        int sumValue = 0;
        for (int elem : arr.getArr()){
            sumValue += elem;
        }
        return sumValue;
    }

    public  int positiveCount(ArrayObj arr) {
        int count = 0;
        for (int elem : arr.getArr()){
            if (elem >= 0){
                count++;
            }
        }
        return count;
    }

    public  int negativeCount(ArrayObj arr) {
        int count = 0;
        for (int elem : arr.getArr()){
            if (elem < 0){
                count++;
            }
        }
        return count;
    }
}
