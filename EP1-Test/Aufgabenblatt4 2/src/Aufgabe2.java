/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        // Teilaufgabe 2a
        int[] arrayA = new int[]{6, 1, 8, 2, 5, 3, 4, 7, 9, 0};

        for (int i = 0; i < arrayA.length - 1; i++) {
            System.out.print(arrayA[i] + "#");
        }
        System.out.print(arrayA[arrayA.length - 1]);
        System.out.println();

        // Teilaufgabe 2b
        int[] arrayB = new int[12];
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = 6 + 6 * i;
            if (arrayB[i] % 9 == 0) {
                arrayB[i] = 0;
            }
            System.out.print(arrayB[i] + " ");
        }
        System.out.println();


        // Teilaufgabe 2c
        int[] arrayC = new int[]{7, 3, 2, 7, 6, 7, 7, 8, 9, 5};
        int counter7 = 0; // um herauszufinden, um wie viele Positionen das neue Array verlängert werden soll (4, aber um es mit verschiedenen Initalisierungen zu ermöglichen)

        for (int i = 0; i < arrayC.length; i++) {
            if (arrayC[i] == 7) {
                counter7 += 1;
            }
        }

        int[] newArrayC = new int[arrayC.length + counter7]; // neues, größeres Array
        int position = 0;

        for (int i = 0; i < arrayC.length; i++) { // for Schleife um Array-Inhalte zu kopieren, könnte auch array Copy verwenden
            newArrayC[position] = arrayC[i];
            position++; // Position springt eines vor, um an nächster Stelle Wert einzufügen

            if (arrayC[i] == 7) { // wenn an der Stelle 7 ist, dann...
                newArrayC[position] = -1; //... wird an darauffolgender Position (weil wurde ja vor if-Anweisung erhöht), -1 eingefügt, und ...
                position++; // ... Position wird wieder erhöht, damit dann im nächsten For-Durchlauf insgesamt zwei Positionen weiter gesprungen werden, weil die neue +1 ja nicht überschrieben werden darf
            }
        }

        for (int i = 0; i < newArrayC.length; i++) {
            System.out.print(newArrayC[i] + " ");
        }
        System.out.println();


        // Teilaufgabe 2d

        int[] arrayD = new int[11];

        for (int i = 0; i < arrayD.length; i++) {
            arrayD[i] = i + 1;
        }

        // For-Schleife
        System.out.print("for-Schleife: ");
        for (int i = 10; i > 0; i--) {
            System.out.print(arrayD[i] + ",");
        }
        System.out.print(arrayD[0]); // letzten Wert getrennt ausgeben, damit kein Beistrich
        System.out.println();

        // While-Schleife
        System.out.print("while-Schleife: ");
        int i = 10;
        while (i > 0) {
            System.out.print(arrayD[i] + ",");
            i--;
        }
        System.out.print(arrayD[0]); // letzten Wert getrennt ausgeben, damit kein Beistrich

    }
}
