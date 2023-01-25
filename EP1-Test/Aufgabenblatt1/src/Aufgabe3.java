import java.util.Scanner;

/*
    Aufgabe 3) Verschachtelte Schleifen
*/
public class Aufgabe3 {

    public static void main(String[] args) {

        //int height sollte nur positive Werte gro ̈ßer 1 annehmen
        //int pattern  fu ̈r eine Linie, 1 fu ̈r ein rechtwinkeliges Dreieck und 2 fu ̈r ein Parallelogramm

        System.out.println("Geben sie für Pattern und für Height eine Zahl ein");

        Scanner spattern = new Scanner(System.in); //Ich habe für pattern und für die heigt 2 Eingaben gemacht
        int pattern = spattern.nextInt();
        Scanner sheight = new Scanner(System.in);
        int height = sheight.nextInt();

        //int height = 5;

        if(pattern == 0 || pattern == 1 || pattern == 2 ) //wenn die eingegebene Zahl für pattern nicht 0 oder 1 oder 2 ist kommt eine Fehlermeldung
        {
            if(height == 2 || height == 3 || height == 5 || height == 6) //wenn die ein eingegebene Zahl für Height nicht 2, 3, 5 oder 6 ist kommt eine Fehlermeldung!
            {
                if (pattern == 0) //wenn Pattern = 0 ist dann wird das 1. Muster ausgegeben
                {
                    for(int i = 0; i < height; i++)
                    {
                        for(int j = 0; j < height; j++)
                        {
                            if(i <= j)
                            {
                                System.out.print("*");
                                break;
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                }
                else if (pattern == 1) //wenn pattern = 1 ist wird das 2. Muster ausgegeben
                {
                    for(int i = 1; i <= height; i++) //wie viele Zeilen
                    {
                        for(int j = height; j >= 1; j--) //wie viele Sterne in der Zeile
                        {
                            if(i < j)
                            {
                                System.out.print(" ");
                            }
                            else
                            {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                }
                else if(pattern == 2) //wenn pattern = 2 ist dann wird das 3. Muster ausgegeben
                {
                    for (int i = 1; i <= height; i++)
                    {

                        for (int j = 0; j < i; j++)
                        {
                            System.out.print(" ");
                        }
                        for(int k = 0; k < height; k++)
                        {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                }
                //ich brauche hier kein else mehr weil ich davor schon überprüft habe, das  Pattern 0, 1 oder 2 ist
            }
            else
            {
                System.out.println("Fehlermeldung: Height darf nur einen Wert von 2, 3, 5 oder 6 haben!");
            }
        }
        else{
            System.out.println("Fehlermeldung: Pattern darf nur 0, 1 oder 2 sein!");
        }

    }
}
