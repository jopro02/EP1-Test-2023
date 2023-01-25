/*
    Aufgabe 3) Zweidimensionale Arrays und CodeDraw - Bildverarbeitung "Finding Waldo"
*/

import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.Image;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Aufgabe3 {

    // converts RGB image into a grayscale array
    private static int[][] convertImg2Array(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width]; //es wird hier ein neues Array erstellt, das die gleiche Höhe & Breite hat wie das Bild
        Color tempColor;

        for (int row = 0; row < height; row++) {
            //Alle Zeilen und Spalten werden im Bild durchlaufen
            //für jedes Pixel wird ein Farbwert mit img.getPixel ausgelesen
            for (int col = 0; col < width; col++) {
                tempColor = img.getPixel(col, row);
                //dann wird der grayscale-Wert für das Pixel berechnet, indem die Farbwerte Rot, Grün und Blau miteinander kombiniert werden
                //dieser grayscale-Wert wird im Array gespeichert
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }
        }
        //Array mit den greyscale-Pixelwerten wird hier zurückgegeben
        return imgArray;
    }

    //detect waldo by template matching
    private static void detectWaldo(CodeDraw myDrawObj, Image img, Image template) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        myDrawObj.setColor(Palette.DEEP_PINK);
        myDrawObj.setLineWidth(6);

        //die Bilder werden hier in 2D-Arrays umgewandelt
        int[][] picArray = convertImg2Array(img);
        int[][] tempArray = convertImg2Array(template);

        // Holt die Dimensionen der Bilder
        int picRows = picArray.length; //Anzahl der Zeilen im picArray
        int picCols = picArray[0].length; // Anzahl der Spalten im picArray
        int tempRows = tempArray.length; //Anzahl der Zeilen im tempArray
        int tempCols = tempArray[0].length; //Anzahl der Spalten im tempArray

        // Sucht nach Waldo, indem das Template mit jedem Unterbild im Hauptbild verglichen wird
        int minSAD = Integer.MAX_VALUE; //Integer.MAX_VALUE -> Konstante die den größtmöglichen Wert für einen int-Wert darstellt

        //indem minsad mit diesem Wert initialisiert wird, wird sichergestellt ,
        // dass minSad immer größer ist als jeder mögliche Wert der später für SAD berechnet wird.
        int minRow = 0;
        int minCol = 0;
        for (int row = 0; row < picRows - tempRows; row++) {
            for (int col = 0; col < picCols - tempCols; col++) {
                // Berechnet SAD für das aktuelle Unterbild
                int SAD = 0;

                for (int tempRow = 0; tempRow < tempRows; tempRow++) {//solange die anzahl der zeilen im Array tempRow kleiner ist
                    for (int templateCol = 0; templateCol < tempCols; templateCol++) {

                        // hier wird die absolute Differenz zwischen dem aktuellen Pixel im Hauptbild
                        // und dem entsprechenden Pixel im Template berechnet und zu Sad hinzuaddiert
                        SAD += Math.abs(picArray[row + tempRow][col + templateCol] - tempArray[tempRow][templateCol]);

                        //Math.abs = um die absolute Differenz zu berechnen
                    }
                }
                // Aktualisiere minimale SAD und Position, falls nötig
                if (!(SAD > minSAD)) {
                    minSAD = SAD;
                    minRow = row;
                    minCol = col;

                    myDrawObj.drawImage(0, 0, img);
                    myDrawObj.drawRectangle(minCol, minRow, tempCols, tempRows);
                    myDrawObj.show(300);
                    myDrawObj.clear(); //damit das Rechteck immer neu gezeichnet wird und nicht zuviele angezeigt werdens
                    myDrawObj.drawImage(0, 0, img);
                }
            }
        }
        // Zeichnet die  Bounding Box um Waldo
        myDrawObj.drawRectangle(minCol, minRow, tempCols, tempRows);
        //Jedes Mal, wenn eine neue Position gefunden wurde, soll auch eine Pause von 300ms eingelegt werden.
        myDrawObj.show(300);

    }

    public static void main(String[] args) {

        //waldo1
        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/6NcsuQdriPbHcKN/download"; //waldo1.png
        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/AwlmIBqj2V1qGV7/download"; //template1.png

        //waldo2
        //String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/922nyXVsBkMKz6K/download"; //waldo2.png
        //String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/tqTFXxF2BkeKnhm/download"; //template2.png

        //waldo3
        //String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/DR2u4Xf5muAZsWo/download"; //waldo3.png
        //String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/xEMZlbdHJ4ZfLfz/download"; //template3.png

        // open image file
        Image img = Image.fromUrl(linkWaldo);

        // open template image file
        Image template = Image.fromUrl(linkTemplate);

        // set StdDraw window size based on the image size
        int width = img.getWidth();
        int height = img.getHeight();
        CodeDraw cd = new CodeDraw(width, height);

        //draw image
        cd.drawImage(0, 0, img);
        cd.show();

        //detect Waldo given in 'template' and show result in image 'img'
        detectWaldo(cd, img, template);
    }
}





