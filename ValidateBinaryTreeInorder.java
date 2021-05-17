public class ValidateBinaryTreeInorder {



        Integer prev  = null;

        public boolean isValidBST(TreeNode root) {

            return inorder(root);

        }

        boolean inorder( TreeNode root){
            if (root== null ) return true;


            if (!inorder (root.left)) return false;
            if (prev !=null && root.val <= prev ) return false ;


            prev= root.val;

            return inorder(root.right);
        }
    

}
