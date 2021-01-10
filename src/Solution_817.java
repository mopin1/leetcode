import java.util.HashSet;
import java.util.Set;

class Solution_817 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : G)
            set.add(x);
        boolean flag = false;
        ListNode last = head;
        while (head != null) {
            if (!set.contains(head.val) && flag) {
                count++;
                flag = false;
            } else if (set.contains(head.val)) {
                flag = true;
            }
            last = head;
            head = head.next;
        }
        assert last != null;
        if (set.contains(last.val) && flag)
            count++;
        return count;
    }

}
