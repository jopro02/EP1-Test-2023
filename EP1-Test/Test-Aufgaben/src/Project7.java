import java.util.Arrays;

public class Project7 {

    public static void main(String[] args) {
        int[][] test1 = {{5, 7, 5, 7}, {5}, {0, 1, 1, 0}};
        int[][] test2 = {{5, 7, 9}, {5}, {8, 5}, {2}, {3}};
        int[][] test3 = {{1, 2}, {1, 2, 3}, {}};
        String seq = "1(234)67";

        int[][] result1 = addTriangle(test1);
        System.out.println(Arrays.deepToString(result1));

        int[][] result2 = addTriangle(test2);
        System.out.println(Arrays.deepToString(result2));

        reverseBetween(test1, 2, 1);
        System.out.println(Arrays.deepToString(test1));

        reverseBetween(test2, 1, 4);
        System.out.println(Arrays.deepToString(test2));

        reverseBetween(test3, 2, 2);
        System.out.println(Arrays.deepToString(test3));

        reverseBetween(test3, 0, 2);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(clean(seq));
        System.out.println(clean("123(45))"));
        System.out.println(clean("x)"));
        System.out.println(clean(")x("));

    }

    public static int[][] addTriangle(int[][] input){

        //liefert ein neues Array zurück, das aus einer Kopie der Zeilen von input besteht.
        //Zusätzlich enthält das neue Array oben n Zeilen, wobei n der Länge der obersten Zeile von input entspricht.
        // Die oberste Zeile des neuen Arrays hat die Länge 1 mit Eintrag 1, die zweite Zeile die Länge 2 mit Einträgen von 2 usw.,
        // bis die Zeile der Länge n erreicht wird. Danach werden die Zeilen von input elementweise kopiert und unten eingefügt.

        int n = 0;

        for(int k = 0; k < input[0].length;k++)
        {
            n++;
        }

        int[][] help = new int[n+input.length][];
        int counter = 1;

        for(int j = 0; j < counter; j++)
        {
            help[j] = new int[counter];

            for(int l = 0; l < counter; l++)
            {
                help[j][l] = counter;
            }
            if(counter == n)
            {
                break;
            }
            counter++;
        }

        int c = 0;
        for(int i = counter; i < help.length ;i++)
        {
            help[i] = new int[input[c].length];

            for(int m = 0; m < input[c].length;m++)
            {
                help[i][m] = input[c][m];
            }
            c++;
        }

        return help;
    }

    public static void reverseBetween(int[][] input, int ind1, int ind2) {
        //dreht die Reihenfolge der Zeilen in input von dem Zeilenindex ind1 bis ind2 (jeweils inklusive) um.

        if (ind1 > ind2) {
            int temp = ind2;
            ind2 = ind1;
            ind1 = temp;
        }
        while (ind1 < ind2) {
            int[] temp = input[ind1];
            input[ind1] = input[ind2];
            input[ind2] = temp;
            ind1++;
            ind2--;
        }
    }

    public static String clean(String seq) {

        //gibt einen neuen String zurück, der nur den Substring innerhalb der äußersten geschlossenen Klammer von seq enthält.
        // Die Klammerzeichen '(' und ')' der äußersten geschlossenen Klammer werden dabei entfernt.
        // Kommt in seq kein '(' vor einem ')' vor, wird ein leerer String zurückgeliefert.

        if (seq.isEmpty()) {
            return "";
        }
        if (seq.charAt(0) == '(') {
            if (seq.charAt(seq.length() - 1) == ')') {
                return seq.substring(1, seq.length() - 1);
            } else {
                return clean(seq.substring(0, seq.length() - 1));
            }
        } else {
            return clean(seq.substring(1));
        }
    }

}
