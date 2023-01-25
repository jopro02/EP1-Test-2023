import java.util.Arrays;

public class Project4 {

    private static int[][] rearrange(int[][] inputArray) {

        //erzeugt aus inputArray ein neues zweidimensionales Array und retourniert dieses.
        //Das neue Array hat in jeder Zeile genau 4 Spalten und seine Werte werden zeilenweise
        // mit den Werten aus inputArray befüllt.
        // Dabei werden die Werte immer abwechselnd von links oder rechts beginnend in eine Zeile geschrieben.
        // In der ersten Zeile wird links gestartet.
        // Wenn das neue Array nicht vollständig befüllt werden kann
        // (d.h. wenn die Anzahl der Elemente in inputArray nicht durch 4 teilbar ist),
        // werden die übrigen Array-Einträge auf 0 gesetzt.

        int counter = 0;
        for (int[] ints : inputArray) {
            counter += ints.length;
        }
        if(counter % 16 == 0)
        {
            counter = counter/4;

        }
        else
        {
            counter = counter/4+1;
        }

        int[][] help = new int[counter][4];
        int row = 0;
        int col = 0;

        for (int i = 0; i < inputArray.length; i++)
        {
            for (int j = 0; j < inputArray[i].length; j++)
            {
                if (row == help.length)
                {
                    break;
                }

                help[row][col] = inputArray[i][j];

                if (row % 2 == 0)
                {
                    col++;

                    if (col == 4)
                    {
                        row++;
                        col = 3;
                    }
                } else {
                    col--;

                    if (col < 0)
                    {
                        col = 0;
                        row++;
                    }
                }
            }
        }
        return help;
    }

    public static void label(int[][] inputArray) {
        //setzt alle Werte einer Zeile auf -9, wenn die darauf folgende Zeile dieselbe Länge
        // hat und genau dieselben Werte in derselben Reihenfolge aufweist.

        for (int i = 0; i < inputArray.length - 1; i++) {
            boolean hasSameNextRow = true;
            for (int j = 0; j < inputArray[i].length; j++) {
                if (j >= inputArray[i + 1].length || inputArray[i][j] != inputArray[i + 1][j]) {
                    hasSameNextRow = false;
                }
            }
            if (hasSameNextRow) {
                for (int j = 0; j < inputArray[i].length; j++) {
                    inputArray[i][j] = -9;
                }
            }
        }

}

    public static int findMaxOppositeSum(int[] sequence, int start, int end) {
        //berechnet die Summe jeweils gegenüberliegender Elemente im Array sequence zwischen den
        // Indizes start und end (also die Summe der Elemente an der Stelle start und end, die Summe
        // der Elemente an der Stelle start+1 und end-1 usw.) und gibt deren Maximum zurück.

        if(start >= end)
        {
            return 0;
        }

        int max = sequence[start] + sequence[end];
        int next = findMaxOppositeSum(sequence, start+1, end-1);

        if ( next > max)
        {
            max = next;
        }
        return max;

    }

    public static void main(String[] args) {
        int[][] test1 = {{5, 2, 4}, {8, 5, 4}, {9, 6, 8, 7}};
        int[][] test2 = {{0, 1, 2}, {0, 1, 2}, {0, 1, 2}};
        int[][] test3 = {{6}, {2, 4}, {2, 4}, {2, 4}, {4, 2}};
        int[] seq1 = {4, 3, 2, 1, 10, 5, 5, 5};


        int[][] result1 = rearrange(test1);
        System.out.println(Arrays.deepToString(result1));

        int[][] result2 = rearrange(test3);
        System.out.println(Arrays.deepToString(result2));

        System.out.println(Arrays.deepToString(rearrange(new int[][]{{}})));

        label(test1);
        System.out.println(Arrays.deepToString(test1));

        label(test2);
        System.out.println(Arrays.deepToString(test2));

        System.out.println(findMaxOppositeSum(seq1, 0, 7));
        System.out.println(findMaxOppositeSum(seq1, 0, 5));
        System.out.println(findMaxOppositeSum(seq1, 4, 7));

    }
}
