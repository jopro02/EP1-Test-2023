/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printEvenNumbersAscending(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode

        if ( start <= end) //Diese Methode gibt alle geraden Zahlen im Intervall von [start, end] aufsteigend aus. Vorbedingung: start ≤ end.
        {
            if( start % 2 == 0 ) // alle geraden Zahlen
            {
                System.out.println(start ); //gibt die Zahl aus
            }

            printEvenNumbersAscending(start+1, end); //muss um 1 erhöht werden -> für die nächste gerade Zahl
        }

    }

    private static void printOddNumbersDescending(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode

        if ( start <= end ) //Diese Methode gibt alle ungeraden Zahlen im Intervall von [start, end] absteigend aus. Vorbedingung: start ≤ end.
        {
            if( end % 2 == 1 ) // alle ungeraden Zahlen
            {
                System.out.println(end ); //gibt die Zahl aus
            }

            printOddNumbersDescending(start, end-1); //muss um 1 verringert werden
        }


    }

    private static int sumSquaredDigits(int number) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode

        if(number > 0)
        {
            int newNumber = number % 10; // bei einer Zahl 730 %10 = 0  .. also liefert immer die hinterste Stelle
                                        // number/10 wäre sonst 73

            int numberReturn = (int) Math.pow(newNumber, 2) + sumSquaredDigits(number/10);

            return  numberReturn;
        }
        else
        {
            return 0;
        }

    }

    private static String removeSpaces(String text) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode

        if(text != null)
        {
            if (text.equals(" "))
            {
                return "";
            }
            else if(text.length() == 1)
            {
                return text;

            }
            else if(text.charAt(0) != ' ')
            {
                return text.charAt(0) + removeSpaces(text.substring(1));
            }
            else
            {
                return removeSpaces(text.substring(1)); //beginnt mit dem Character ->  substring 1 beginnt bei index 1
            }
        }

        return removeSpaces(text.substring(1));
    }

    public static void main(String[] args) {
        printEvenNumbersAscending(10, 20);
        System.out.println();
        printOddNumbersDescending(5, 15);
        System.out.println();

        System.out.println(sumSquaredDigits(1));
        System.out.println(sumSquaredDigits(102));
        System.out.println(sumSquaredDigits(1234));
        System.out.println(sumSquaredDigits(10000));
        System.out.println(sumSquaredDigits(93842));
        System.out.println(sumSquaredDigits(875943789));
        assert (sumSquaredDigits(1) == 1);
        assert (sumSquaredDigits(102) == 5);
        assert (sumSquaredDigits(1234) == 30);
        assert (sumSquaredDigits(10000) == 1);
        assert (sumSquaredDigits(93842) == 174);
        assert (sumSquaredDigits(875943789) == 438);
        System.out.println();

        System.out.println(removeSpaces(" "));
        System.out.println(removeSpaces("+ +"));
        System.out.println(removeSpaces(" 12 3 45 "));
        System.out.println(removeSpaces("a  b   c    d"));
        assert (removeSpaces(" ").equals(""));
        assert (removeSpaces("+ +").equals("++"));
        assert (removeSpaces(" 12 3 45 ").equals("12345"));
        assert (removeSpaces("a  b   c    d").equals("abcd"));
    }
}

