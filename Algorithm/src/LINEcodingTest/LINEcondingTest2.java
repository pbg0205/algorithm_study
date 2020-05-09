package LINEcodingTest;

public class LINEcondingTest2 {
	public int solution(String answer_sheet, String[] sheets) {
		int answer = -1;
		char[] ansSheet_charArr = answer_sheet.toCharArray();

		for (int i = 0; i < sheets.length - 1; i++) {

			for (int j = i + 1; j < sheets.length; j++) {
				int suspicion_total = 0, suspicion_maxRelay = 0,suspicion_relay = 0, suspicion_value;
				char[] sheet1 = sheets[i].toCharArray();
				char[] sheet2 = sheets[j].toCharArray();

				for (int k = 0; k < sheet1.length; k++) {
					if (sheet1[k] == sheet2[k] && ansSheet_charArr[k] != sheet1[k]) {
						suspicion_total++;
						if(k == 0)	suspicion_relay++;
						if (k >= 1) {
							if (sheet1[k - 1] == sheet2[k - 1] && ansSheet_charArr[k] != sheet1[k]) {
								suspicion_relay++;
								System.out.println(k);
								if (suspicion_maxRelay < suspicion_relay)
									
									suspicion_maxRelay = suspicion_relay;
							} else if (sheet1[k - 1] != sheet2[k - 1]) {
								suspicion_relay = 0;
							}
						}
					}
				}
				System.out.println("suspicion_total: "+suspicion_total);
				System.out.println("Math.pow(suspicion_maxRelay, 2):" + Math.pow(suspicion_maxRelay, 2));
				suspicion_value = (int) (suspicion_total + Math.pow(suspicion_maxRelay, 2));
				System.out.println("suspicion_value: " + suspicion_value);
				if (suspicion_value > answer)
					answer = suspicion_value;
				System.out.println("________________");
			}
			
		}
		if (answer == -1)
			return 0;

		return answer;
	}
    
	public static void main(String[] args) {
		LINEcondingTest2 sol = new LINEcondingTest2();
		String answer_sheet = "4132315142";
		String[] sheets = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
		System.out.println(sol.solution(answer_sheet, sheets));
	}
}
