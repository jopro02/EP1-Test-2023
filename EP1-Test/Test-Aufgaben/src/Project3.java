import java.util.Arrays;

public class Project3 {

    public static int[][] labelPath(int n, int[][] points)
    {
        //erstellt ein neues quadratisches Array der Länge n und gibt dieses zurück.
        // Jede Zeile in points beschreibt einen Punkt in einem zweidimensionalen Array.
        // Die Spalte 0 steht dabei immer für den Zeilenindex und die Spalte 1 für den Spaltenindex eines Punktes.
        // Das Rückgabearray enthält an jedem Punkt in points den Wert -1.
        // An allen anderen Punkten enthält das Rückgabearray den Wert n.

        int[][] help = new int[n][n];
        int x;
        int y;

        for (int i  =  0; i < help.length; i++){
            for (int j = 0; j < help[i].length; j++){
                help[i][j] = n;
            }
        }

        for(int i = 0; i < points.length; i++) { //zeile
            for (int j = 0; j < points[i].length; j++) { //spalte

                y = points[i][0];
                x = points[i][1];

                help[i][j] = n;
                help[y][x] = -1;
            }
        }
        return help;
    }

    public static void findMatches(int[][] data, int[] pattern, int[] target)
    {
        //bestimmt für jede Zeile i in data, wie oft die Folge der Werte in pattern vorkommt.
        // Die jeweilige Anzahl wird in target am Index i abgelegt.

        int counter;

        for(int i = 0; i < data.length ; i++)
        {
            counter = 0;

            for(int j = 0; j < data[i].length -1; j++)
            {
                boolean hasPattern = true;

                for (int k = 0; k < pattern.length && hasPattern; k++)
                {
                    if (data[i][j+k] != pattern[k])
                    {
                        hasPattern = false;
                    }
                }
                if (hasPattern)
                {
                    counter++;
                }
            }
            target[i] = counter;
        }
    }

    public static String insertMiddle(String input, String seps) {

        //fügt Zeichen aus seps in input ein. In der Mitte der Rückgabebe findet sich das erste Zeichen von seps.
        // In der Mitte beider Hälften befindet sich dann das zweite Zeichen von seps, usw.
        // Diese Vorgehensweise wird wiederholt, solange noch Zeichen zu vergeben sind und
        // input in kleinere Teile geteilt werden kann. Ansonsten wird input zurückgegeben.
        // Falls die Mitte nicht eindeutig bestimmt ist, wird so geteilt, dass die linke Hälfte die kürzere ist.
        // Die Buchstaben aus seps werden bei der Bestimmung der Mitte nicht einbezogen.

        if (input.isEmpty() || seps.isEmpty() || input.length() == 1)
        {
            return input;
        }

        String firstHalf = input.substring(0,input.length()/2);
        String secondHalf = input.substring(input.length()/2);

        return insertMiddle(firstHalf, seps.substring(1)) + seps.substring(0,1) + insertMiddle(secondHalf, seps.substring(1));

    }

    public static void main(String[] args) {
        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
        int[] target1 = {0, 0, 0};
        int[] target2 = {9, 9, 9, 9};

        System.out.println(Arrays.deepToString(labelPath(3, new int[][]{})));
        System.out.println(Arrays.deepToString(labelPath(4, data0)));


        findMatches(data0, data0[1], target1);
        System.out.println(Arrays.toString(target1));

        findMatches(data1, data0[1], target1);
        System.out.println(Arrays.toString(target1));

        findMatches(data1, data0[2], target2);
        System.out.println(Arrays.toString(target2));


        System.out.println(insertMiddle("XY", "abc"));


        System.out.println(insertMiddle("01234", "abc"));


        System.out.println(insertMiddle("01234567890123", "./-"));

    }
}
