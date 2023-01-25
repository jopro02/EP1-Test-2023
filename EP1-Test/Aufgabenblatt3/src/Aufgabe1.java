/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    //Der Spaghetticode macht in der Ersten und letzten Zeile eine Ausgabe von # und |
    //Zwischen diesen Zeilen wird ein Muster ausgegeben
    //Das Muster ist in 4 Blöcke unterteilt - alle Blöcke sind eigentlich gleich nur das der 2 und 4 Block genau das umgedrehte vom 1 und 3 ist
    //im 1 und 3 Block werden mit den drei for Schleifen: 1.  die +, 2. die /  und 3. die * ausgegeben
    //Diese wird solange ausgeführt wie die width ist
    //im 2 und 4 Block werden mit drei Schleifen wieder das gleiche ausgegeben nur in umgekehrter Reihenfolge

    //TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    //Die Gliederung ist sehr unübersichtlich und verwirrend.
    //Als erstes würde ich den gesamten Code richtig gliedern (Klammern richtig setzen, richtige Absätze machen und in jeder Zeile nur einen Befehl schreiben), da man so nicht weiß welche Schleife in welche gehört

    //für die erste und letzte Zeile mache ich eine eingene Methode diese wird 2x aufgerufen
    //danach würde ich die einzelnen Blöcke in eine Methode geben
    //da man erkennen kann das sich das Muster wiederholt braucht man nur 2 Methoden und diese werden dann jeweils 2x aufgerufen


    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung

    public static void startEndLine(int width)
    {
        System.out.print("#");
        for (int i = 1; i <= width; i++)//in eine Methode wird zu beginn und am Ende Ausgegeben
        {
            System.out.print("|");
        }

        System.out.println("#");
    }

    public static void firstBlock(int width)
    {

        for (int i = 1; i <= width/2; i++)
        {
            firstBlockRowI(i);

            System.out.print("\\");

            for (int j = 1; j <= (width - 2 * i); j++)
            {
                System.out.print("*");
            }

            System.out.print("/");

            firstBlockRowI(i);

            System.out.println();
        }
    }
    public static void firstBlockRowI(int plus)
    {
        for (int j = 1; j <= plus; j++)
        {
            System.out.print("+");
        }
    }

    public static void secondBlock(int width){
        for (int i = 1; i <= width/2 ; i++)
        {
            secondBlockRowI(i, width);
            System.out.print("/");

            for (int j = 1; j <= 2 * (i - 1); j++)
            {
                System.out.print("*");
            }
            System.out.print("\\");

            secondBlockRowI(i, width);
            System.out.println();
        }
    }

    public static void secondBlockRowI(int plus, int width)
    {
        for (int j = 1; j <= (width / 2 - plus + 1); j++) //i mitgegeben
        {
            System.out.print("+");
        }
    }

    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");

        //********************************************************

        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");


        int widthRow = 10;

        if (widthRow % 2 == 0 && widthRow > 0)
        {
            startEndLine(widthRow);

            for(int i = 0; i < 2; i++)
            {
                firstBlock(widthRow);
                secondBlock(widthRow);
            }

            startEndLine(widthRow);
        }
        else
        {
            System.out.print("Fehlermeldung: Es dürfen nur prositive und gerade Werte eingegeben werden");
        }


    }
}


