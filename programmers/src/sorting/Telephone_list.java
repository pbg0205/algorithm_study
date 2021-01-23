package sorting;

import java.util.Arrays;

public class Telephone_list {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        int index = 0;
        while(index < phone_book.length - 1) {
            if(phone_book[index + 1].startsWith(phone_book[index])) {
                return false;
            }
            index++;
        }

        return true;
    }

    public static void main(String[] args) {
        Telephone_list telephone_list = new Telephone_list();
        boolean result = telephone_list.solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(result);
    }
}
