/*
    Aufgabe 1) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static void shiftLines(int[][] workArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        // die Zeile mit dem kleinsten Element an der letzten Stelle finden:
        int minRow = 0; //Variable minRow wird mit dem Wert 0 initialisiert
        for (int i = 0; i < workArray.length; i++) { // forschleife gestartet, die ein 2-dimensionales array iteriert
            if (workArray[minRow][workArray[minRow].length - 1] >
                    workArray[i][workArray[i].length - 1] ||
                    (workArray[minRow][workArray[minRow].length - 1] ==
                            workArray[i][workArray[i].length - 1] &&
                            workArray[minRow].length > workArray[i].length))  {
                //Das if-Statement vergleicht das letzte Element der Zeile mit dem bisherigen kleinsten Element an der letzten Stelle
                // mit dem letzten Element der aktuellen Zeile
                // Wenn das letzte Element der aktuellen Zeile kleiner ist oder
                // wenn das letzte Element der aktuellen Zeile gleich dem letzten Element der Zeile mit dem bisherigen kleinsten Element
                // an der letzten Stelle ist && die aktuelle Zeile kürzer ist, dann wird die Bedingung als wahr evaluiert

                minRow = i;
            }
        }
        // die Zeile mit dem kleinsten Element an der letzten Stelle an den Anfang verschieben
        int[] temp = workArray[minRow];
        workArray[minRow] = workArray[0];
        workArray[0] = temp;
    }

    private static void addEntries(int[][] workArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        for (int i = 0; i < workArray.length; i++) {

            int maximum = workArray[i][0];

            for (int j = 1; j < workArray[i].length; j++) {

                //speichert hier den größeren der beiden Werte zwischen maximum und workArray[i][j]
                maximum = Math.max(maximum, workArray[i][j]);
                //bsp: maximum = 5 und workArray[i][j] = 10 --> dann wird maximum auf 10 gesetzt
            }

            // Erstellt ein temporäres Hilfsarray und füllt es mit den Werten aus der
            // aktuellen Zeile und den Rest mit max
            int[] temp = new int[workArray[i].length + maximum];// die Größe des Arrays = workArray[i].length + maximum
            //temp array ist um maxiumum elemente länger als workarray

            //Schleife gestartet: alle Elemente des Arrays temp werden durchlaufen.
            for (int j = 0; j < temp.length; j++) {

                // Wenn der aktuelle Index j kleiner als die Länge von workArray[i] ist, wird das Element an dieser
                // Stelle in temp mit dem entsprechenden Wert in workArray[i] gefüllt
                if (j < workArray[i].length) {
                    temp[j] = workArray[i][j];
                } else {
                    temp[j] = maximum;
                }
            }
            // Überschreibt die aktuelle Zeile im originalen Array mit dem Hilfsarray
            workArray[i] = temp;
        }
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

    public static void main(String[] args) {

        System.out.println("Test shiftLines:");
        int[][] array1 = new int[][]{{1, 3, 2}, {6, 2, 5}, {0, 7, 9}};
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{1, 3, 2}, {6, 2, 5}, {0, 7, 9}}));
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{1, 5, 6, 7}, {1, 9, 6}, {4, 3}, {6, 3, 0, 6, 9}, {6, 4, 3}};
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4, 3}, {1, 9, 6}, {1, 5, 6, 7}, {6, 3, 0, 6, 9}, {6, 4, 3}}));
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{7, 3, 6}, {5}, {9, 1}, {3, 2, 4, 1}, {0}};
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{0}, {5}, {9, 1}, {3, 2, 4, 1}, {7, 3, 6}}));
        printArray(array1);
        System.out.println("-----");

        System.out.println("Test addEntries:");
        int[][] array2 = {{1}, {1, 2}, {1, 2, 3}};
        addEntries(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3, 3, 3}}));
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{3, 4, 2}, {1, 3, 2}, {5, 0, 1}};
        addEntries(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{3, 4, 2, 4, 4, 4, 4}, {1, 3, 2, 3, 3, 3}, {5, 0, 1, 5, 5, 5, 5, 5}}));
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{1, 2}, {1, 2, 4, 3}, {6}, {1, 2, 5, 3, 4}, {1}, {3}};
        addEntries(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{1, 2, 2, 2}, {1, 2, 4, 3, 4, 4, 4, 4}, {6, 6, 6, 6, 6, 6, 6}, {1, 2, 5, 3, 4, 5, 5, 5, 5, 5}, {1, 1}, {3, 3, 3, 3}}));
        printArray(array2);
    }
}

