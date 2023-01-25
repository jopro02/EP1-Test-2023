import codedraw.*;

import java.util.Scanner;

/*
    Aufgabe 5) Designaufgabe
*/
public class Aufgabe5 {

    public static void main(String[] args) {

        CodeDraw myGame = new CodeDraw(600, 400);

        //System.out.print("Geben sie ihren Namen ein!");
        //Scanner input = new Scanner(System.in);
        //String inputName = input.toString();

        String player1Name = "Johanna ";
        String player2Name = "Eva";

        char letterPlayer1 = player1Name.charAt(0);
        char letterPlayer2 = player2Name.charAt(0);

        if (letterPlayer1 == ' ')
        {
            System.out.print("Fehlermeldung: Sie müssen Ihren Vornamen eingeben ohne Leerzeichen! ");
        } else if (letterPlayer2 == ' ')
        {
            System.out.print("Fehlermeldung: Sie müssen Ihren Vornamen eingeben ohne Leerzeichen! ");
        }
        else
        {
            ///Himmel
            myGame.setColor(Palette.fromRGB(135,206,235));
            myGame.fillRectangle(0, 0, 600, 400);

            //Hintergrund
            //Berge
            myGame.setColor(Palette.fromRGBA(0, 139,139,100));
            myGame.setCorner(Corner.ROUND);
            myGame.setLineWidth(100);
            myGame.fillRectangle(-10,200, 100, 400);
            myGame.fillRectangle(500,300, 100, 400);
            myGame.setLineWidth(150);
            myGame.fillRectangle(200,150, 150, 400);

            //Sonne
            myGame.setColor(Palette.fromRGB(238,238,0));
            myGame.fillCircle(400, 80, 30);
            myGame.setColor(Palette.fromRGBA(238, 238,0,100));
            myGame.fillCircle(400, 80, 50);
            myGame.setColor(Palette.fromRGBA(238, 238,0,50));
            myGame.fillCircle(400, 80, 70);

            //Wolken
            myGame.setColor(Palette.fromRGBA(220,220,220,80));
            myGame.setLineWidth(20);
            myGame.fillRectangle(40,80, 80, 20);
            myGame.fillRectangle(70,100, 80, 20);

            myGame.fillRectangle(400,180, 80, 20);
            myGame.fillRectangle(430,160, 80, 20);

            //Bodenplatten braun
            myGame.setLineWidth(5);
            myGame.setColor(Palette.fromRGB(139,69,19));
            myGame.fillRectangle(0,370,60,30);
            myGame.fillRectangle(100,350,190,50);
            myGame.fillRectangle(300, 300, 40, 20);
            myGame.fillRectangle(250, 220, 80, 20);
            myGame.fillRectangle(380, 260, 100, 300);
            myGame.fillRectangle(530, 200, 100, 70);
            //Bodenplatten grün
            myGame.setColor(Palette.fromRGB(34,139,34));
            myGame.fillRectangle(0,365,70,10);
            myGame.fillRectangle(95,345,200,10);
            myGame.fillRectangle(295, 295, 50, 10);
            myGame.fillRectangle(245, 215, 90, 10);
            myGame.fillRectangle(375, 255, 110, 10);
            myGame.fillRectangle(525, 195, 110, 10);

            //Boxen
            myGame.setLineWidth(2);
            int x = 120;
            for (int i = 0; i < 4; i++)
            {

                myGame.setColor(Palette.ORANGE);
                myGame.fillRectangle(x, 290, 20, 20);
                myGame.setColor(Palette.BLACK);
                myGame.drawRectangle(x, 290, 20, 20);
                x = x + 23;
            }

            //Münzen/Taler
            myGame.setColor(Palette.ORANGE);
            int talerX = 385; //waagrechten
            myGame.setLineWidth(3);
            for(int j = 1; j < 5; j++)
            {

                myGame.drawCircle(talerX, 220, 10);
                talerX = talerX + 30;
            }

            int talerY = 100; //senkrechten
            myGame.setLineWidth(3);
            for(int j = 1; j < 5; j++)
            {

                myGame.drawCircle(290, talerY, 10);
                talerY = talerY + 30;
            }

            //Münzen
            talerX = 190; //waagrechten
            talerY = 250; //senkrechten
            myGame.setLineWidth(3);
            for(int j = 0; j < 3; j++)
            {
                myGame.drawCircle(talerX, talerY, 10);
                talerY = talerY - 30;
                talerX = talerX + 25;
            }

            //Leben
            myGame.setColor(Palette.fromRGB(210,4, 45));

            //1. Herz = 1. Leben
            myGame.fillCircle(23,22,2.5);
            myGame.fillCircle(27,22,2.5);
            myGame.fillTriangle(20,22,30,22,25,27);
            //2. Herz = 2. Leben
            myGame.fillCircle(33,22,2.5);
            myGame.fillCircle(37,22,2.5);
            myGame.fillTriangle(30,22,40,22,35,27);
            //3. Herz = 3. Leben
            myGame.fillCircle(43,22,2.5);
            myGame.fillCircle(47,22,2.5);
            myGame.fillTriangle(40,22,50,22,45,27);

            myGame.setColor(Palette.ORANGE);
            myGame.setLineWidth(2);
            myGame.drawCircle(24, 39, 5);

            //x Münzen
            myGame.setColor(Palette.BLACK);
            TextFormat format = myGame.getTextFormat();
            format.setFontSize(10);
            format.setItalic(true);
            myGame.drawText(35, 35, "x 9 ");

            //Name Spieler
            format.setItalic(false);
            format.setTextOrigin(TextOrigin.TOP_MIDDLE);
            myGame.drawText(300, 10, "Player 1: " + player1Name);
            myGame.drawText(300, 20, "Player 2: " + player2Name);

            myGame.show();
        }

    }
}
