package LINEcodingTest;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.*;

public class LINEcondingTest5 {
    public String[] solution(String[][] dataSource, String[] tags) {
        String[] answer = new String[dataSource.length];
        int[] match_count = new int[dataSource.length];
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < dataSource.length; i++) {
			for(int j = 1; j< dataSource[i].length; j++) {
				for(int k = 0; k < tags.length; k++) {
					if(dataSource[i][j].equals(tags[k]))	match_count[i]++;
				}
				map.put(dataSource[i][0], match_count[i]);
			}
		}
        
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        
        Map<String, Integer> sortedMap = new LinkedHashMap<>(); 
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("key","value");
        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();

        int index = 0;
        while(iterator.hasNext()){
        	  String key = (String)iterator.next();
        	  answer[index] = key;
        	  index++;
        	}
        return answer;
    }
    
    public static void main(String[] args) {
    	LINEcondingTest5 sol = new LINEcondingTest5();
    	String[][] dataSource = {
    	    {"doc1", "t1", "t2", "t3"},
    	    {"doc2", "t0", "t2", "t3"},
    	    {"doc3", "t1", "t6", "t7"},
    	    {"doc4", "t1", "t2", "t4"},
    	    {"doc5", "t6", "t100", "t8"}
    	};
    	
    	String[] tags = {"t1", "t2", "t3"};
    	
    	System.out.println(sol.solution(dataSource, tags));
    }
}
