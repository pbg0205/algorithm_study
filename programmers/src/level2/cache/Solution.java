package programmers.src.level2.cache;

import java.util.LinkedList;
import java.util.Locale;

class Solution {
    private static final int CACHE_HIT = 1;
    private static final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return 5 * cities.length;
        }

        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            city = city.toUpperCase(Locale.ROOT);

            if(cache.remove(city)) {
                cache.addFirst(city);
                answer += CACHE_HIT;
                continue;
            }

            int currentSize = cache.size();

            if(currentSize == cacheSize) {
                cache.pollLast();
            }

            cache.addFirst(city);
            answer += CACHE_MISS;
        }
        return answer;
    }
}
