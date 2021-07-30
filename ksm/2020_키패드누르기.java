class Solution {
    public String solution(int[] numbers, String hand) {
        int[] mid = {3, 0, 0, 0, 0, 1, 0, 0, 2};
    	int[] leftHand = {3,0};
    	int[] rightHand = {3,2};
    	
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < numbers.length; i++) {
        	int num = numbers[i];
        	if (num == 1 || num == 4 || num == 7) {
        		answer.append("L");
        		leftHand[0] = num / 3;
        		leftHand[1] = 0;
        	} else if (num == 3 | num == 6 | num == 9) {
        		answer.append("R");
        		rightHand[0] = num / 3 - 1;
        		rightHand[1] = 2;
        	} else {
        		int leftDis = Math.abs(leftHand[0] - mid[num]) + Math.abs(leftHand[1] - 1);
        		int rightDis = Math.abs(rightHand[0] - mid[num]) + Math.abs(rightHand[1] - 1);
        		
        		if (leftDis < rightDis) {
        			answer.append("L");
        			leftHand[0] = mid[num];
        			leftHand[1] = 1;
        		} else if (rightDis < leftDis || hand.equals("right")) {
        			answer.append("R");
        			rightHand[0] = mid[num];
        			rightHand[1] = 1;
        		} else if (hand.equals("left")) {
        			answer.append("L");
           			leftHand[0] = mid[num];
        			leftHand[1] = 1;
        		}
        	}
        }
        return answer.toString();
    }
}
