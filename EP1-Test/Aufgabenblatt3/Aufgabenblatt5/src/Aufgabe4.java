/*
    Aufgabe 4) Zweidimensionale Arrays und Rekursion - Labyrinth
*/
public class Aufgabe4 {

    public static void main(String[] args) {
        int mazeType = 1;
        //int[][] direction = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; //EAST,NORTH,WEST,SOUTH
        //int[][] direction = new int[][]{{-1,0},{0,-1},{1,0},{0,1}}; //NORTH,WEST,SOUTH,EAST
        int[][] direction = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};//WEST,SOUTH,EAST,NORTH
        //int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};//SOUTH,EAST,NORTH,WEST

        char[][] myMaze = null;
        if (mazeType == 0) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   E".toCharArray(),
                    "***** *    *  *".toCharArray(),
                    "*   * *********".toCharArray(),
                    "*             *".toCharArray(),
                    "***********   *".toCharArray(),
                    "*             *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "*   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* ********** **".toCharArray(),
                    "*        *    *".toCharArray(),
                    "*  S *        *".toCharArray(),
                    "***************".toCharArray()
            };
        } else if (mazeType == 1) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   E".toCharArray(),
                    "***** *    *  *".toCharArray(),
                    "*   * ******* *".toCharArray(),
                    "*             *".toCharArray(),
                    "***********   *".toCharArray(),
                    "*             *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "*   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* ********** **".toCharArray(),
                    "*        *    *".toCharArray(),
                    "*  S *        *".toCharArray(),
                    "***************".toCharArray()
            };
        } else if (mazeType == 2) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   *".toCharArray(),
                    "***** *   * * *".toCharArray(),
                    "*   * ******* *".toCharArray(),
                    "*   *         *".toCharArray(),
                    "* *********   *".toCharArray(),
                    "*   *         *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "E   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* *************".toCharArray(),
                    "* *      *    *".toCharArray(),
                    "*    *       S*".toCharArray(),
                    "***************".toCharArray()
            };
        }

        // Dieser Teil darf (muss aber nicht) verändert werden!!****************
        printMaze(myMaze);
        int[] startPoint = getStartPoint(myMaze);
        if (startPoint[0] == 0 && startPoint[1] == 0) {
            System.out.println("STARTPOINT MISSING!");
        } else {
            if (existsPathToExit(myMaze, startPoint[0], startPoint[1], direction)) {
                System.out.println("EXIT FOUND!");
            } else {
                System.out.println("EXIT NOT FOUND!");
            }
        }
        myMaze[startPoint[0]][startPoint[1]] = 'S';
        printMaze(myMaze);
        //**********************************************************************
    }

    private static int[] getStartPoint(char[][] maze) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        int[] startPoint = new int[2]; // Hier wird ein Array mit zwei Elementen erstellt, um die Koordinaten des Startpunkts zu speichern.
        for (int i = 0; i < maze.length; i++) { // zwei Schleifen um durch jedes Element im Labyrinth-Array
            for (int j = 0; j < maze[i].length; j++) {

                //Wenn das aktuelle Element den Wert 'S' hat,
                // werden die Koordinaten des Startpunkts im startPoint-Array gespeichert
                // und das Array wird zurückgegeben.
                if (maze[i][j] == 'S') {
                    startPoint[0] = i;
                    startPoint[1] = j;
                    return startPoint;
                }
            }
        }
        return null; // wenn kein Element den Wert S hatte, wird null zurückgegeben
    }

    private static boolean existsPathToExit(char[][] maze, int row, int col, int[][] direction) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        // Überprüft, ob die aktuelle Position innerhalb des Labyrinths liegt
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[row].length) {
            return false;
        }

        // Überprüft, ob die aktuelle Position der Ausgang ist
        if (maze[row][col] == 'E') {
            return true;
        }

        // Überprüft, ob die aktuelle Position bereits besucht wurde oder eine Wand ist
        if (maze[row][col] == 'V' || maze[row][col] == '*') {
            return false;
        }

        // Markiert die aktuelle Position als besucht
        maze[row][col] = 'V';

        // Suche in jeder möglichen Richtung nach dem Ausgang
        for (int i = 0; i < direction.length; i++) {
            int newRow = row + direction[i][0];
            int newCol = col + direction[i][1];
            if (existsPathToExit(maze, newRow, newCol, direction)) {
                maze[row][col] = 'U';
                return true;
            }
        }
        // Kein Ausgang gefunden
        return false;
    }


    private static void printMaze(char[][] maze) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        for (int i = 0; i < maze.length; i++) { // Zeile
            //es wird Zeile für Zeile das zweidimensionale Array durchlaufen
            for (int j = 0; j < maze[i].length; j++) { //Element in der Zeile
                System.out.print(maze[i][j]);//Jedes Element in der Zeile wird ausgegeben
            }
            System.out.println();
        }
    }
}


