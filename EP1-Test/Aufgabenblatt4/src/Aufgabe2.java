/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        //a
        int[] integerArray = {6, 1, 8, 2, 5, 3, 4, 7, 9, 0};


        for (int i = 0; i < integerArray.length; i++) {
            System.out.print(integerArray[i]);

            if(i != integerArray.length-1)
            {
                System.out.print("#");
            }
        }
        System.out.println();

        //b
        int[] bArray = new int[12];

        int number = 6;

        for (int i = 0; i < bArray.length; i++)
        {
            bArray[i] = number;

            if (bArray[i] % 9 == 0) {
                bArray[i] = 0;
                System.out.print(bArray[i] + " ");
            }
            else {
                System.out.print(bArray[i] + " ");
            }

            number += 6;

        }
        System.out.println();


        //c
        int[] cArray = {7, 3, 2, 7, 6, 7, 7, 8, 9, 5};


        int[] newArray = new int[10];

        for(int i = 0; i < newArray.length; i++)
        {
            newArray[i] = cArray[i];
            System.out.print(newArray[i] + " ");

            if(cArray[i] == 7)
            {
                i = i+1;
                newArray[i] = -1;
                System.out.print(newArray[i] + " ");
                i = i-1;
            }
        }
        System.out.println();

        //d
        //for-schleife
        int[] dArray = new int[11];

        for(int i = 0; i < dArray.length; i++)
        {
            dArray[i] = i + 1;

        }


        System.out.print("for-Schleife: ");
        int counter = 0;
        for(int i = dArray.length-1; i >= 0; i--)
        {
            System.out.print(dArray[i]);

            counter++;
            if(counter <= dArray.length-1)
            {
                System.out.print(",");
            }
        }
        System.out.println();

        //while-schleife
        System.out.print("while-Schleife: ");


        int j = dArray.length-1;
        counter = 0;
        while(j >= 0)
        {
            System.out.print(dArray[j]);
            counter++;
            if(counter <= dArray.length-1)
            {
                System.out.print(",");
            }

            j--;
        }



    }
}

