/*
    Aufgabe 5) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe5 {

    private static int[][] genFilledArray(int n) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[][] arrayA = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayA[i][j] = i + j; //schrittweise Addition um "Muster" zu erzeugen
            }
        }

        return arrayA; //Zeile kann geändert oder entfernt werden.
    }

    private static int[][] extendArray(int[] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[][] arrayB = new int[inputArray.length][]; // zweite Dimension bleibt noch offen und wird erst in SChleife mit entsprechender Länge initalisiert

        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = new int[inputArray[i] * 2 + 1]; // bestimmt die Länge der Zeilen
        }

        for (int i = 0; i < arrayB.length; i++) { // für jede Zeile des Arrays...
            for (int j = 0; j < inputArray[i]; j++) { //... wird in der Zeile bis zum Input = Index raufgezählt
                arrayB[i][j] = -1; // mit -1 befüllt
                arrayB[i][j + 1] = inputArray[i]; // eine Position danach mit dem Input befüllt
            }
            for (int j = inputArray[i] + 1; j < arrayB[i].length; j++) { // ab einer Position nach dem Input bis zum Ende
                arrayB[i][j] = -1; // wieder mit -1 befüllen
            }

        }

        return arrayB; //Zeile kann geändert oder entfernt werden.
    }

    private static int[] reformatArray(int[][] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int [] arrayC = new int [inputArray.length];

        for (int i = 0; i < inputArray.length; i++){
            int counter0 = 0; // wird jede Zeile zurückgesetzt auf 0
            for (int j = 0; j < inputArray[i].length; j++){
                if(inputArray[i][j] == 0){
                    counter0++;
                }
            }
            arrayC[i] = counter0; // an jeder Position wird Counter0 gespeichert
        }

        return arrayC; //Zeile kann geändert oder entfernt werden.
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
        // assert (Arrays.deepEquals(array1res, new int[][]{{-1, -1, -1, -1, 4, -1, -1, -1, -1}, {0}, {-1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1}, {-1, -1, 2, -1, -1}}));
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
