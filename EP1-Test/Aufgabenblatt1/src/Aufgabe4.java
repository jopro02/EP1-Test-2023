/*
    Aufgabe 4) CodeDraw Bibliothek
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe4 {

    public static void main(String[] args) {

        CodeDraw myDrawObj = new CodeDraw(400, 400);

        myDrawObj.setLineWidth(2); //Linienbreite auf 2 Pixel gesetzt

        //Kreis -> Cyan
        myDrawObj.setColor(Palette.CYAN);
        myDrawObj.drawCircle(100, 100, 100);

        //gefüllter Kreis -> Magenta
        myDrawObj.setColor(Palette.MAGENTA);
        myDrawObj.fillCircle(100,100,50);

        //Quadrat
        myDrawObj.setColor(Palette.YELLOW);
        myDrawObj.fillRectangle(50, 250 , 100, 100);

        //Kreuz
        myDrawObj.setColor(Palette.BLACK);
        myDrawObj.drawLine(50, 250, 150, 350);
        myDrawObj.drawLine(150, 250, 50, 350);

        //Grünen Linien
        myDrawObj.setColor(Palette.GREEN);
        int x = 200;

        for (int i = 1; i <= 11; i++){

            myDrawObj.drawLine(200, 0, x, 400);
            x = x + 40;
        }

        //rote Elipsen
        myDrawObj.setColor(Palette.RED);
        myDrawObj.fillEllipse(340, 60, 15, 60);
        myDrawObj.fillEllipse(340, 60, 60, 15);

        myDrawObj.show();
    }
}
