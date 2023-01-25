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
        for (int i = 0; i < workArray.length; i++) {
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
    // Es kommt zu einem Fehler, weil mit i-- bei jedem Schleifendurchlauf i, also der Index des Arrays, verringert wird
    // und somit nach dem ersten Durchlauf i = -1 ist. Die Bedinung der Schleife "i < workArray.length" stellt aber nur sicher,
    // dass der Index nicht größer als das Array ist, ein negatives i ist mit dieser SChleife also realisierbar,
    // kann aber nicht als Index eines Arrays angegeben werden. Das i müsste also inkrementiert werden. i++

    //
    //Frage 2:
    // Diese Methode braucht keinen Rückgabewert, weil der Methode als Parameter die Referenz des Arrays mitgebeben wird.
    // Diese Referenz wird dann innerhalb der Methode befüllt, also überschrieben und somit wird das Array also befüllt/geändert
    // ohne, dass es zurückgegeben werden muss.

    //Frage 3:
    // Es wird zweimal das Gleiche ausgegeben, da nicht tatsächlich auf einer Kopie gearbeitet wurde, sondern immer auf
    // das gleiche Array zugegriffen wurde. In printContentFilteredArray wird das Array ja nur copiedArray bezeichnet, aber
    // nicht wirklich kopiert, es wird dann ja nur auf workArray zugegriffen.

    //Frage 4:
    // Es wird der alte Array-Inhalt ausgegeben, da in der Methode fillArrayWithNewContent nicht mit dem mitgegebenen workArray gearbeitet wird,
    // sondern in der Methode ein neues Array helpArray angelegt wird. Das wirkt aber nur lokal in der Methode und hat keine Auswirkung
    // mehr in MAin dann. Das workArray wird daher nie wirklich modifiziert und gibt den alten Array-Inhalt zurück.
    // (mit Debugger durchgehen)

    //**************************************************************************
    //**** Zusatzfragen ***
    //**************************************************************************
    //Frage 1:
    // Datentyp Integer (bzw. short , byte oder char )

    //Frage 2:
    // Nein nicht zwingend, da sie sonst automatisch initailisiert werden. (int - Arrays werden zb immer mit 0 initalisiert)

    //Frage 3:
    // in dem man ein neues Array anlegt und bei diesem eine andere Länge festlegt.
    // Bei erstellen Referenzen kann die Länge variiert werden.

    //Frage 4:
    // indem man eine For-Schleife erstellt, welche jeden Wert des Arrays durchläuft und diesem einen neuen Array zuweist
    // Alternative kann man auch die Methode System.arraycopy() verwenden

    //Frage 5:
    // Ja.

    //Frage 6:
    // Nein es ist nicht sinnvoll, zwei Arrays mit dem Operator == zu vergleichen,
    // da dieser nur die Referenzen der Arrays vergleicht und nicht den tatsächlichen Inhalt der Arrays.
    // stattdessen mit "equals" vergleichen




}


