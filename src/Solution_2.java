class ListNode {
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

class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode head = l3;
        int count = 0;
        while (l1 != null || l2 != null) {
            int m = 0, n = 0;
            if (l1 != null) {
                m = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n = l2.val;
                l2 = l2.next;
            }
            int sum = m + n + count;
            if (sum >= 10) {
                sum %= 10;
                count = 1;
            } else {
                count = 0;
            }
            head.next = new ListNode(sum);
            head = head.next;
        }
        if (count == 1) {
            head.next = new ListNode(1);
        }
        return l3.next;
    }
}