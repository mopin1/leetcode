class Solution_684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int[] res = new int[0];
        for (int[] edge : edges) {
            if (find(parent, edge[0]) == find(parent, edge[1]))
                res = edge;
            else
                union(parent, edge[0], edge[1]);
        }
        return res;
    }

    private void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    private int find(int[] parent, int index) {
        if (index != parent[index])
            parent[index] = find(parent, parent[index]);
        return parent[index];
    }
}
