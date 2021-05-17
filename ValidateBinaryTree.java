

     //Definition for a binary tree node.
       class TreeNode {
          int val;
         TreeNode left;
          TreeNode right;
         TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public class ValidateBinaryTree {
        public boolean isValidBST(TreeNode root) {

            return isValidBST(root,null,null);

        }

        boolean isValidBST (TreeNode root, Integer lower_bound, Integer upper_bound){
            if (root == null) return true;

            if (lower_bound!=null && root.val <= lower_bound) return false;

            if (upper_bound != null && root.val >= upper_bound) return false;

            boolean return_low = isValidBST(root.left, lower_bound, root.val);

            boolean return_high = isValidBST(root.right, root.val, upper_bound);

            return (return_low && return_high);
        }
    }

