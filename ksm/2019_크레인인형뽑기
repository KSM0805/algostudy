import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] lastPos = new int[board.length];	// 각 열마다 제일 위에 있는 인형의 위치
        Arrays.fill(lastPos, Integer.MAX_VALUE);
        
        for (int i = 0; i < lastPos.length; i++) {	// 열 번호 
			for (int j = 0; j < lastPos.length; j++) {	// 행 번호
				if (board[j][i] != 0) {
					lastPos[i] = j;
					break;
				}
			}
		}
        
        Stack<Integer> stack = new Stack<>(); // 쌓일 인형들의 공간
        
        for (int i = 0; i < moves.length; i++) {
			int col = moves[i] - 1;
			if (lastPos[col] < board.length) {
				
				if (!stack.isEmpty() && stack.peek() == board[lastPos[col]][col]) {
					answer+= 2;
					stack.pop();
				} else {
					stack.add(board[lastPos[col]][col]);
				}
				lastPos[col]++;
			}
		}
        return answer;
    }
}
