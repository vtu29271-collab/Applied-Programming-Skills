import java.util.*;
class Solution {
    static class NodeInfo {
        TreeNode node;
        int row;
        int col;
        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.offer(new NodeInfo(root, 0, 0));
        while (!queue.isEmpty()) {
            NodeInfo current = queue.poll();
            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);
            if (node.left != null) {
                queue.offer(new NodeInfo(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new NodeInfo(node.right, row + 1, col + 1));
            }
        }
        for (Map<Integer, PriorityQueue<Integer>> cols : map.values()) {
            List<List<Integer>> colList = new ArrayList<>();
            List<Integer> currentColumnNodes = new ArrayList<>();
            for (PriorityQueue<Integer> pq : cols.values()) {
                while (!pq.isEmpty()) {
                    currentColumnNodes.add(pq.poll());
                }
            }
            result.add(currentColumnNodes);
        }
        return result;
    }
}