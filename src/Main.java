import java.util.Scanner;

public class Main {
    static void printGrind(char[][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static void getX(char[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        boolean move = false;
        while (!move) {
            System.out.print("Enter the coordinates: ");
            String cords = scanner.nextLine();
            cords = cords.replaceAll("\\s","");
            if (cords.matches("^[0-9]+$")) {
                if (cords.matches("^[1-3]+$")) {
                    int x = Character.getNumericValue(cords.charAt(0));
                    int y = Character.getNumericValue(cords.charAt(1));
                    if (matrix[x - 1][y - 1] != 'X' && matrix[x -1][y - 1] != 'O') {
                        matrix[x - 1][y - 1] = 'X';
                        move = true;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }

    static void getO(char[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        boolean move = false;
        while (!move) {
            System.out.print("Enter the coordinates: ");
            String cords = scanner.nextLine();
            cords = cords.replaceAll("\\s","");
            if (cords.matches("^[0-9]+$")) {
                if (cords.matches("^[1-3]+$")) {
                    int x = Character.getNumericValue(cords.charAt(0));
                    int y = Character.getNumericValue(cords.charAt(1));
                    if (matrix[x - 1][y - 1] != 'X' && matrix[x -1][y - 1] != 'O') {
                        matrix[x - 1][y - 1] = 'O';
                        move = true;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }

    static boolean checkStatus(char[][] matrix) {
        String diagonalOne = "" + matrix[0][0] + matrix[1][1] + matrix[2][2];
        String diagonalTwo = "" + matrix[0][2] + matrix[1][1] + matrix[2][0];
        int countDraw = 0;
        for (int i = 0; i < matrix.length; i++) {
            String checkRow = "";
            String checkCol = "";
            for (int j = 0; j < matrix[i].length; j++) {
                checkRow = checkRow + matrix[i][j];
                checkCol = checkCol + matrix[j][i];
                if (checkRow.equals("XXX") || checkCol.equals("XXX")) {
                    printGrind(matrix);
                    System.out.println("X wins");
                    return true;
                } else if (checkRow.equals("OOO") || checkCol.equals("OOO")) {
                    printGrind(matrix);
                    System.out.println("O wins");
                    return true;
                } else if (diagonalOne.equals("XXX") || diagonalTwo.equals("XXX")) {
                    printGrind(matrix);
                    System.out.println("X wins");
                    return true;
                } else if (diagonalOne.equals("OOO") || diagonalTwo.equals("OOO")) {
                    printGrind(matrix);
                    System.out.println("O wins");
                    return true;
                } if (matrix[i][j] != ' ') {
                    ++countDraw;
                    if (countDraw == 9) {
                        printGrind(matrix);
                        System.out.println("Draw");
                        return true;
                    }
                }
            }
        }
        return false;
    }




    public static void main(String[] args) {
        char[][] matrix = new char[3][3];


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ' ';
            }

        }
        while (!checkStatus(matrix)) {
            printGrind(matrix);
            getX(matrix);
            if (checkStatus(matrix)) {
                break;
            }
            printGrind(matrix);
            getO(matrix);
        }
    }
}
