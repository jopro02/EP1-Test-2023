/*
    Aufgabe 2) while-Schleifen
*/
public class Aufgabe2 {

    public static void main(String[] args) {

        String text = "Wir beginnen am Anfang mit den Grundlagen.";
        String test = "Kein gesuchtes Zeichen im String!";

        // a) Schreiben Sie eine while-Schleife, die vom String text von vorne beginnend jedes zweite Zeichen
        // u ̈berpru ̈ft und nebeneinander ausgibt, falls es sich nicht um das Zeichen ’a’ handelt. Das erste ausgegebene Zeichen
        // fu ̈r den String "Wir fangen am Anfang mit den Grundlagen an." ist in diesem Fall das Zeichen ’i’, dann ’ ’, usw.
//für text
        int a = 1;
        while(a < text.length()){

            char letter = text.charAt(a);
            System.out.print(text.charAt(a));

            a = a + 2;
        }
        System.out.println();
//für test
        int b = 1;
        while(b < test.length()){

            char letter = test.charAt(b);
            System.out.print(test.charAt(b));

            b = b + 2;
        }
        System.out.println();
        //b) Schreiben Sie eine while-Schleife, die im String text von vorne beginnend das erste Vorkommen des Buchstabens ’s’ sucht.
        // Wird der Buchstabe ’s’ gefunden, dann wird dessen Index auf der Konsole ausgegeben. Andernfalls wird -1 ausgegeben.
        // Fu ̈r diese Implementierung du ̈rfen die Methoden indexOf(...) und lastIndexOf(...) nicht verwendet werden.

        // für text
        int c = 1;
        boolean negative = false;
        while (c < text.length())
        {

            char letter = text.charAt(c);
            if(letter == 's' || letter == 'S'){
                System.out.print(c);
                c = text.length();
                negative = false;
            }
            else {
                negative = true;
            }
            c++;
        }
        if(negative == true)
        {
            System.out.print(-1);
        }
        System.out.println();


        //für test
        int d = 1;
        boolean neg = false;
        while (d < test.length())
        {

            char letter = test.charAt(d);
            if(letter == 's' || letter == 'S'){
                System.out.print(d);
                d = test.length();
                neg = false;
            }
            else {
                neg = true;
            }
            d++;
        }
        if(neg == true)
        {
            System.out.print(-1);
        }
        System.out.println();

        //c) Schreiben Sie eine while-Schleife, die alle geraden durch 17
        // teilbaren Zahlen im Intervall ]17, 238[ nebeneinander ausgibt.

        int e = 18;
        while(e < 238 )
        {
            /*if(e % 17 == 0){  -> wäre sie längere Variante
                if( e % 2 == 0){
                    System.out.print(e + " ");
                }
            }*/

            if(e % 17 == 0 && e % 2 == 0){ //habe die beiden If zusammengefasst -> kürzer
                System.out.print(e + " ");
            }
            e++;
        }

        System.out.println();

        // d) Schreiben Sie eine while-Schleife, die den String text von hinten beginnend durchla ̈uft
        // und Zeichen fu ̈r Zeichen nebeneinander ausgibt, bis der Buchstabe ’e’ 3-Mal gefunden wurde.
        // Gab es weniger als 3 Vorkommen von ’e’, dann wird der komplette String ausgegeben.

        //text
        int f = text.length();
        f = f - 1;
        int counter = 0;
        while(f > 0)
        {
            char letterback = text.charAt(f);

            System.out.print(letterback);

            if(letterback == 'E' || letterback == 'e'){
                counter++;
                if(counter == 3)
                {
                    f = -1;
                }
            }
            f--;
        }
        System.out.println();

        //test
        int g = test.length();
        g = g - 1;
        int number = 0;
        while(g > 0)
        {
            char letterback = test.charAt(g);

            System.out.print(letterback);

            if(letterback == 'E' || letterback == 'e'){
                number++;
                if(number == 3)
                {
                    g = -1;
                }
            }
            g--;
        }

        System.out.println();

        //e) Schreiben Sie eine while-Schleife, die im String text die Vorkommen aller Leerzeichen sowie Satzzeichen
        // ’.’ und ’!’ za ̈hlt und das Ergebnis auf der Konsole ausgibt.

        //text
        int h = 0;
        int countsign = 0;
        while (h < text.length())
        {
            char sign = text.charAt(h);

            if (sign == ' ' || sign == '.' || sign == '!')
            {
                countsign++;
            }

            h++;
        }
        System.out.println(countsign);

        //test
        int j = 0;
        int countersign = 0;
        while (j < test.length())
        {
            char sign = test.charAt(j);

            if (sign == ' ' || sign == '.' || sign == '!')
            {
                countersign++;
            }

            j++;
        }
        System.out.print(countersign);

    }
}






