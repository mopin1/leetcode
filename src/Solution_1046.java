import java.util.PriorityQueue;

class Solution_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int x:stones){
            pq.offer(x);
        }
        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if(a>b)
                pq.offer(a-b);
        }
        return pq.isEmpty()?0:pq.poll();
    }
}