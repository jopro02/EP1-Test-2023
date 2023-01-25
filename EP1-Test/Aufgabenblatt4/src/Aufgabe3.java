/*
    Aufgabe 3) Eindimensionale Arrays und Methoden
*/

import java.util.Arrays;

public class Aufgabe3 {

    private static int[] genRandomArray(int length, int maxNumber) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        //Vorbedingungen: length > 0 und maxNumber > 0.

        int[] array = new int[length];//Größe des Arrays

        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int)(Math.random()*maxNumber - 1); // [0, maxNumber[  deshalb -1
        }
        return array;

    }

    private static void replaceValues(int[] workArray, int idx) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        //Vorbedingungen: workArray != null, workArray.length > 0 und idx ≥ 0.

        int average = 0;

        for(int i = 0; i <= workArray.length-1; i++)
        {
            average = average + workArray[i];

        }
        average = average / workArray.length;

        for (int i = idx; i < workArray.length; i++) { //i = idx weil erst ab dem idx soll geschaut werden ob die Zahl größer ist als der Mittelwert

            if (workArray[i] > average) // wenn der Wert an der Stelle i größer ist als der Mittelwert
            {
                workArray[i] = average; //dann wird dieser mit dem Mittwlwert ersetzt
            }

        }

    }

    public static void main(String[] args) {
        int[] array1 = genRandomArray(20, 50);
        System.out.println(Arrays.toString(array1));
        System.out.println();

        int[] array2 = new int[]{12, 3, 15, 18, 22, 9, 5, 8, 16, 21};
        replaceValues(array2, 4);
        System.out.println(Arrays.toString(array2));
        assert (Arrays.equals(array2, new int[]{12, 3, 15, 18, 12, 9, 5, 8, 12, 12}));

        int[] array3 = new int[]{21, 14, 17, 12};
        replaceValues(array3, 0);
        System.out.println(Arrays.toString(array3));
        assert (Arrays.equals(array3, new int[]{16, 14, 16, 12}));

        int[] array4 = new int[]{3, 4, 6, 7};
        replaceValues(array4, 2);
        System.out.println(Arrays.toString(array4));
        assert (Arrays.equals(array4, new int[]{3, 4, 5, 5}));

        int[] array5 = new int[]{7, 7};
        replaceValues(array5, 1);
        System.out.println(Arrays.toString(array5));
        assert (Arrays.equals(array5, new int[]{7, 7}));

        int[] array6 = new int[]{3, 2, 1};
        replaceValues(array6, 2);
        System.out.println(Arrays.toString(array6));
        assert (Arrays.equals(array6, new int[]{3, 2, 1}));
        System.out.println();
    }
}
