import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {1,1};
		HashMap<String, Integer> names = new HashMap<String, Integer>();
		int min = 0;
		int max = 0;
		
		names.put(gems[0], 0);
		
		for (int i = 1; i < gems.length; i++) {
			// 이미 카운트 되었던 보석이면 
			if (names.containsKey(gems[i])) {
				int oldPos = names.get(gems[i]);
				
				// 새로 넣기
				names.put(gems[i], i);
				max = i;
				
				// 지금 넣은 보석이 최소 위치였다면
				if (oldPos == min) {
					min = Integer.MAX_VALUE;
					for (int pos : names.values()) {
						min = Math.min(min, pos);
					}
					// 최대 위치 - 최소 위치가 더 작으면 업데이트
					if (max - min < answer[1] - answer[0]) {
						answer[0] = min + 1;
						answer[1] = max + 1;
					}
				}
			} else { // 보석 새로 추가 
				names.put(gems[i], i);
				max = i;
                answer[0] = min + 1;
				answer[1] = max + 1;
			}
		}
		
        return answer;
    }
}
