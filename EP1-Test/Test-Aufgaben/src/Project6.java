import java.util.Arrays;

public class Project6 {
    public static void main(String[] args) {
        int[][] test1 = {{5}, {5, 7, 9}, {8, 5}, {}};
        int[][] test2 = {{1, 2}, {1, 2, 3}, {1, 2, 3, 4}};
        int[][] test3 = {{}, {1, 2, 3, 4}, {1}};
        int[] seq = {1, 2, -5, 3, -1, 6, -3, 3};

        int[][] result1 = getRectangular(test1);
        int[][] result2 = getRectangular(test2);
        int[][] result3 = getRectangular(test3);
        int[][] result4 = getRectangular(new int[][]{{}});

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(result3));
        System.out.println(Arrays.deepToString(result4));

        removeEntry(test2, 2);
        removeEntry(test3, 0);
        System.out.println(Arrays.deepToString(test2));
        System.out.println(Arrays.deepToString(test3));

        System.out.println(isAlternating(seq, 0));
        System.out.println(isAlternating(seq, 1));
        System.out.println(isAlternating(seq, 6));
        System.out.println(isAlternating(seq, 7));

    }

    public static int[][] getRectangular(int[][] input) {
        int maxlen = 0;
        for (int[] row : input) {
            if (row.length > maxlen) {
                maxlen = row.length;
            }
        }
        int[][] help = new int[input.length][maxlen];
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[i].length; j++) {
                if (input[i].length == 0) {
                    help[i][j] = 0;
                } else if (j < input[i].length) {
                    help[i][j] = input[i][j];
                } else {
                    help[i][j] = input[i][j % input[i].length];
                }
            }
        }
        return help;
    }

    public static void removeEntry(int[][] input, int col) {
        for (int i = 0; i < input.length; i++) {
            if (col < input[i].length) {
                int tempCounter = 0;
                int[] temp = new int[input[i].length - 1];
                for (int j = 0; j < input[i].length; j++) {
                    if (j != col) {
                        temp[tempCounter] = input[i][j];
                        tempCounter++;
                    }
                }
                input[i] = temp;
            }
        }
    }

    public static boolean isAlternating(int[] seq, int index) {
        if (index == seq.length - 1) {
            return true;
        }
        boolean current = (seq[index] < 0 && seq[index + 1] > 0) || (seq[index] >= 0 && seq[index + 1] < 0);
        return current && isAlternating(seq, index + 1);
    }

}