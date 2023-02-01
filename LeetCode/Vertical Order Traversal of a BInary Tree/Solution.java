/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public static HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> out;
    public static int maxY;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        out = new HashMap<>();
        maxY = 0;

        traversal(root, 0, 0);

        List<List<Integer>> ret = new ArrayList<>();

        for (int i = -out.size(); i < out.size(); i++) {
            if (out.containsKey(i)) {
                HashMap<Integer, ArrayList<Integer>> yKeys = out.get(i);
                ArrayList<Integer> add = new ArrayList<>();
                for (int j = 0; j <= maxY; j++) {
                    if (yKeys.containsKey(j)) {
                        ArrayList<Integer> tmp = yKeys.get(j);
                        Collections.sort(tmp);
                        for (int h = 0; h < tmp.size(); h++) {
                            add.add(tmp.get(h));
                        }
                    }
                }
                ret.add(add);
            }
        }
        return ret;
    }

    public static void traversal(TreeNode root, int x, int y) {
        if (y > maxY)
            maxY = y;
        if (out.containsKey(x)) {
            HashMap<Integer, ArrayList<Integer>> yKeys = out.get(x);
            ArrayList<Integer> add = new ArrayList<>();
            if (yKeys.containsKey(y)) {
                add = yKeys.get(y);
                add.add(root.val);
            } else {
                add.add(root.val);
            }
            yKeys.put(y, add);
            out.put(x, yKeys);
        } else {
            HashMap<Integer, ArrayList<Integer>> yKeys = new HashMap<>();
            ArrayList<Integer> add = new ArrayList<>();
            add.add(root.val);
            yKeys.put(y, add);
            out.put(x, yKeys);
        }
        if (root.left != null) {
            traversal(root.left, x - 1, y + 1);
        }
        if (root.right != null) {
            traversal(root.right, x + 1, y + 1);
        }
    }

}