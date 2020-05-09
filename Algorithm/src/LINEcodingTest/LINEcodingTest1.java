package LINEcodingTest;
import java.util.*;

public class LINEcodingTest1 {
//	1. 인풋을 charArr로 만들기
//	2. 배열 순서 집어넣기 만약에 뒤에 값 순서대로 값이 존재하는지 확인하기.
    public int solution(String inputString) {
        int answer = -1;
        //173:{	175:} 
        //60: < 62 : >
        //91: [ 93: ]
        //40: ( 41: )
        char[] inputArr = inputString.toCharArray();
		
		Stack<Character> bracketBox = new Stack<Character>();
		for (int i = 0; i < inputArr.length; i++) {
			if(inputArr[i] == 173) {
				bracketBox.push((char) 173);
				bracketBox.push((char)175);
			}
			
			if(inputArr[i] == 60) {
				bracketBox.push((char) 60);
				bracketBox.push((char) 62);
			}
			
			if(inputArr[i] == 91) {
				bracketBox.push((char) 91);
				bracketBox.push((char) 93);
			}
			if(inputArr[i] == 40) {
				bracketBox.push((char) 40);
				bracketBox.push((char) 41);
			}
        }
		//확인용 값을 얻었음
		
		for(int i = inputArr.length-1 ; i >= 0; i--) {
			char confirmBracket= bracketBox.pop();
			if(confirmBracket == inputArr[i]) {
				return answer++;
			}
		}
        
        
        
        return answer;
    }
    
    
	public void getBracket(char[] inputCharArr, Queue beforeBracket, Queue afterBracket) {
		// 173:{ 175:} // 60: < 62 : > // 91: [ 93: ] // 40: ( 41: )
		for (int i = 0; i < inputCharArr.length; i++) {
			if (inputCharArr[i] == 173) {
				beforeBracket.add((char) 173);
				afterBracket.add((char) 175);
			} else if (inputCharArr[i] == 60) {
				beforeBracket.add((char) 60);
				afterBracket.add((char) 62);
			} else if (inputCharArr[i] == 91) {
				beforeBracket.add((char) 91);
				afterBracket.add((char) 93);
			} else if (inputCharArr[i] == 40) {
				beforeBracket.add((char) 40);
				afterBracket.add((char) 41);
			}
		}
	}
    
    public static void main(String[] args) {
		LINEcodingTest1 line = new LINEcodingTest1();
		String InputString1 = "Hello, world!";
		String InputString2 = "line [plus]";
		String InputString3 = "if (Count of eggs is 4.) {Buy milk.}";
		String InputString4 = ">_<";
		
		System.out.println(line.solution(InputString3));
	}
    
}
