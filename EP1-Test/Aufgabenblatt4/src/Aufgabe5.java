/*
    Aufgabe 5) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe5 {

    private static int[][] genFilledArray(int n) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = i + j;

            }
        }
        return matrix;
    }

    private static int[][] extendArray(int[] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode


        int[][] arr1 = new int[inputArray.length][];


        for(int i = 0; i < inputArray.length; i++)
        {
            arr1[i] = new int[inputArray[i]*2+1];

            for(int j = 0; j < arr1[i].length; j++)
            {
                if(arr1[i].length == 0)
                {
                    arr1[i][j] = 0;
                }
                arr1[i][j] = -1;
                if(j == arr1[i].length/2){
                    arr1[i][j] = inputArray[i];
                }
            }
        }
        return arr1; //Zeile kann geändert oder entfernt werden.
    }

    private static int[] reformatArray(int[][] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode


        return null; //Zeile kann geändert oder entfernt werden.
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                System.out.print(inputArray[i] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] array = genFilledArray(2);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{0, 1}, {1, 2}}));
        System.out.println("-----");

        array = genFilledArray(4);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{0, 1, 2, 3}, {1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}}));
        System.out.println("-----");

        array = genFilledArray(7);
        printArray(array);
        System.out.println("-----");


        int[] array1 = new int[]{4, 0, 5, 2};
        int[][] array1res = extendArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{-1, -1, -1, -1, 4, -1, -1, -1, -1}, {0}, {-1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1}, {-1, -1, 2, -1, -1}}));
        System.out.println("-----");

        array1 = new int[]{0};
        array1res = extendArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{0}}));
        System.out.println("-----");

        array1 = new int[]{0, 1, 2, 1, 0};
        array1res = extendArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{0}, {-1, 1, -1}, {-1, -1, 2, -1, -1}, {-1, 1, -1}, {0}}));
        System.out.println("-----");


        int[][] array2 = new int[][]{{1, 0, 1, 1}, {0, 1, 1}, {0, 1, 0, 1, 1}, {0, 0, 0, 1, 0}, {1, 0}, {1, 1, 1, 1, 1}};
        int[] array2res = reformatArray(array2);
        printArray(array2res);
        assert (Arrays.equals(array2res, new int[]{1, 1, 2, 4, 1, 0}));
        System.out.println("-----");

        array2 = new int[][]{{1, 0, 1, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1}};
        array2res = reformatArray(array2);
        printArray(array2res);
        assert (Arrays.equals(array2res, new int[]{5, 3, 6, 7, 5, 8, 7}));
        System.out.println("-----");
    }
}
