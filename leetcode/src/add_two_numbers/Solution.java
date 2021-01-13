package add_two_numbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = getSum(l1.val, l2.val, false);
        boolean carry = getCarry(l1.val, l2.val);

        ListNode answer = new ListNode(sum);

        while(l1.next != null || l2.next != null) {

            l1 = l1.next != null ? l1.next : new ListNode(0);
            l2 = l2.next != null ? l2.next : new ListNode(0);

            sum = getSum(l1.val, l2.val, carry);

            answer.next = new ListNode(sum);
            answer = answer.next;

            carry = getCarry(l1.val, l2.val);
        }

        if(carry) {
            answer.next = new ListNode(1);
        }

        return answer;
    }

    public int getSum(int a, int b, boolean carry) {
        return carry ? (a + b + 1) % 10 : (a + b) % 10;
    }

    public boolean getCarry(int a, int b) {
        return ((a + b) / 10) > 0;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}