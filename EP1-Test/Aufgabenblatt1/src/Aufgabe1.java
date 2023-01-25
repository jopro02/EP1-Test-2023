/*
    Aufgabe 1) for-Schleifen
*/
public class Aufgabe1 {

    public static void main(String[] args) {

        //a) Schreiben Sie eine for-Schleife, die alle durch 17 teilbaren Zahlen im Intervall 1 [17, 170] aufsummiert und das Ergebnis auf der Konsole ausgibt.
        //Erwartetes Ergebnis: 935

        int sum = 0;
        for (int a = 17; a < 171; a++)
        {

            if(a % 17 == 0){
                sum = sum + a;
            }
        }
        System.out.print(sum );
        System.out.println();

    // b) Schreiben Sie eine for-Schleife, die jede 6. Zahl im Intervall [60, 82] (beginnend mit 60) nebeneinander durch Leerzeichen getrennt ausgibt.
    //Erwartetes Ergebnis: 60 66 72 78

        for (int b = 60; b < 82 ; b = b + 6){
            System.out.print((b + " "));
        };
        System.out.println();

        //c) Schreiben Sie eine for-Schleife, die alle durch 9 und 13 teilbaren Zahlen im Intervall von ]117, 585[ hintereinander und getrennt durch Pluszeichen (’+’) ausgibt. Zusa ̈tzlich wird noch vor der ersten Zahl und nach der letzten Zahl ein Pluszeichen ausgegeben.
        //  Erwartetes Ergebnis: +234+351+468+

        for (int c = 118; c < 584; c++){

            if(c % 9 == 0 && c % 13 == 0)
            {
                System.out.print( "+" + c);
            }

        }
        System.out.print( "+");
        System.out.println();

        //d) Schreiben Sie eine for-Schleife, die alle Zeichen der ASCII 2-Werte im Intervall ]45, 65] in absteigender Reihenfolge durch Leerzeichen getrennt ausgibt.
        //Erwartetes Ergebnis: A @ ? > = < ; : 9 8 7 6 5 4 3 2 1 0 / .

        for ( int d = 65; d >= 46; d--)
        {
            String convertedChar = Character.toString(d);
            System.out.print(convertedChar + " ");
        }
        System.out.println();

        //e) Schreiben Sie eine for-Schleife, die alle Vorkommen des Buchstabens ’e’ und ’E’ im Satz Es ist kein echtes Edelmetall! za ̈hlt.
        //Erwartetes Ergebnis: 7

        String sentence = "Es ist ein echtes Edelmetall!";
        int counter = 0;
        for (int e = 0; e < sentence.length(); e++)
        {
            char letter = sentence.charAt(e);

            if(letter == 'e' || letter == 'E')
            {
                counter++;
            }
        }
        System.out.print(counter);

    }
}













