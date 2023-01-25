/*
    Aufgabe 5) Kreismuster => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Aufgabe5 {

    private static void drawCirclePatternRecursively(CodeDraw myDrawObj, int x, int y, int r) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode


        if(r > 2)
        {
            int halfRadius = r/2;

            //a
            drawCirclePatternRecursively(myDrawObj, x-r, y-r, halfRadius); //nach Links Oben in die Ecke -> Kreise werden immer kleiner und der Mittelpunkt wird immer verschoben
            drawCirclePatternRecursively(myDrawObj, x+r, y-r, halfRadius); //nach Rechts oben in die Ecken und alles dazwischen
            drawCirclePatternRecursively(myDrawObj, x-r, y+r, halfRadius); //nach Links Unten in die Ecke und alles dazwischen
            drawCirclePatternRecursively(myDrawObj, x+r, y+r, halfRadius); //nach rechts unten in die Ecke und alles dazwischen

            //b) Antwort auf Frage 3
/*
            drawCirclePatternRecursively(myDrawObj, x-r, y-r, halfRadius); //nach Links Oben in die Ecke
            drawCirclePatternRecursively(myDrawObj, x-r, y+r, halfRadius); //nach Links Unten in die Ecke und alles dazwischen
            drawCirclePatternRecursively(myDrawObj, x+r, y+r, halfRadius); //nach rechts unten in die Ecke und alles dazwischen
*/

            myDrawObj.setColor(Palette.RED);
            myDrawObj.drawCircle(x,y,r);
            myDrawObj.setColor(Palette.ORANGE);
            myDrawObj.fillCircle(x,y,r);

        }
        else {
            return;
        }
    }

    private static void drawCirclePatternIteratively(CodeDraw myDrawObj, int maxRadius) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        int xy = 8; //die kleinsten Kreise von der Mitte in die linke Ecke haben eine Länge von 248 -> also muss x = 8 sein


        int radius = maxRadius * 2;

        for(int i = xy; i <= radius; i *= 2)
        {
            for (int j = i; j < 512; j+= (i*2))
            {
                for(int k = i; k < 512; k += (i*2))
                {
                    myDrawObj.setColor(Palette.RED);
                    myDrawObj.drawCircle(j,k,i/2);
                    myDrawObj.setColor(Palette.ORANGE);
                    myDrawObj.fillCircle(j,k,i/2);
                }
            }
        }
        myDrawObj.show();
    }

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        int widthHeight = 512;
        int x = widthHeight/2;
        int y = widthHeight/2;
        int radius = widthHeight/4;

        CodeDraw myDrawObj = new CodeDraw(widthHeight, widthHeight);


        drawCirclePatternRecursively(myDrawObj, x, y,radius);



        drawCirclePatternIteratively(myDrawObj, radius);


        /*
1. Wie oft wird die Methode drawCirclePatternRecursively aufgerufen,
wenn die Rekursion bis zu einem Radius r > 2 aufgerufen wird?
->32x32 + 16x16 + 8x8 + 4x4 + 2x2 + 1 = 1365x durchlaufen, da es 1365 Kreise sind

2. Wie viele Kreise werden auf der letzten Rekursionsstufe (die kleinsten Kreise) gezeichnet?
-> 32x32 = 1024 oder 512*2 = 1024
-> 32 Zeilen und 32 Spalten mit den kleinsten Kreisen

3. Wie mü̈ssen Sie Ihre rekursive Implementierung aba ändern, um das Muster in Abbildung 1b zu erzeugen?
-> siehe oben

         */

        myDrawObj.show();



    }
}


