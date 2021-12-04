package com.dx.algorithmpractise.binarytree;

/**
 * 实现 二叉树的前序，中序，后序 遍历
 */
public class TreeIterator {

    /**
     * 前序遍历
     * 1.打印自己
     * 2.打印左节点
     * 3.打印右节点
     * <p>
     * //伪代码
     * <p>
     * preOrder(TreeNode root){
     * if(root == null) return
     * print(root)
     * preOrder(root.left)
     * preOrder(root.right)
     * }
     */
    public void preOrder(TreeNode root) {
        if (root == null) return;
        printNode(root);
        printNode(root.getLeft());
        printNode(root.getRight());
    }

    private void printNode(TreeNode node) {
        System.out.println("xcwq " + node.getData());
    }

    /**
     * 中序遍历
     * 1.先打印左节点
     * 2.在打印自己
     * 3.最后打印右节点
     */
    private void middleOrder(TreeNode root) {
        if (root == null) return;
        middleOrder(root.getLeft());
        printNode(root);
        middleOrder(root.getRight());
    }

    /**
     * 后序遍历
     * 1.先打印左节点
     * 2.再打印右节点
     * 3.最后打印自己
     */

    private void afterOrder(TreeNode root) {
        if (root == null) return;
        afterOrder(root.getLeft());
        afterOrder(root.getRight());
        afterOrder(root);
    }

    /**
     *2、二叉树按层遍历，可以看作以根结点为起点，图的广度优先遍历的问题。???
     * */


}
