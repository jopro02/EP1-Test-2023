import java.util.Arrays;

public class Project9 {

    public static void main(String[] args) {
        int[] test1 = {3, 0, 6, -1, 1};
        int[][] test2 = {{0}, {6, -5}, {0, 0}, {0, 1, 2, 0}};
        int[][] test3 = {{1, 2, 7, 3, 0}, {-8}, {0, 2}, {1, 4, -2, 1}};

        boolean[][] result1 = create(new int[]{3});
        boolean[][] result2 = create(new int[]{-2, 0});
        boolean[][] result3 = create(new int[]{});

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(result3));
        System.out.println();
        move(test2);
        move(test3);
        System.out.println(Arrays.deepToString(test2));
        System.out.println(Arrays.deepToString(test3));
        System.out.println();
        System.out.println(oddOccurrences("This is not a test!", 's'));
        System.out.println(oddOccurrences("This is not a test!", 'T'));
        System.out.println(oddOccurrences("This is not a test!", 't'));
        System.out.println(oddOccurrences("This is not a test!", ' '));
        System.out.println(oddOccurrences("", 'x'));
    }

    public static boolean[][] create(int[] input) {
        //liefert ein neues Array zurück, in dem alle Zeilen eine Mindestlänge von 3 Einträgen haben
        // und Einträge an in input spezifizierten Positionen true und alle übrigen Einträge false sind.
        // Jede Zeile hat maximal einen Eintrag, der true ist. In input[i] steht für die Zeile mit Index i
        // der Spaltenindex dieses Eintrags. Ist input[i] kleiner 0, hat die Zeile keinen Eintrag true und
        // alle 3 Einträge sind false. Die Zeilen des zurückgelieferten Arrays können länger als 3 sein und zwar dann,
        // wenn input[i] größer als 2 ist. In diesem Fall hat die Zeile die Länge input[i]+1, sodass der letzte Eintrag true ist.

        boolean[][] help = new boolean[input.length][];
        for (int i = 0; i < input.length; i++) {

            if (input[i] < 3) {
                help[i] = new boolean[3];
            } else {
                help[i] = new boolean[input[i] + 1];
            }

            if (input[i] >= 0) {
                help[i][input[i]] = true;
            }
        }

        return help;
        /*
        boolean[][] help;
        for(int k = 0; k < input.length; k++)
        {
            if(input[k] < 0)
            {
                help = new boolean[(input[0] * -1) + 1][];

                for (int i = 0; i < input.length; i++)
                {
                    help[i] = new boolean[(input[0] * - 1) + 1];

                    for(int j = 0; j <= input[i];j++)
                    {
                        help[i][j] = false;
                    }
                }
            }
            else
            {
                help = new boolean[input[0]][];

                for (int i = 0; i < input.length; i++)
                {
                    help[i] = new boolean[input[i]+1];

                    for(int j = 0; j <= input[i];j++)
                    {
                        help[i][j] = false;

                        if(input[i] == j )
                        {
                            help[i][j] = true;
                        }
                    }
                }
            }
            return help;
        }
        */
    }

    public static void move(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i][input[i].length - 1] == 0) {
                for (int j = input[i].length - 1; j > 0; j--) {
                    int temp = input[i][j];
                    input[i][j] = input[i][j - 1];
                    input[i][j - 1] = temp;
                }
            } else {
                int[] newRow = new int[input[i].length + 1];
                for (int j = 1; j < newRow.length; j++) {
                    newRow[j] = input[i][j - 1];
                }
                input[i] = newRow;
            }
        }
    }

    public static boolean oddOccurrences(String s, char ch){

        if (s.length() == 1) {
            return s.charAt(0) == ch;
        }
        if (s.isEmpty()) {
            return false;
        }
        boolean samechar = s.charAt(0) == ch;
        return samechar != oddOccurrences(s.substring(1), ch);
    }
}
