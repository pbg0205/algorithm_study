package sorting;

import java.util.Arrays;

public class Telephone_list {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Telephone_list telephone_list = new Telephone_list();
        telephone_list.solution(new String[]{"119", "97674223", "1195524421"});
    }
}
