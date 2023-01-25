/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    private static void addSign(String text, char sign) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe


        for(int i = 0; i < text.length(); i++ )
        {
            for (int j = i; j > 0; j--)
            {
                System.out.print(sign);
            }
            System.out.print(text.charAt(i));

        }
        System.out.println();
    }

    private static void addSign(int number, char sign) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        String i = Integer.toString(number);
        addSign(i, sign); //1. Methode wird aufgerufen und i und sign werden mitgegeben und dann ausgegeben
    }

    private static void addSign(String text, String signs) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        if(text != null && signs != null)
        {
            for(int i = 0; i < signs.length(); i++)
            {
                addSign(text, signs.charAt(i)); // 1 Methode wird aufgerufen der text und das sign an der Stelle i werden mitgegeben

            }

        }

    }

    private static void addSign(String text) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        /*for(int i = 0; i < text.length(); i++ )
        {
            for (int j = i; j > 0; j--)
            {
                System.out.print("=");
            }
            System.out.print(text.charAt(i));

        }
        System.out.println();

         */

        addSign(text, "="); // 1. Methode wird aufgerufen und text und = mitgegeben
    }

    public static void main(String[] args) {
        String text0 = "";
        String text1 = "IT";
        String text2 = "Hello!";
        String text3 = "+EP1+";
        String text4 = "INT";

        addSign(text0, '+');
        addSign(text1, '-');
        addSign(text2, '#');
        addSign(text3, '&');
        addSign(text4, '*');
        System.out.println();

        addSign(1, '$');
        addSign(42, '%');
        addSign(183, '.');
        addSign(4096, ':');
        addSign(65536, ']');
        System.out.println();

        addSign(text1, "/X/");
        addSign(text2, "(#?§");
        System.out.println();

        addSign(text0);
        addSign(text1);
        addSign(text2);
    }
}
