import java.sql.Array;
import java.util.Arrays;

public class Project1 {

    private static int[][] generate(int[][] input) {

        //erzeugt aus input ein neues zweidimensionales Array und retourniert dieses.
        // Dabei werden die einzelnen Zeilen von input kopiert, aber von der zweiten Zeile weg immer ein Element weniger.
        // Bei der letzten Zeile wird daher nur mehr das erste Element kopiert.
        // Danach werden die Zeilen (außer die letzte) in umgekehrter Reihenfolge mit ansteigender Größe
        // (zwei Elemente von der vorletzten Zeile, drei Elemente von der vorvorletzten Zeile usw.) kopiert.
        // Zuletzt wird daher wieder die erste Zeile mit allen Elementen kopiert.

        int[][] help = new int[2 * input.length - 1][]; //5 Zeilen

        for(int i = 0; i < input.length; i++) {

            //help[i] = input[i]; //falsch -> wäre referenz
            help[i] = new int[input[i].length-i];
            help[help.length - 1 - i] = new int[input[i].length-i];

            for (int j = 0; j < help[i].length;j++) {

                help[i][j] = input[i][j];
                help[help.length - 1 - i][j] = input[i][j];
            }
        }

        return help;
    }

    private static void reorder(int[][] input){

        //dreht den Inhalt aller Arrayeinträge innerhalb jeder Zeile von input um.
        // Vorbedingung(en): input.length > 0, input[i].length > 0 für alle gültigen i.

        for(int i = 0; i < input.length; i++) {

            for (int j = 0; j < input[i].length / 2; j++) {

                int temp = input[i][j];
                input[i][j] = input[i][input[i].length-1-j];
                input[i][input[i].length-1-j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test1 = { {5, 2, 4}, {2, 7, 3}, {9, 5, 8} };
        int[][] test2 = { {1} };
        int[][] test3 = { {6, 7, 8}, {7, 5, 3, 1}, {2} };
        String seq1 = "ABBAACBA";

        int[][] result1 = generate(test1);
        System.out.println(Arrays.deepToString(result1)); //deepToString bei zweidimensionalen Arrays -> ToString -> eindimensionales Array

        int[][] result2 = generate(test2);
        System.out.println(Arrays.deepToString(result2));

        reorder(result1);
        System.out.println(Arrays.deepToString(result1));

        reorder(result2);
        System.out.println(Arrays.deepToString(result2));

        reorder(test3);
        System.out.println(Arrays.deepToString(test3));


        System.out.println(isPresentNTimes(seq1, 'A', 4));

        System.out.println(isPresentNTimes(seq1, 'A', 3));

        System.out.println(isPresentNTimes(seq1, 'A', 5));

        System.out.println(isPresentNTimes(seq1, 'Z', 0));

    }

    private static boolean isPresentNTimes(String sequence, char marker, int count) {

        //boolean isPresentNTimes(String sequence, char marker, int count) gibt true zurück,
        // wenn das Zeichen marker genau count-Mal im String sequence vorkommt.
        // Ansonsten wird false retourniert.

        if (sequence.length() == 0) {
            return count == 0;
        } else {
            if (sequence.charAt(0) == marker) {

                return isPresentNTimes(sequence.substring(1), marker, count - 1);

            } else {
                return isPresentNTimes(sequence.substring(1), marker, count);
            }
        }
    }
}
