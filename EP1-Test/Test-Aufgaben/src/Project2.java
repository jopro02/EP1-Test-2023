import java.util.Arrays;

public class Project2 {

    public static void main(String[] args) {

        int[][] test1 = { {1, 2, 0, -1, -2, 3}, {-1, 2, 3}, {0, 0}, {}, {4, 5, -1} };
        int[][] test2 = { {1, 2, 3}, {4, 5, 2}, {-2, -3, 2, -1}, {3, 2, 1, 5}, {4, 5, 1, 4} };
        int[][] test3 = { {1, -1, 2, -2, 3}, {1, 2, 3}, {-3, -1, -2} };
        char[] age1 = {'d', 'u', '-', 'd', 'u', '-', 'd', 'a', '-', 'd', 'a'};
        char[] age2 = {'m', 'a', 'm', 'a', '!', 'n', 'e', 'i', 'n'};


        int[][] result1 = generate(test1);
        System.out.println(Arrays.deepToString(result1));

        int[][] result2 = generate(test2);
        System.out.println(Arrays.deepToString(result2));


        fill(test1, test2[3], test2[4]);
        fill(result1, test2[2], test2[4]);
        fill(test3, test2[2], test2[3]);

        System.out.println(Arrays.deepToString(test1));
        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(test3));

        System.out.println(extractString(age1, 0, age1.length, '-'));
        System.out.println(extractString(age1, 1, 7, 'u'));

        System.out.println(extractString(age2, 0, 5, 'a'));
        System.out.println(extractString(age2, 5, age2.length, 'n'));

    }


    private static int[][] generate(int[][] input) {
        //gibt ein neues Array zurück, welches dieselbe Struktur wie input besitzt.
        // Jede Zeile der Kopie enthält zuerst alle negativen Einträge der entsprechenden Zeile in input,
        // und anschließend alle positiven Werte (inkl. 0). Die Reihenfolge innerhalb der negativen
        // und positiven Werte wird nicht verändert.

        int[][] help = new int[input.length][];

        for(int i = 0; i < input.length; i++) {

            help[i] = new int[input[i].length];
            int counter = 0;

            for (int j = 0; j < input[i].length;j++) {
                if (input[i][j] < 0) {
                    help[i][counter++] = input[i][j];
                }
            }

            for (int j = 0; j < input[i].length;j++) {
                if (input[i][j] >= 0) {
                    help[i][counter++] = input[i][j];
                }
            }
        }
        return help;
    }

    private static void fill(int[][] target, int[] values, int[] times) {
        //überschreibt die Werte in target zeilenweise mit den Werten in values, wobei times angibt,
        // wie oft jeder Wert in values wiederholt werden soll, bevor der nächste verwendet wird.
        // Die Arrays values und times dürfen dabei nicht verändert werden.

        int index = 0;
        int valueIndex = 0;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length; j++) {
                if (index == times[valueIndex]) {
                    valueIndex++;
                    index = 0;
                }
                target[i][j] = values[valueIndex];
                index++;
            }
        }
    }


    private static String extractString(char[] sequence, int start, int end, char omit) {

        //liefert einen String bestehend aus den Zeichen in sequence zwischen den Indizes start (inklusive) und end (exklusive) zurück,
        // wobei alle Vorkommen des Zeichens omit ausgelassen werden.
        //Diese Methode muss rekursiv implementiert werden.
        // Es dürfen keine Methoden der Klasse String verwendet werden, Operatoren sind aber erlaubt!
        if (start >= end) {
            return "";
        }
        if (sequence[start] == omit) {
            return extractString(sequence, start + 1, end, omit);
        }
        return sequence[start] + extractString(sequence, start + 1, end, omit);
    }
}
