import java.util.Arrays;

public class Project5 {


    public static void main(String[] args) {
        int[][] test1 = {{0, 2, 4}, {2, 0, 0}, {0, 0, 1}};
        int[][] test2 = {{1, 2, 3}, {1, 2, 3, 4, 5}, {1, 2, 3}, {1, 2, 3, 4, 5}};
        int[][] test3 = {{2}, {0, 7}, {6, 7, 8}, {6, 0}, {0, 0}};
        String seq1 = "ABA";

        int[][] result1 = removeLeadingZeros(test1);
        System.out.println(Arrays.deepToString(result1));

        int[][] result2 = removeLeadingZeros(test3);
        System.out.println(Arrays.deepToString(result2));

        mask(test2,new int[]{1,2,3},new int[]{0,1,4});
        System.out.println(Arrays.deepToString(test2));

        mask(test3,new int[]{0,2,4},new int[]{0,1});
        System.out.println(Arrays.deepToString(test3));

        mask(test1,new int[]{},new int[]{0,1});
        System.out.println(Arrays.deepToString(test1));

        System.out.println(replicateCharacters(seq1, "010"));

        System.out.println(replicateCharacters("SAMBA", "10001"));

    }

    private static int[][] removeLeadingZeros(int[][] inputArray) {

        //erzeugt aus inputArray ein neues zweidimensionales Array und retour- niert dieses.
        // Das neue Array übernimmt jede Zeile aus dem inputArray und entfernt führende Nullen.

        int[][] help = new int[inputArray.length][];

        for (int i = 0; i < inputArray.length; i++) {

            int startIndex = 0;
            boolean hasNonZero = false;

            for (int j = 0; j < inputArray[i].length && !hasNonZero; j++) {
                if (inputArray[i][j] != 0 && startIndex == 0) {
                    hasNonZero = true;
                } else if (inputArray[i][j] == 0) {
                    startIndex++;
                }
            }

            help[i] = new int[inputArray[i].length - startIndex];

            for (int j = startIndex; j < inputArray[i].length; j++) {
                if (inputArray[i][j] != 0) {
                    help[i][j - startIndex] = inputArray[i][j];
                }
            }
        }
        return help;
    }

    public static void mask(int[][] inputArray, int[] rows, int[] cols) {
        //setzt alle Werte in inputArray auf 0, wenn deren Zeilenindex in rows und deren Spaltenindex in cols vorkommt.

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {

                if (rows[i] < inputArray.length ) {
                    if(cols[j] < inputArray[rows[i]].length)
                    {
                        inputArray[rows[i]][cols[j]] = 0;
                    }
                }
            }
        }
    }

    public static String replicateCharacters(String sequence, String repSequence) {

        //gibt einen neuen String zurück, bei dem das i-te Zeichen im String sequence zusätzlich wiederholt wird,
        // wenn der i-te Eintrag im String repSequence eine 1 ist.

        if (sequence.isEmpty()) {
            return "";
        }
        String help = sequence.charAt(0) + "";
        if (repSequence.charAt(0) == '1') {
            help += sequence.charAt(0);
        }
        return help + replicateCharacters(sequence.substring(1), repSequence.substring(1));
    }
}
