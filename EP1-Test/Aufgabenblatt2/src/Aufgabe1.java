/*
    Aufgabe 1) Schleifen - geometrische Formen und Muster (optische Täuschung)
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe1 {

    public static void main(String[] args) {

        CodeDraw myDrawObj = new CodeDraw(400, 400);

        myDrawObj.setLineWidth(3);

        double ws = 400.0;
        double radius = (1/60.0) * ws;
        double x = 2 * radius;
        double y = 2 * radius;

        for (int h = 15; h > 0; h--) //geht alle Reihen durch
        {
            for(int i = 0; i < 15; i++) //befüllt alle Reihen mit den Kreisen
            {
                myDrawObj.setColor(Palette.BLACK);
                myDrawObj.fillCircle(x,y,radius);
                myDrawObj.setColor(Palette.GRAY);
                myDrawObj.drawCircle(x, y, radius);
                x = x + 4 * radius;
            }
            y = y + 4 * radius;
            x = 2 * radius;
        }


        myDrawObj.setLineWidth(1);
        double rectangle = 0.5 * ws - 2 * radius; // Größe Quadrat
        double xyRectangle = 0.25 * ws + radius; // x y Koordinaten von Quadrat

        myDrawObj.setColor(Palette.WHITE); //Große quadrat -> geht auch mit Square
        myDrawObj.fillRectangle(xyRectangle,xyRectangle,rectangle, rectangle);
        myDrawObj.setColor(Palette.BLACK);
        myDrawObj.drawRectangle(xyRectangle,xyRectangle,rectangle, rectangle );

        double xRectangleSmall = 0.25 * ws + 2 * radius; //x Koordinate
        double yRectangleSmall = 0.25 * ws + 2 * radius; //y Koordinate
        double xySize = 2 * radius; //Größe width, height

        for (int h = 7; h > 0; h--) //längs -> Spalte
        {
            for(int i = 0; i < 7; i++) // quer -> Zeile
            {
                myDrawObj.setColor(Palette.WHITE);
                myDrawObj.fillRectangle(xRectangleSmall,yRectangleSmall,xySize, xySize );
                myDrawObj.setColor(Palette.BLACK);
                myDrawObj.drawRectangle(xRectangleSmall,yRectangleSmall,xySize, xySize);

                //myDrawObj.drawRectangle(x,y,width, height);

                xRectangleSmall = xRectangleSmall + 2 * xySize;
            }
            xRectangleSmall = 0.25 * ws + 2 * radius;
            yRectangleSmall = yRectangleSmall + 2 * xySize;
        }



        myDrawObj.show();
    }
}
