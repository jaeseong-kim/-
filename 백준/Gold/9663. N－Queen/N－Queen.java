import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] board;
    public static int selectedCnt;
    public static int QUEEN_CNT;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        QUEEN_CNT = N;
        answer = 0;
        selectedCnt = 0;
        recursion(0, 0);

        System.out.println(answer);

    }

    public static void recursion(int currentQueen, int row) {
        if (currentQueen == QUEEN_CNT) {
            if (selectedCnt == QUEEN_CNT) {
                answer = answer + 1;
            }
            return;
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == 0) {
                checkPath(row, j);
                selectedCnt = selectedCnt + 1;
                recursion(currentQueen + 1, row + 1);
                selectedCnt = selectedCnt - 1;
                uncheckPath(row, j);
            }
        }

    }

    public static void checkPath(int row, int col) {
        // 가로
        for (int i = 0; i < board[row].length; i++) {
            board[row][i] = board[row][i] + 1;
        }

        // 세로
        for (int i = 0; i < board.length; i++) {
            if (i == row) {
                continue;
            }
            board[i][col] = board[i][col] + 1;
        }

        // 대각선
        int tmpRow = row - 1;
        int tmpCol = col - 1;

        while (true) {
            if (tmpRow < 0 || tmpCol < 0 || tmpRow >= board.length || tmpCol >= board[0].length) {
                break;
            }
            board[tmpRow][tmpCol] = board[tmpRow][tmpCol] + 1;
            tmpRow = tmpRow - 1;
            tmpCol = tmpCol - 1;
        }

        tmpRow = row - 1;
        tmpCol = col + 1;
        while (true) {
            if (tmpRow < 0 || tmpCol < 0 || tmpRow >= board.length || tmpCol >= board[0].length) {
                break;
            }
            board[tmpRow][tmpCol] = board[tmpRow][tmpCol] + 1;
            tmpRow = tmpRow - 1;
            tmpCol = tmpCol + 1;
        }

        tmpRow = row + 1;
        tmpCol = col - 1;
        while (true) {
            if (tmpRow < 0 || tmpCol < 0 || tmpRow >= board.length || tmpCol >= board[0].length) {
                break;
            }
            board[tmpRow][tmpCol] = board[tmpRow][tmpCol] + 1;
            tmpRow = tmpRow + 1;
            tmpCol = tmpCol - 1;
        }

        tmpRow = row + 1;
        tmpCol = col + 1;
        while (true) {
            if (tmpRow < 0 || tmpCol < 0 || tmpRow >= board.length || tmpCol >= board[0].length) {
                break;
            }
            board[tmpRow][tmpCol] = board[tmpRow][tmpCol] + 1;
            tmpRow = tmpRow + 1;
            tmpCol = tmpCol + 1;
        }
    }

    public static void uncheckPath(int row, int col) {
        // 가로
        for (int i = 0; i < board[row].length; i++) {
            board[row][i] = board[row][i] - 1;
        }

        // 세로
        for (int i = 0; i < board.length; i++) {
            if (i == row) {
                continue;
            }
            board[i][col] = board[i][col] - 1;
        }

        // 대각선
        int tmpRow = row - 1;
        int tmpCol = col - 1;

        while (true) {
            if (tmpRow < 0 || tmpCol < 0 || tmpRow >= board.length || tmpCol >= board[0].length) {
                break;
            }
            board[tmpRow][tmpCol] = board[tmpRow][tmpCol] - 1;
            tmpRow = tmpRow - 1;
            tmpCol = tmpCol - 1;
        }

        tmpRow = row - 1;
        tmpCol = col + 1;
        while (true) {
            if (tmpRow < 0 || tmpCol < 0 || tmpRow >= board.length || tmpCol >= board[0].length) {
                break;
            }
            board[tmpRow][tmpCol] = board[tmpRow][tmpCol] - 1;
            tmpRow = tmpRow - 1;
            tmpCol = tmpCol + 1;
        }

        tmpRow = row + 1;
        tmpCol = col - 1;
        while (true) {
            if (tmpRow < 0 || tmpCol < 0 || tmpRow >= board.length || tmpCol >= board[0].length) {
                break;
            }
            board[tmpRow][tmpCol] = board[tmpRow][tmpCol] - 1;
            tmpRow = tmpRow + 1;
            tmpCol = tmpCol - 1;
        }

        tmpRow = row + 1;
        tmpCol = col + 1;
        while (true) {
            if (tmpRow < 0 || tmpCol < 0 || tmpRow >= board.length || tmpCol >= board[0].length) {
                break;
            }
            board[tmpRow][tmpCol] = board[tmpRow][tmpCol] - 1;
            tmpRow = tmpRow + 1;
            tmpCol = tmpCol + 1;
        }
    }
}