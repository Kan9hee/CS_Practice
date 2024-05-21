package LeetCode;

public class Test2 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode temp = new ListNode(0);
            ListNode p = l1, q = l2, current = temp;
            int carry = 0;

            while (p != null || q != null) {
                int l1Val = (p != null) ? p.val : 0;
                int l2Val = (q != null) ? q.val : 0;
                int sum = carry + l1Val + l2Val;

                carry = sum / 10;
                current.next = new ListNode(sum % 10);
                current = current.next;

                if (p != null)
                    p = p.next;
                if (q != null)
                    q = q.next;
            }

            if (carry > 0)
                current.next = new ListNode(carry);

            return temp.next;
        }
    }
}
