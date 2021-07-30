import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        
        int[][] disOne = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] disStraightTwo = {{0, 2}, {0, -2}, {2, 0}, {-2, 0}};
        int[][] disDiagonalTwo = {{1, 1} ,{1, -1}, {-1, 1}, {-1, -1}};
        
        for (int i = 0; i < places.length; i++) {
        	top : 
			for (int r = 0; r < 5; r++) {
				for(int c = 0; c < 5; c++) {
					if (places[i][r].charAt(c) == 'P') {
						// 거리가 한 칸인 자리 탐색
						for (int j = 0; j < 4; j++) {
							int nr = disOne[j][0] + r;
							int nc = disOne[j][1] + c;
							
							if (nr < 5 && nr > -1 && nc < 5 && nc > -1 && places[i][nr].charAt(nc) == 'P') {
								answer[i] = 0;
								break top;
							}
						}
						
						// 거리가 직선으로 두 칸인 자리 탐색
						for (int j = 0; j < 4; j++) {
							int nr = disStraightTwo[j][0] + r;
							int nc = disStraightTwo[j][1] + c;
							
							if (nr < 5 && nr > -1 && nc < 5 && nc > -1 && places[i][nr].charAt(nc) == 'P') {
								// 파티션이 없는 경우에 거리두기 실패
								nr = disStraightTwo[j][0] / 2 + r;
								nc = disStraightTwo[j][1] / 2 + c;
								if (places[i][nr].charAt(nc) != 'X') {
									answer[i] = 0;
									break top;
								}
							}
						}
						
						// 거리가 대각선으로 두 칸인 자리 탐색 
						for (int j = 0; j < 4; j++) {
							int nr = disDiagonalTwo[j][0] + r;
							int nc = disDiagonalTwo[j][1] + c;
							
							if (nr < 5 && nr > -1 && nc < 5 && nc > -1 && places[i][nr].charAt(nc) == 'P') {
								// 파티션이 없는 경우에 거리두기 실패
								nr = r;
								nc = disDiagonalTwo[j][1] + c;
								if (places[i][nr].charAt(nc) != 'X') {
									answer[i] = 0;
									break top;
								}
								
								nr = disDiagonalTwo[j][0] + r;
								nc = c;
								if (places[i][nr].charAt(nc) != 'X') {
									answer[i] = 0;
									break top;
								}
							}
						}
					}
				}
			}
		}
        
        return answer;
    }
}
