import java.util.ArrayList;
import java.util.Scanner;

class MinMaxUtil {
    private int score;
    private int index;

    public MinMaxUtil() {
        score = 0;
        index = -1;
    }

    // constructor
    public MinMaxUtil(int score, int index) {
        this.score = score;
        this.index = index;
    }

    // getter
    public int getScore() {
        return score;
    }

    public int getIndex() {
        return index;
    }
    // setter

    public void setScore(int score) {
        this.score = score;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

public class tictactoe {
    ArrayList<Character> origBoard = new ArrayList<Character>();
    Character PLAYER = 'X';
    Character BOT = 'O';
    Boolean PLAY;
    Integer noOfComparision = 0;

    tictactoe() {
        PLAY = true;
        for (int i = 0; i < 9; i++) {
            origBoard.add(' ');
        }
    }

    void displayBoard() {
        System.out.println();
        System.out.println("\t ____ \t  ____ ");
        System.out.println("\t|   |   |   |\t |   |   |   |");
        System.out.println("\t| " + origBoard.get(0) + " | " + origBoard.get(1) + " | " + origBoard.get(2) + " |\t | "
                + 0 + " | " + 1 + " | " + 2 + " |");
        System.out.println("\t|_|_|_|\t |_|_|_|");
        System.out.println("\t|   |   |   |\t |   |   |   |");
        System.out.println("\t| " + origBoard.get(3) + " | " + origBoard.get(4) + " | " + origBoard.get(5) + " |\t | "
                + 3 + " | " + 4 + " | " + 5 + " |");
        System.out.println("\t|_|_|_|\t |_|_|_|");
        System.out.println("\t|   |   |   |\t |   |   |   |");
        System.out.println("\t| " + origBoard.get(6) + " | " + origBoard.get(7) + " | " + origBoard.get(8) + " |\t | "
                + 6 + " | " + 7 + " | " + 8 + " |");
        System.out.println("\t|_|_|_|\t |_|_|_|");
        System.out.println();
        System.out.println("\t\tPlayer: " + PLAYER + "  Bot: " + BOT);
    }

    public int turn(int pos, Character player) {
        if (origBoard.get(pos) != ' ') {
            System.out.println("Already Choosen");
            return 1;
        }
        origBoard.set(pos, player);
        Boolean gameWon = checkWin(origBoard, player);
        if (gameWon) {
            gameOver(player);
            return 2;
        }
        return 0;
    }

    public void declareWinner(String opString) {
        PLAY = false;
        System.out.println("-----------------------");
        System.out.println(opString);
        System.out.println("-----------------------");
    }

    public void gameOver(Character player) {
        declareWinner(player == PLAYER ? "You Win!" : "You lose.");
    }

    public Boolean checkWin(ArrayList<Character> board, char player) {
        Boolean hori = checkHorizontal(board, player);
        Boolean verti = checkVertical(board, player);
        Boolean diag = checkDiagnol(board, player);
        if (hori || verti || diag) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Integer> emptyCells(ArrayList<Character> board) {
        ArrayList<Integer> empCells = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i) == ' ') {
                empCells.add(i);
            }
        }
        return empCells;
    }

    public int bestSpot() {
        noOfComparision = 0;
        return miniMax(origBoard, true).getIndex();
        // return emptyCells(origBoard).get(0);
    }

    public MinMaxUtil miniMax(ArrayList<Character> dummy, Boolean isMaximizer) {
        noOfComparision += 1;
        ArrayList<Integer> empList = emptyCells(dummy);

        MinMaxUtil score = new MinMaxUtil(0, -1);
        if (checkWin(dummy, PLAYER)) {
            score.setScore(-10);
            return score;
        } else if (checkWin(dummy, BOT)) {
            score.setScore(20);
            return score;
        } else if (empList.size() == 0) {
            return score;
        }

        ArrayList<MinMaxUtil> moves = new ArrayList<MinMaxUtil>();

        for (int i = 0; i < empList.size(); i++) {
            MinMaxUtil move = new MinMaxUtil();
            move.setIndex(empList.get(i));

            if (isMaximizer) {
                dummy.set(empList.get(i), BOT);
                MinMaxUtil sc = miniMax(dummy, false);
                move.setScore(sc.getScore());
            } else {
                dummy.set(empList.get(i), PLAYER);
                MinMaxUtil sc = miniMax(dummy, true);
                move.setScore(sc.getScore());
            }

            dummy.set(empList.get(i), ' ');
            moves.add(move);
        }

        int bestMove = -1;
        if (isMaximizer) {
            int bestScore = Integer.MIN_VALUE;
            for (int j = 0; j < moves.size(); j++) {
                if (moves.get(j).getScore() > bestScore) {
                    bestScore = moves.get(j).getScore();
                    bestMove = j;
                }
            }
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int j = 0; j < moves.size(); j++) {
                if (moves.get(j).getScore() < bestScore) {
                    bestScore = moves.get(j).getScore();
                    bestMove = j;
                }
            }
        }

        return moves.get(bestMove);
    }

    public Boolean checkTie(ArrayList<Character> board) {
        if (emptyCells(board).size() == 0) {
            declareWinner("Tie Game");
            return true;
        } else {
            return false;
        }
    }

    public void playGame() {
        displayBoard();
        while (PLAY) {
            Scanner ip = new Scanner(System.in);
            int choice = ip.nextInt();
            int status = turn(choice, PLAYER);
            if (status == 2)
                break;
            if (status == 0 && !checkTie(origBoard)) {
                turn(bestSpot(), BOT);
                System.out.println("Number of Comparisions = " + noOfComparision);
            }
            displayBoard();
        }
    }

    public Boolean checkHorizontal(ArrayList<Character> board, char player) {
        Boolean chek = true;
        for (int i = 0; i < 3; i++) {
            chek = true;
            for (int j = 0; j < 3; j++) {
                if (board.get(i * 3 + j) != player) {
                    chek = false;
                    break;
                }
            }
            if (chek)
                return true;
        }
        return false;
    }

    public Boolean checkVertical(ArrayList<Character> board, char player) {
        Boolean chek = true;
        for (int i = 0; i < 3; i++) {
            chek = true;
            for (int j = 0; j < 3; j++) {
                if (board.get(j * 3 + i) != player) {
                    chek = false;
                    break;
                }
            }
            if (chek)
                return true;
        }
        return false;
    }

    public Boolean checkDiagnol(ArrayList<Character> board, char player) {
        Boolean chek = true;
        for (int i = 0; i < 3; i++) {
            if (board.get(i * 3 + i) != player) {
                chek = false;
                break;
            }
        }
        if (chek)
            return true;
        chek = true;
        for (int i = 0; i < 3; i++) {
            if (board.get(i * 3 + (2 - i)) != player) {
                chek = false;
                break;
            }
        }
        if (chek)
            return true;
        return false;
    }

    public static void main(String[] args) {
        tictactoe ob = new tictactoe();
        ob.playGame();
    }
}