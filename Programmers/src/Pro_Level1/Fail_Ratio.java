package Pro_Level1;

import java.util.*;

public class Fail_Ratio {
	//실패율 : 클리어하지 못한 플레이어 수 / 도달한 플레이어 수 
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		
		Map <Integer, Double> map = new HashMap<Integer,Double>();
		
        
		for(int i = 0; i < N; i++){
			double fail_ratio = 0;
			int total_mem = stages.length;
			int fail_mem = 0;
			
			for (int j = 0; j < stages.length; j++) {
				if((i+1) == stages[j])	fail_mem++;
				if((i+1) > stages[j])	total_mem--;
			}
			System.out.println("fail_mem: " + fail_mem + " total_mem: " + total_mem);
			fail_ratio = (double)fail_mem / (double)total_mem;
			System.out.println(fail_ratio);
			
			map.put(i+1,fail_ratio);
		}
		
		Iterator<Integer> it = map.keySet().iterator();
		 
        while(it.hasNext()){
            Integer key = it.next();
            Double value = map.get(key);
            System.out.println(key+" : "+value);
        }
        
        Iterator it2 = sorByValue(map).iterator();
        System.out.println("정렬 후=====================");
        
        while(it2.hasNext()) {
            Integer temp = (Integer) it2.next();
            System.out.println(temp + " = " + map.get(temp));
        }
        
		return answer;
    }
	
	public static List sorByValue(final Map map) {
		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		
		Collections.sort(list, new Comparator() {
			
			@Override
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				
//				return ((Comparable)v2).compareTo(v1);//오름차순
				return ((Comparable)v1).compareTo(v2);//내림차순
				
			}
		});
		
		Collections.reverse(list);
		return list;
		
	}

	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2,1,2,6,2,4,3,3};
		
		Fail_Ratio f = new Fail_Ratio();
		f.solution(N, stages);
	}
}
