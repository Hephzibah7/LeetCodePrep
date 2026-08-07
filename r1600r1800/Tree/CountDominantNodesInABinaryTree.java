package r1600-r1800.Tree;
/*
https://leetcode.com/problems/count-dominant-nodes-in-a-binary-tree/


Very simple problem, but only thing I missed it, here I got little confusion, we need to return the counts of the nodes
which statisfy the condition also we need to return the max from eas substree to a node, at a time 
we can return only two things then how should we do?
In that case just maintain a global count which helps to count the node which statisfy the condition, since
returning the max from each subtree is necassary to complete the solution.
*/
public class CountDominantNodesInABinaryTree {
    int count=0;
    public int countDominantNodes(TreeNode root) {
       work(root);
        return count;
    }
    int work(TreeNode root){
        if(root.left==null && root.right==null) {
            count++;
            return root.val;
        }
        int max=root.val;
        if(root.left!=null) max=Math.max(max, work(root.left));
        if(root.right!=null) max=Math.max(max, work(root.right));
        if(max==root.val) count++;
        return max;
    }
}
