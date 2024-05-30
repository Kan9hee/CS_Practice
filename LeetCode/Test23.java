package LeetCode;

import java.util.PriorityQueue;

public class Test23 {
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
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode n1, ListNode n2) -> n1.val - n2.val);

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null)
                    pq.add(lists[i]);
            }

            ListNode resultHead = new ListNode();
            ListNode current = resultHead;

            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                current.next = node;
                current = current.next;
                if (node.next != null)
                    pq.add(node.next);
            }

            return resultHead.next;
        }
    }
}
