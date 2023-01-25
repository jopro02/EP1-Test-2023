/*
    Aufgabe 5) Schleifen und Zeichnen innerhalb des CodeDraw-Fensters
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.util.Scanner;

public class Aufgabe5 {

    public static void main(String[] args) {

        CodeDraw myDrawObj = new CodeDraw(300, 300);
        myDrawObj.setLineWidth(2);

        System.out.println("Geben sie einen Wert ein der zwischen 5 und 19 liegt ");

        Scanner s = new Scanner(System.in);
        double n = s.nextInt();

        if( n >= 5 && n <= 19 && n % 2 == 1)
        {
            double circle = 300/n;

            double radius = circle/2.0;
            double redXStart = circle/2.0; //Startwerte x und y
            double redYStart = circle/2.0;
            double blueXStart = circle/2.0 * 3;
            double blueYStart = circle/2.0 * 3;

            //Rote Kreise
            myDrawObj.setColor(Palette.RED);
            for(int i = 0; i < n; i++){ //außen
                myDrawObj.drawCircle(redXStart, redYStart + circle * i, radius);//senkrecht
                myDrawObj.drawCircle(redXStart + circle *i, 300-redYStart, radius ); //waagrecht
            }
            for (int j = 0; j < n - 4; j++){ //innen
                myDrawObj.drawCircle(redXStart * 5, redYStart * 5 + circle * j , radius); //senkrecht
                myDrawObj.drawCircle(redXStart * 5 + circle * j,300-redYStart * 5, radius); //waagrecht
            }
            
            //Blaue Kreise
            myDrawObj.setColor(Palette.BLUE);
            myDrawObj.setLineWidth(4);
            for(int k = 0; k < n - 2; k++)
            {
                myDrawObj.drawCircle(blueXStart + circle * k, blueYStart, radius); //waagrechte Kreise
                myDrawObj.drawCircle(300-blueXStart, blueYStart + circle * k, radius); //senkrechte Kreise
            }
        }
        else{
            System.out.println("Sie müssen einen richtigen Wert eingeben");
        }

        myDrawObj.show();
    }
}
