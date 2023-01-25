public class ProgrammiertestOld {

    //METHODS FOR PRINTING ARRAYS - NOT TO BE INCLUDED IN EVALUATION
//---------------------------------------------------------------//
    public static void print(int[][] arr) {
        if (arr != null)
            for (int i = 0; i < arr.length; i++) {
                System.out.println();
                if (arr[i] != null)
                    for (int j = 0; j < arr[i].length; j++)
                        System.out.print(arr[i][j] + " ");
            }
        System.out.println("\n");
    }

    public static void print(int[] arr) {
        if (arr != null)
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
        System.out.println("\n");
    }
//---------------------------------------------------------------//


    //TODO: Schreiben Sie hier die geforderten Methoden.

    public static int[][] getRectangular(int[][] input) {
        //get max
        int max = 0;
        for (int i = 0; i < input.length; i++)
            if(input[i].length > max)
                max = input[i].length;
        int[][] arr = new int[input.length][max];
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < max; j++)
                if(input[i].length != 0)
                    arr[i][j] = input[i][j % (input[i].length)];
        return arr;
    }

    public static void removeEntry(int[][] input, int col) {
        for (int i = 0; i < input.length; i++) {
            if(col <= input[i].length - 1 && input[i].length > 0) {
                int[] temp = new int[input[i].length - 1];
                int index = 0;
                for (int j = 0; j < temp.length; j++) {
                    if(index != col) {
                        temp[j] = input[i][index++];
                    } else {
                        temp[j] = input[i][++index];
                        index++;
                    }
                }
                input[i] = temp;
            }
        }
    }

    public static boolean isAlternating(int[] seq, int index) {
        if(index == seq.length - 1)
            return true;
        if(seq[index] < 0 && seq[index + 1] < 0)
            return false;
        if(seq[index] > 0 && seq[index + 1] > 0)
            return false;
        return isAlternating(seq, index + 1);
    }


    public static void main(String[] args) {
        //TODO: Erweitern Sie "main" laut Angabe.
        int[][] test1 = {{5}, {5, 7, 9}, {8, 5}, {}};
        int[][] test2 = {{1, 2}, {1, 2, 3}, {1, 2, 3, 4}};
        int[][] test3 = {{}, {1, 2, 3, 4}, {1}};
        int[] seq = {1, 2, -5, 3, -1, 6, -3, 3};

        int[][] result1 = getRectangular(test1);
        int[][] result2 = getRectangular(test2);
        int[][] result3 = getRectangular(test3);
        int[][] result4 = getRectangular(new int[][]{{}});

        System.out.println("Testing getRectangular():");
        print(result1);
        print(result2);
        print(result3);
        print(result4);

        System.out.println("Testing removeEntry():");
        removeEntry(test2, 2);
        removeEntry(test3, 0);
        print(test2);
        print(test3);

        System.out.println("Testing isAlternating():");
        System.out.println(isAlternating(seq, 0) );
        System.out.println(isAlternating(seq, 1) );
        System.out.println(isAlternating(seq, 6) );
        System.out.println(isAlternating(seq, 7) );
    }

}



