package Pro_Level1;

public class dart_kakao {
	/*
	 * 1. 다트게임: 세 차례 던져 합계를 구하는 게임.
	 * 2. 계산
	 *  - 점수(0 <= 점수  <= 10) * 보너스[s(1제곱), d(2제곱),t(3제곱)]으로 계산.
	 *  - 점수마다 하나씩 존재해야 함.
	 * 3. 옵션
	 * 	- 스타상(*) : 전에 받은 점수 2배(첫번에 기회에 나올 경우, 첫번째 점수만 2배)
	 *  - 아차상(#) : 해당 점수는 마이너스
	 *  - 스타상과 아차상은 중첩가능(아차상 -> 스타상 : -2 * 점수)
	 *  - 스타상은 점수만다 둘 중 하나만 존재 가능
 	 */
	
	/* 
	 * idea
	 * 1S2D*3T
	 * 1. String을 character배열에 담는다.
	 *  1-1. 정규식 사용하기
	 *   - 숫자(점수) -> pointArr(int)
	 *   - 영어(보너스) -> bonusArr(Character)
	 *   - 특수문자(옵션) -> optionArr(Character)
	 * 2. 숫자 -> 영어  -> 특수문자 순으로 탐색해서 연산
	 */
	
	public int solution(String DartResult) {
		int answer = 0;
		//1.결과를 숫자부분의 위치 파악해서  분리하기(10의 경우도 고려하기)
		int[] pointIndexArr = getPointIndexArr(DartResult);
		//2.해당 턴의 점수, 보너스, 옵션값 배열에 넣기.
		String[] turnArr = getTurnArr(DartResult, pointIndexArr);
		//3.각각 배열에 점수, 보너스, 옵션 값 분리하기
		int[] point = getPointArr(turnArr);
		int[] bonus = getBonusArr(turnArr);
		char[] option =getOptionArr(turnArr);
		
		answer = getAnswer(point, bonus, option);
		
		return answer;
	}

	public int[] getPointIndexArr(String DartResult) {
		char[] resultCharArr = DartResult.toCharArray();
		int[] pointIndexArr = new int[4];
		int numIndex = 1;
		
		for (int i = 0; i < resultCharArr.length-1; i++) {
			if(resultCharArr[i] <= 57 && resultCharArr[i] >= 48) {
				pointIndexArr[numIndex++] = i;
				if(resultCharArr[i+1] == 48) {
					i++;
				}
			}
		}
		return pointIndexArr;
	}
	
	public String[] getTurnArr(String DartResult,int[] pointIndexArr) {
		String[] turnArr = new String[4];
		for (int i = 1; i < pointIndexArr.length; i++) {
			int nowIndex = pointIndexArr[i];
			
			if(i == pointIndexArr.length - 1) {
				turnArr[i] = DartResult.substring(nowIndex, DartResult.length());	
			}else {
				int nextIndex = pointIndexArr[i+1];
				turnArr[i] = DartResult.substring(nowIndex, nextIndex);
			}
		}
		for(String out : turnArr) {
			System.out.print(out + " ");
		}
		return turnArr;
	}
	
	public int[] getPointArr(String[] turnArr) {
		int[] point = new int[4];
		for (int i = 1; i < turnArr.length; i++) {
			point[i] = Integer.parseInt(turnArr[i].replaceAll("[^0-9]", ""));
		}
		for(int out : point) {
			System.out.print(out + " ");
		}
		return point;
	}
	
	public int[] getBonusArr(String[] turnArr) {
		int[] bonus = new int[4];
		char tempChar;
		for (int i = 1; i < turnArr.length; i++) {
			tempChar = turnArr[i].replaceAll("[^a-zA-Z]", "").charAt(0);
			if(tempChar ==83)	bonus[i] = 1;
			if(tempChar == 68)	bonus[i] = 2; 
			if(tempChar == 84)	bonus[i] = 3; 
			
		}
		
		for(int out : bonus) {
			System.out.print(out + " ");
		}
		return bonus;
	}
	
	public char[] getOptionArr(String[] turnArr) {
		char[] option = new char[4];
		String temp;
		for (int i = 1; i < turnArr.length; i++) {
			temp = turnArr[i].replaceAll("[0-9a-zA-Z]", "");
			if(temp.equals("")) {
				option[i] = " ".charAt(0);
			}else {
				option[i] = temp.charAt(0);
			}
		}
		
		for(char test : option) {
			System.out.print(test + " ");
		}
		return option;
	}
	
	private int getAnswer(int[] point, int[] bonus, char[] option) {
		int answer = 0;
		int[] sumArr = new int[4];
		int index = sumArr.length;
		
		for (int i = 0; i < index; i++) {
			int nowCal = (int) Math.pow(point[i], bonus[i]);	
			sumArr[i] = nowCal;
			
			//option: #
			if(option[i] == 42) {
				if(i == 1)	sumArr[i] *= 2;
				if(i > 1)	{
					sumArr[i] *= 2;
					sumArr[i-1] *= 2;
				}
			}
			//option: *
			if(option[i] == 35)	sumArr[i] = -sumArr[i];
		}
		
		for (int i = 1; i < sumArr.length; i++) {
			answer += sumArr[i];
			System.out.println("sumArr[" + i + "]: " + sumArr[i]);
			System.out.println("answer : " + answer);
		}
		
		return answer;
	}
	//프로그래머스 가독성 좋은 풀이
	public int solution2(String dartResult) {
		String[] arrTemp = dartResult.split("");
		String sTarget = "";
		int nBeforeScore = 0;
		int nPresentScore = 0;
		int nTotalScore = 0;

		for (int i = 0; i < arrTemp.length; i++) {
			if (arrTemp[i].equals("1") || arrTemp[i].equals("2") || arrTemp[i].equals("3") || arrTemp[i].equals("4")
					|| arrTemp[i].equals("5") || arrTemp[i].equals("6") || arrTemp[i].equals("7")
					|| arrTemp[i].equals("8") || arrTemp[i].equals("9") || arrTemp[i].equals("0")) {
				sTarget += arrTemp[i];
			} else if (arrTemp[i].equals("S") || arrTemp[i].equals("D") || arrTemp[i].equals("T")) {
				nTotalScore += nBeforeScore;
				nBeforeScore = nPresentScore;
				nPresentScore = Integer.parseInt(sTarget);
				sTarget = "";
				if (arrTemp[i].equals("D")) {
					nPresentScore = (int) Math.pow(nPresentScore, 2);
				} else if (arrTemp[i].equals("T")) {
					nPresentScore = (int) Math.pow(nPresentScore, 3);
				}
			} else if (arrTemp[i].equals("*") || arrTemp[i].equals("#")) {
				if (arrTemp[i].equals("*")) {
					nBeforeScore = nBeforeScore * 2;
					nPresentScore = nPresentScore * 2;
				} else if (arrTemp[i].equals("#")) {
					nPresentScore = nPresentScore * -1;
				}
			}
		}
		nTotalScore += nBeforeScore;
		nTotalScore += nPresentScore;

		return nTotalScore;
	}
	
	public static void main(String[] args) {
		dart_kakao sol = new dart_kakao();
		String dartResult1 = "1S2D*3T"; //[숫자][(숫자)][영어 대문자][(특수문자)]
		String dartResult2 = "1D2S#10S";
		String dartResult3 = "1D2S0T";
		String dartResult4 = "1S*2T*3S";
		String dartResult5 = "1T2D3D#";
		String dartResult6 = "1D2S3T*";
		String dartResult7 = "10D10S10T*";
		
		sol.solution(dartResult6);
	}
}
