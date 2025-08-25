import java.util.*;
import java.io.*;

/*
 * X가 먼저 두어야 한다.
 * X의 개수가 O의 개수와 같거나, 하나 많아야 한다.
 * 게임판이 가득 차거나, 3칸을 이으면 게임이 끝난다.
 *  -> 게임이 끝난 이후에 더 두었으면 안된다.
 */
public class Main {
	
	// order == true : x 차례, order == false : o 차례
	public static boolean dfs(int depth, int total, char[][] checkBoard, char[][] board, boolean order) {
		if (depth == total) {
			if (depth == 9) {
				return true;
			}
			
			if (checkBoard[0][0] != '.' && checkBoard[0][0] == checkBoard[0][1] && checkBoard[0][1] == checkBoard[0][2]) {
				return true;
			} else if (checkBoard[1][0] != '.' && checkBoard[1][0] == checkBoard[1][1] && checkBoard[1][1] == checkBoard[1][2]) {
				return true;
			} else if (checkBoard[2][0] != '.' && checkBoard[2][0] == checkBoard[2][1] && checkBoard[2][1] == checkBoard[2][2]) {
				return true;
			} else if (checkBoard[0][0] != '.' && checkBoard[0][0] == checkBoard[1][0] && checkBoard[1][0] == checkBoard[2][0]) {
				return true;
			} else if (checkBoard[0][1] != '.' && checkBoard[0][1] == checkBoard[1][1] && checkBoard[1][1] == checkBoard[2][1]) {
				return true;
			} else if (checkBoard[0][2] != '.' && checkBoard[0][2] == checkBoard[1][2] && checkBoard[1][2] == checkBoard[2][2]) {
				return true;
			} else if (checkBoard[0][0] != '.' && checkBoard[0][0] == checkBoard[1][1] && checkBoard[1][1] == checkBoard[2][2]) {
				return true;
			} else if (checkBoard[0][2] != '.' && checkBoard[0][2] == checkBoard[1][1] && checkBoard[1][1] == checkBoard[2][0]) {
				return true;
			}
			
			return false;
		}
		
		if (checkBoard[0][0] != '.' && checkBoard[0][0] == checkBoard[0][1] && checkBoard[0][1] == checkBoard[0][2]) {
			return false;
		} else if (checkBoard[1][0] != '.' && checkBoard[1][0] == checkBoard[1][1] && checkBoard[1][1] == checkBoard[1][2]) {
			return false;
		} else if (checkBoard[2][0] != '.' && checkBoard[2][0] == checkBoard[2][1] && checkBoard[2][1] == checkBoard[2][2]) {
			return false;
		} else if (checkBoard[0][0] != '.' && checkBoard[0][0] == checkBoard[1][0] && checkBoard[1][0] == checkBoard[2][0]) {
			return false;
		} else if (checkBoard[0][1] != '.' && checkBoard[0][1] == checkBoard[1][1] && checkBoard[1][1] == checkBoard[2][1]) {
			return false;
		} else if (checkBoard[0][2] != '.' && checkBoard[0][2] == checkBoard[1][2] && checkBoard[1][2] == checkBoard[2][2]) {
			return false;
		} else if (checkBoard[0][0] != '.' && checkBoard[0][0] == checkBoard[1][1] && checkBoard[1][1] == checkBoard[2][2]) {
			return false;
		} else if (checkBoard[0][2] != '.' && checkBoard[0][2] == checkBoard[1][1] && checkBoard[1][1] == checkBoard[2][0]) {
			return false;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (checkBoard[i][j] != '.') continue;
				
				if (order && board[i][j] == 'X') {
					checkBoard[i][j] = 'X';
					if (dfs(depth+1, total, checkBoard, board, !order)) {
						return true;
					}
					checkBoard[i][j] = '.';
				}
				
				if (!order && board[i][j] == 'O') {
					checkBoard[i][j] = 'O';
					if (dfs(depth+1, total, checkBoard, board, !order)) {
						return true;
					}
					checkBoard[i][j] = '.';
				}
			}
		}
		
		return false;
	}
	
	
	public static boolean isAvailable(char[][] board) {
		int xcnt = 0;
		int ocnt = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 'X') {
					xcnt++;
				} else if (board[i][j] == 'O') {
					ocnt++;
				}
			}
		}
		
		if (xcnt != ocnt && xcnt != ocnt+1) {
			return false;
		}
		
		char[][] checkBoard = new char[3][3];
		
		for (int i = 0; i < 3; i++) {
			Arrays.fill(checkBoard[i], '.');
		}

		return dfs(0, xcnt+ocnt, checkBoard, board, true);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String tmp = br.readLine();
			
			if (tmp.equals("end")) break;
			
			char[][] board = new char[3][3];
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = tmp.charAt(i*3 + j);
				}
			}
			
			if (isAvailable(board)) {
				sb.append("valid").append("\n");
			} else {
				sb.append("invalid").append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
