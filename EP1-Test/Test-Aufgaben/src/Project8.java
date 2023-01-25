import java.util.Arrays;

public class Project8 {

    public static void main(String[] args) {
        int[][] test1 = {{1}, {1, 2, 3}, {1, 2, 3, 4}, {1, 2}};
        int[][] test2 = {{1, 2, 3}, {0}, {1, 2}, {0}, {1}};
        int[] seq = {2, 8, 8, 5, 2, 5, 7, 3};


        //method 1
        int[][] result1 = repeat(test1, new int[]{1, -2, 1, 0});
        System.out.println(Arrays.deepToString(result1));

        int[][] result2 = repeat(test2, new int[]{1, 0, -3, 2, 0});
        System.out.println(Arrays.deepToString(result2));

        //method 2
        rasp(test1);
        System.out.println(Arrays.deepToString(test1));

        rasp(test2);
        System.out.println(Arrays.deepToString(test2));

        //method3
        System.out.println(hasNOrderedPairs(seq, 4, 0));
        System.out.println(hasNOrderedPairs(seq, 2, 2));
        System.out.println(hasNOrderedPairs(seq, 1, 3));
        System.out.println(hasNOrderedPairs(seq, 3, 3));
        System.out.println(hasNOrderedPairs(seq, 0, 6));

    }

    public static int[][] repeat(int[][] input, int[] reps) {

        //liefert ein neues Array mit derselben Zeilenanzahl wie input zurück.
        // Jede Zeile des neuen Arrays besteht aus den Einträgen der ursprünglichen Zeile in input
        // und aus Wiederholungen dieser Zeile, wobei die Anzahl der Wiederholungen durch den
        // jeweiligen Eintrag in reps bestimmt wird. Ein Eintrag von 0 in reps bedeutet,
        // dass die Zeile nicht wiederholt wird und somit nur einmal elementweise in das neue Array kopiert wird.
        // Bei einem negativen Eintrag in reps wird die Zeile rückwärts kopiert und auch rückwärts wiederholt,
        // und zwar so oft, wie es dem Absolutbetrag des negativen Eintrags entspricht.


        int[][] help = new int[input.length][];

        for (int i = 0; i < input.length; i++) {
            int rep;
            if (reps[i] >= 0) {
                rep = reps[i];
            } else {
                rep = reps[i] * -1;
            }
            int count = (rep + 1) * input[i].length;
            if (count >= 0) {
                count = count;
            } else {
                count = count * -1;
            }
            help[i] = new int[count];

            for (int j = 0; j < help[i].length; j++) {
                int rowlen = input[i].length;
                int current;
                if (reps[i] >= 0) {
                    current = j % rowlen;
                } else {
                    current = rowlen - 1 - j % rowlen;
                }
                help[i][j] = input[i][current];
            }
        }

        return help;
    }
    public static void rasp(int[][] input) {
        for (int i = 0; i < input.length - 1; i++) {

            int last = input[i][input[i].length - 1];
            int[] temp = new int[input[i].length - 1];

            for (int j = 0; j < temp.length; j++) {
                temp[j] = input[i][j];
            }

            input[i] = temp;
            i++;
            temp = new int[input[i].length + 1];

            for (int j = 0; j < input[i].length; j++) {
                temp[j] = input[i][j];
            }

            temp[input[i].length] = last;
            input[i] = temp;
        }
    }

    public static boolean hasNOrderedPairs(int[] seq, int n, int index) {

        //überprüft, ob in seq genau n Paare von direkt aufeinander folgenden Einträgen vorkommen, die richtig geordnet sind.
        // Ein Paar gilt jeweils als richtig geordnet, wenn der erste Eintrag kleiner gleich dem zweiten Eintrag ist.
        // Die Paare im Array dürfen sich auch überlappen
        // (z.B. enthält das Array {1, 2, 3} zwei geordnete Paare, weil 1 <= 2 und 2 <= 3 ist). Die Zählung beginnt bei index (inklusive)

        if (index == seq.length - 1) {
            return n == 0;
        }
        if (seq[index] <= seq[index + 1]) {
            n--;
        }
        return hasNOrderedPairs(seq, n, index + 1);
    }

}
