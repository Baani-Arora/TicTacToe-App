import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static char human;
    static char computer;
    static boolean humanTurn;

    public static void main(String[] args) {
        initializeBoard();
        toss();
        printBoard();

        int slot = getUserInput();
        int[] pos = getBoardPosition(slot);

        System.out.println("Row: " + pos[0] + ", Col: " + pos[1]);
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void toss() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            human = 'X';
            computer = 'O';
            humanTurn = true;
            System.out.println("Human starts");
        } else {
            human = 'O';
            computer = 'X';
            humanTurn = false;
            System.out.println("Computer starts");
        }
    }

    static int getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter slot (1-9): ");
        return sc.nextInt();
    }

    static int[] getBoardPosition(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }
}