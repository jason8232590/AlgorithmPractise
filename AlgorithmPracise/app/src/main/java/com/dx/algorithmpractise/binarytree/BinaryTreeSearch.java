package com.dx.algorithmpractise.binarytree;

/**
 * 二叉树查找树   任一节点的左子树的每个节点都小于它    右子树都大于它
 */
public class BinaryTreeSearch {
    private TreeNode treeRootNode;

    /**
     * 二叉查找树 插入节点
     */
    public void treeInsert(int data) {
        if (treeRootNode == null) {
            treeRootNode = new TreeNode(data);
            return;
        }

        TreeNode currentChildNode = treeRootNode;
        while (currentChildNode != null) {
            if (data > currentChildNode.getData()) {
                if (currentChildNode.getRight() == null) {
                    //如果右节点没有，那直接插入
                    currentChildNode.setRight(new TreeNode(data));
                    return;
                }
                //如果右节点存在，那就以这个为节点再走一遍
                currentChildNode = currentChildNode.getRight();
            } else {
                if (currentChildNode.getLeft() == null) {
                    currentChildNode.setLeft(new TreeNode((data)));
                    return;
                }
                //如果左节点存在，那么就以这个左节点为节点再走一次
                currentChildNode = currentChildNode.getLeft();
            }
        }
    }

    /**
     * 二叉查找树    查找某个值
     */
    public TreeNode treeFind(int data) {
        TreeNode currentChildNode = treeRootNode;

        while (currentChildNode != null) {
            if (data < currentChildNode.getData()) {
                currentChildNode = currentChildNode.getLeft();
            } else if (data > currentChildNode.getData()) {
                currentChildNode = currentChildNode.getRight();
            } else {
                return currentChildNode;
            }
        }
        return null;
    }

    /**
     * 如果有相同元素会怎么样？  这里就不考虑这种情况
     */
    public void deleteTreeNode(int data) {
        TreeNode currentChildNode = treeRootNode;
        TreeNode parentNode = null;

        while (currentChildNode != null && currentChildNode.getData() != data) {
            parentNode = currentChildNode;
            if (data > currentChildNode.getData()) {
                currentChildNode = currentChildNode.getRight();
            } else {
                currentChildNode = currentChildNode.getLeft();
            }
        }
        //不存在这个值
        if (currentChildNode == null) return;

        //如果存在
        //1.如果要被删除的节点存在 两个子节点
        //则查找右子树中最小的那个节点   代替 被删除的结点
        if (currentChildNode.getLeft() != null && currentChildNode.getRight() != null) {
            TreeNode minNode = currentChildNode.getRight();
            TreeNode parentMinNode = currentChildNode;
            while (minNode.getLeft() != null) {
                //左节点
                parentMinNode = minNode;
                minNode = minNode.getLeft();
            }

            //上面已经找到那个右节点中  值最小的结点
            //直接 替换到 要被删除的那个节点
            currentChildNode.setData(minNode.getData());
            currentChildNode = minNode;
            //更新父节点
            parentNode = parentMinNode;
        }

        //2. 如果没有左节点和右节点（也就是叶子节点）
        //3.如果有右节点 或者左节点
        TreeNode childNode;//这个左节点或者右节点
        if (currentChildNode.getRight() != null) {
            //如果只有右节点
            childNode = currentChildNode.getRight();
        } else if (currentChildNode.getLeft() != null) {
            //如果只有左节点
            childNode = currentChildNode.getLeft();
        } else {
            //没有子节点
            childNode = null;
        }

        if (parentNode == null) {
            //如果删除的是根节点
            treeRootNode = childNode;
        } else if (parentNode.getRight() == currentChildNode) {
            //删除的是右节点(currentChildNode 是 parentNode的右节点)
            parentNode.setRight(childNode);
        } else {
            //删除的是左节点(currentChildNode 是 parentNode的左节点)
            parentNode.setLeft(childNode);
        }
    }


    public TreeNode findMin() {
        if (treeRootNode == null) return null;
        TreeNode p = treeRootNode;
        while (p.getLeft() != null) {
            p = p.getLeft();
        }
        return p;
    }

    public TreeNode findMax() {
        if (treeRootNode == null) return null;
        TreeNode p = treeRootNode;
        while (p.getRight() != null) {
            p = p.getRight();
        }
        return p;
    }
}
