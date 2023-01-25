/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void fillArray(int[] filledArray) {
        int number = 6;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 6;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 4 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[10];
        int number = 6;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 6;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    private static void printArray(int[] workArray) {
        for (int i = 0; i < workArray.length; i++) { //muss auf i++ geändert werden
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 777;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Frage 1:
    // Die Schleife hat ein i mit dem Wert 0 -> und i kann dann nicht kleiner werden (i--)
    // Es muss größer werden (i++)
    //Frage 2:
    // Das Array wird in der Schleife befüllt -> aber es braucht keinen return da es automatisch gespeichert wird
    // ->der Wert wird beim Array sozusagem mitgeschickt
    // deshalb auch eine void methode
    //Frage 3:
    //alles was im copiedArray geändert wird wird auch im filledArray geändert
    //Array ist ein Speicherort -> wenn ein Array kopiert wird dann wird der Speicherort kopiert und nicht der Inhalt
    //Frage 4:
    //Da ein neues Array initialisiert wird und dadurch einen neuen Speicherort bekommt wirds nicht geändert

    //Zusatzfragen:
    //1. Integer
    //2. Ja, denn es handelt sich um ein Objekt
    //3. Man kann es nur neu erzeugen, denn Arrays haben eine feste Größe, die Länge kann nicht geändert werden
    //4. durch das switchen der Referenzvariablen, wird keine Kopie vom Array angelegt. Es zeigen dann 2 referenzvariablen
    // auf das gleiche Array -> mit einer clone-Methode oder System.arraycopy oder einer for-Schleife kann man ein int Array kopieren
    //5. Ja
    //6. Ein Array kann man nicht miteinander vergleichen. man müsste jede Zahl an einem Index vergleichen
    // Man würde nur die Speicheradressen vergleichen
}
