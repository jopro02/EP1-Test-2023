/*
    Aufgabe 1) Zweidimensionale Arrays und Methoden - Vier Gewinnt
*/

import codedraw.*;
import org.w3c.dom.Text;

public class Aufgabe1 {

    private static int[][] genGameBoard(int row, int col) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        int[][] genGameBoardArray = new int[row][col];
        return genGameBoardArray;

    }

    private static void drawGameBoard(CodeDraw myDrawObj, int[][] currentGameBoard, int oneSquareSize) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        myDrawObj.setColor(Palette.BLUE);

        for (int i = 0; i < currentGameBoard.length; i++) {
            for (int j = 0; j < currentGameBoard[i].length; j++) {

                myDrawObj.setColor(Palette.BLUE);
                myDrawObj.fillSquare(j * oneSquareSize, i * oneSquareSize, oneSquareSize);

                if (currentGameBoard[i][j] == 0) {
                    myDrawObj.setColor(Palette.GRAY);
                    myDrawObj.fillCircle(j* oneSquareSize + oneSquareSize/2.0, i * oneSquareSize + oneSquareSize/2.0, oneSquareSize/3.0);
                    myDrawObj.setColor(Palette.BLUE);
                    myDrawObj.show();
                }
                if (currentGameBoard[i][j] == 1) {
                    myDrawObj.setColor(Palette.RED);
                    myDrawObj.fillCircle(j* oneSquareSize + oneSquareSize/2.0, i * oneSquareSize + oneSquareSize/2.0, oneSquareSize/3.0);
                }
                if (currentGameBoard[i][j] == 2) {
                    myDrawObj.setColor(Palette.YELLOW);
                    myDrawObj.fillCircle(j* oneSquareSize + oneSquareSize/2.0, i * oneSquareSize + oneSquareSize/2.0, oneSquareSize/3.0);
                }
                myDrawObj.setColor(Palette.BLUE);
            }

        }
        myDrawObj.show();
    }

    private static boolean isMovePossible(int[][] currentGameBoard, int col) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        for (int i = 0; i < currentGameBoard.length; i++) {
            if (currentGameBoard[i][col] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void makeMove(int[][] currentGameBoard, int player, int col) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        for (int i = currentGameBoard.length - 1; i >= 0; i--) {
            if (currentGameBoard[i][col] == 0) {
                currentGameBoard[i][col] = player;
                i = -1; //bricht die Schleife ab  -> kann man break auch verwenden?
            }
        }
    }

    private static boolean existsWinner(int[][] currentGameBoard, int player) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        // check rows
        for (int i = 0; i < currentGameBoard.length; i++) {
            for (int j = 0; j < currentGameBoard[i].length - 3; j++) {
                if (currentGameBoard[i][j] == player && currentGameBoard[i][j + 1] == player
                        && currentGameBoard[i][j + 2] == player && currentGameBoard[i][j + 3] == player) { //überprüft in der Reihe ob 4 gleiche Kreise hintereinander sind
                    return true;
                }
            }
        }
        // check columns
        for (int i = 0; i < currentGameBoard.length - 3; i++) {
            for (int j = 0; j < currentGameBoard[i].length; j++) {
                if (currentGameBoard[i][j] == player && currentGameBoard[i + 1][j] == player
                        && currentGameBoard[i + 2][j] == player && currentGameBoard[i + 3][j] == player) { //überprüft in der Spalte ob 4 gleiche Kreise hintereinander sind
                    return true;
                }
            }
        }
        // check diagonals
        for (int i = 0; i < currentGameBoard.length - 3; i++) {
            for (int j = 0; j < currentGameBoard[i].length - 3; j++) {
                if (currentGameBoard[i][j] == player && currentGameBoard[i + 1][j + 1] == player
                        && currentGameBoard[i + 2][j + 2] == player && currentGameBoard[i + 3][j + 3] == player) { //überprüft die diagonalen von links oben nach rechts unten
                    return true;
                }
                if (currentGameBoard[i][j + 3] == player && currentGameBoard[i + 1][j + 2] == player
                        && currentGameBoard[i + 2][j + 1] == player && currentGameBoard[i + 3][j] == player) { //überprüft die diagonalen von rechts oben nach links unten
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {

        // canvas settings
        int rowsGameBoard = 6;
        int colsGameBoard = 7;
        int oneSquareSize = 50;
        int width = oneSquareSize * colsGameBoard;
        int height = oneSquareSize * rowsGameBoard;

        CodeDraw myDrawObj = new CodeDraw(width, height);
        EventScanner myEventSC = myDrawObj.getEventScanner();

        // game variables
        int[][] myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
        int player = 1;
        int fieldsUsed = 0;
        boolean gameActive = true;

        // set font for text
        TextFormat font = new TextFormat();
        font.setFontSize(28);
        font.setFontName("Arial");
        font.setTextOrigin(TextOrigin.CENTER);
        font.setBold(true);
        myDrawObj.setTextFormat(font);

        // initial draw of the game board
        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);

        // game play starts
        System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");
        while (!myDrawObj.isClosed() && gameActive) {
            if(myEventSC.hasKeyPressEvent()){
                if(myEventSC.nextKeyPressEvent().getChar() == 'q'){
                    gameActive = false;
                }
            }
            else if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                int mouseY = currentClick.getY();


                // TODO: Implementieren Sie hier die fehlende Spiellogik

                if (isMovePossible(myGameBoard, mouseX / oneSquareSize)) //geht ins if wenn die Methode isMovePossible true ist (zurückliefert)
                {

                    makeMove(myGameBoard, player, mouseX / oneSquareSize);
                    drawGameBoard(myDrawObj, myGameBoard,oneSquareSize);
                    fieldsUsed += 1; //wird erhöht wenn 1 feld mehr benutzt ist

                    if (existsWinner(myGameBoard, player)) {

                        //zeigt den Gewinner an
                        myDrawObj.setColor(Palette.LAWN_GREEN);

                        //wenn player = 1 ist, gibt es (RED) zurück, ansonsten gibt es (YELLOW) zurück
                        myDrawObj.drawText(width / 2.0, height / 2.0,"Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " won!");

                        myDrawObj.show(3000);


                        //Hier wird das Spielfeld neu generiert
                        myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
                        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);

                        //Nächste Runde:
                        myDrawObj.setColor(Palette.ORANGE);
                        myDrawObj.drawText(width / 2.0, height / 2.0, "Next round!");
                        myDrawObj.show(1000);
                        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);

                        //Felder Used wird wieder auf 0 gesetzt
                        fieldsUsed = 0;
                    }
                    //wenn alle Felder voll sind
                    if(fieldsUsed == rowsGameBoard * colsGameBoard)
                    {
                        //es wird ausgegeben Board full!
                        myDrawObj.setColor(Palette.ORANGE);
                        myDrawObj.drawText(width/2.0, height/2.0, "Board full!");
                        myDrawObj.show(3000);

                        //das Feld wird Zeile für Zeile geleert

                        for (int i = 0; i < myGameBoard.length-1; i++)
                        {
                            myGameBoard[i+1] = myGameBoard[i];
                            myGameBoard[i]=  new int [myGameBoard[i].length];
                            drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                            myDrawObj.show(500);
                        }

                        //letzte Zeile auch leeren -> bleibt sonst stehen
                        myGameBoard = genGameBoard(rowsGameBoard,colsGameBoard);
                        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                        myDrawObj.show(500);

                        //neuer Versuch
                        myDrawObj.setColor(Palette.ORANGE);
                        myDrawObj.drawText(width / 2.0, height / 2.0, "Try again!");
                        myDrawObj.show(1000);
                        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);

                        //wird wieder auf 0 gesetzt
                        fieldsUsed = 0;

                    }

                    //wenn Spieler 1 wird auf Spieler 2 gewechselt oder umgekehrt
                    if(player ==  1)
                    {
                        player = 2;
                    }
                    else
                    {
                        player = 1;
                    }

                    myDrawObj.setColor(Palette.GREEN);
                    System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");

                }
                else
                {
                    myDrawObj.setColor(Palette.ORANGE);
                    myDrawObj.drawText(width/2.0, height/2.0, "Column already full!");
                    myDrawObj.show(1000);
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);

                }

            }
            else {
                myEventSC.nextEvent();
            }
        }
        myDrawObj.close();
    }
}


