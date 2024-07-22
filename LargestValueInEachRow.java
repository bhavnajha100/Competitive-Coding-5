// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definitiona for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Using BFS
class LargestValueInEachRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
        return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode currentNode = q.poll();
                    max = Math.max(max, currentNode.val);

                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
            res.add(max);
        }

        return res;

    }
}


// Using DFS
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LargestValueInEachRow {
    // Using DFS
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        this.res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root,  int level) {
        if(root == null) {
            return;
        }

        if(level == res.size())
            res.add(root.val);

        else {
            res.set(level,Math.max(res.get(level), root.val));
        }

        dfs(root.left, level +1);
        dfs(root.right, level +1);
    }
}