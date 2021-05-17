import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
/*class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        helper(root,result);

        return result;
    }

    private void helper (TreeNode root, List<Integer> result){

        if (root !=null){
            if (root.left !=null){
                helper (root.left, result);
            }

            result.add(root.val);
             if (root.right !=null){
                helper (root.right, result);
            }
        }
    }

}
*/

    public class InoderTraversal {
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<Integer>();

            Stack<TreeNode> stack = new Stack<TreeNode> ();

            //TreeNode root1=root;

            while (root!=null || !stack.isEmpty() ){
                while (root !=null){
                    stack.push(root);
                    root =root.left;
                }
                root=stack.pop();
                result.add(root.val);
                root=root.right;

            }
            return result;
        }



    }

