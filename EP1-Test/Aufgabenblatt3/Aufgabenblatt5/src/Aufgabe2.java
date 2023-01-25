/*
    Aufgabe 2) Zweidimensionale Arrays - Sortieren und Filtern
*/
public class Aufgabe2 {

    private static double[][] genCircleFilter(int n, double radius) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        // Überprüft, ob n ungerade und größer oder gleich 1 ist
        if (n % 2 == 0 || n < 1) {
            return null;
        }

        double[][] circleFilter = new double[n][n];
        // Berechnt den Mittelpunkt des Arrays
        int center = (n - 1) / 2;
        // Berechnt die euklidische Distanz für jedes Element im Array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double distance = Math.sqrt(Math.pow(i - center, 2) + Math.pow(j - center, 2));
                if (distance < radius) {
                    // Setzt das Element auf 1, wenn der Abstand kleiner als radius ist
                    circleFilter[i][j] = 1;
                } else {
                    // Setzt das Element auf 0, wenn der Abstand größer oder gleich radius ist
                    circleFilter[i][j] = 0;
                }
            }
        }
        return circleFilter;
    }

    private static double[][] applyFilter(double[][] workArray, double[][] filterArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        int yCounter = (workArray.length - filterArray.length) + 1; //row
        int xCounter = (workArray[0].length - filterArray[0].length) + 1;//col

        if (xCounter < 1)
        {
            xCounter = 1;
        }
        else if (yCounter < 1)
        {
            yCounter = 1;
        }

        double[][] result = new double[workArray.length][workArray[0].length];

        for (int i = 0; i < yCounter; i++) {
            for (int j = 0; j < xCounter; j++) {
                double sum = 0;
                int midPoint = (filterArray.length - 1) / 2;

                for (int k = 0; k < filterArray.length; k++) {
                    for (int l = 0; l < filterArray[0].length; l++) {

                        if(workArray.length >= filterArray.length)
                        {
                            sum += filterArray[k][l] + workArray[k+i][l+j];
                        }
                        else
                        {
                            if(!(l >= workArray.length-1) || !(i >= workArray.length-1))
                            {
                             sum += workArray[k+i][l+j] + filterArray[k][l];
                            }
                        }
                    }
                }
                // Speichert den Wert in result
                result[midPoint][midPoint] = sum;
            }
        }
        return result;
    }


    private static void print(double[][] workArray) {
        if (workArray != null) {
            for (int y = 0; y < workArray.length; y++) {
                for (int x = 0; x < workArray[y].length; x++) {
                    System.out.printf("%.2f", workArray[y][x]);
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] myResultArray;

        double[][] myFilter1 = genCircleFilter(3, 1.2);
        System.out.println("Output -> myFilter1 (genCircleFilter mit size = 3 und radius = 1.2):");
        print(myFilter1);

        double[][] myFilter2 = genCircleFilter(7, 2.5);
        System.out.println("Output -> myFilter2 (genCircleFilter mit size = 7 und radius = 2.5):");
        print(myFilter2);

        double[][] myArray1 = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 2, 2, 2, 0}, {0, 3, 3, 3, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray1:");
        print(myArray1);

        myResultArray = applyFilter(myArray1, myFilter1);
        System.out.println("Output -> myFilter1 applied to myArray1:");
        print(myResultArray);

        myResultArray = applyFilter(myArray1, myFilter2);
        System.out.println("Output -> myFilter2 applied to myArray1:");
        print(myResultArray);

        //Beispiel aus Aufgabenblatt
        double[][] myArray3 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        double[][] myFilter3 = {{1, 0, 0}, {1, 2, 0}, {0, 0, 3}};
        System.out.println("Output -> myArray3:");
        print(myArray3);
        System.out.println("Output -> myFilter3:");
        print(myFilter3);
        myResultArray = applyFilter(myArray3, myFilter3);
        System.out.println("Output -> myFilter3 applied to myArray3:");
        print(myResultArray);

        double[][] myArray4 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 2, 3, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray4:");
        print(myArray4);
        //TODO: Erstellen Sie den Filter aus dem Aufgabenblatt, wenden Sie ihn auf myArray4 an und geben Sie das Ergebnis mittels print() aus
    }


}
