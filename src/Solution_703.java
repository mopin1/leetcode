import java.util.PriorityQueue;

class Solution_703 {
    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int num : nums)
                add(num);
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k)
                pq.poll();
            return pq.peek();
        }
    }
}
