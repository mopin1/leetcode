class Solution_86 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode newList1 = new ListNode(0), newhead1 = newList1;
        ListNode newList2 = new ListNode(0), newhead2 = newList2;
        while (head != null) {
            if (head.val < x) {
                newhead1.next = new ListNode(head.val);
                newhead1 = newhead1.next;
            } else {
                newhead2.next = new ListNode(head.val);
                newhead2 = newhead2.next;
            }
            head = head.next;
        }
        newhead1.next = newList2.next;
        return newList1.next;
    }
}