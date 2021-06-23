package ru.geekbrains.lesson_2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ClassLesson_2 {

    public static void main(String args[]){
        // Задание 1
        System.out.println("Результат задания 1");
        replacementArray();

        //задание 2
        System.out.println("Результат задания 2");
        fillEmptyArray();

        //Задание 3
        System.out.println("Результат задания 3");
        multiplicationInAnArray();

        //Задание 4
        System.out.println("Результат задания 4");
        diagonalInAnArray();

        //Задание 5
        System.out.println("Результат задания 5");
        minMsxElementsInAnArray();

        //Задание 6
        System.out.println("Результат задания 6");
        int [] arr1 =  {2,2,2,10,2,2,1,1};
        System.out.println(checkBalance(arr1));

        //Задание 7
        System.out.println("Результат задания 7");
        int[] arr = {1,2,3,4};
        int n = -1;
        BiasArray(arr, n);
    }

    public static void replacementArray(){
        int [] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i= 0; i<= arr.length-1; i++){
            if (arr[i]==0){
                arr[i]=1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillEmptyArray(){
        int[] arr  = new int[8];
       for (int i=0; i<= arr.length-1; i++){
           arr[i] = i*3;
       }
       System.out.println(Arrays.toString(arr));
    }

    public static void multiplicationInAnArray(){
        int[] arr  = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i=0; i<= arr.length-1; i++){
            if (arr[i]<=6) arr[i] = arr[i]*2;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void diagonalInAnArray(){
        int[][] arr  =new int [3][3];
        for (int i=0; i<= arr.length-1; i++){
            for (int j=0; j<= arr[i].length-1; j++){
                if (i==j) arr[i][j]= 1;
            }
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    public static void minMsxElementsInAnArray(){
        int [] arr = {5,8,2,3,1,4};
        // это первое что пришло в голову
        int minElements = arr[0];
        int maxElements = 0;
        for (int i= 0; i<= arr.length-1; i++){
           if (arr[i]>maxElements){maxElements = arr[i];}
           if (arr[i]<minElements) {minElements = arr[i];}

        }

        System.out.println("Минимальный элемент: " +minElements);
        System.out.println("Максимальный элемент: " +maxElements);

        System.out.println();
        // а это после того как почитала методы после точки
        System.out.println(Arrays.stream(arr).max());
        System.out.println(Arrays.stream(arr).min());
    }

    public static boolean checkBalance(int [] arr){

        boolean result = false;
        int checkSum = 0;

        int sum = 0;
        for (int i= 0; i<= arr.length-1; i++){

            sum = sum+arr[i];

        }
        if (sum % 2==0){
            for (int i= 0; i<= arr.length-1; i++){
                if (checkSum==sum/2){
                    result=true;
                }
                checkSum = checkSum+arr[i];
            }
        }
        return result;
    }

    public static void BiasArray(int [] arr, int n){

        int Element =0;
        int nextElement=0;
        int currentElement=0;

        if (n>0) {
            for (int j = 1; j <= n; j++) {
                for (int i = 0; i <= arr.length - 1; i++) {
                    if (i == 0) {
                        currentElement = arr[i + 1];
                        arr[i + 1] = arr[i];
                    } else if (i == arr.length - 1) {
                        arr[0] = nextElement;
                    } else {
                        nextElement = arr[i + 1];
                        arr[i + 1] = currentElement;
                        currentElement = nextElement;
                    }


                }

            }
        }
            if (n < 0) {
                for (int j = n; j < 0; j++) {
                    for (int i = arr.length - 1; i > 0; i--) {
                        if (i == 0) {
                            arr[i] = currentElement;
                        } else if (i == arr.length - 1) {
                            currentElement = arr[i];
                            arr[i] = arr[0];
                        } else {
                            nextElement = arr[i-1];
                            arr[i-1] = currentElement;
                            currentElement = nextElement;
                        }


                    }
                }
            }

        System.out.println(Arrays.toString(arr));
    }
}

