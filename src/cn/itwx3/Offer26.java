package cn.itwx3;

import cn.source.TreeNode3;

/**
 * 树的子结构
 *
 * @author wang
 */
public class Offer26 {

    public boolean hasSubTree(TreeNode3 root1, TreeNode3 root2) {
        boolean res = false;
        if (root1 != null && root2 != null) {
            if (equal(root1.val, root2.val)) {
                res = doesTree1HaveTree2(root1, root2);
            }
            if (!res) {
                res = hasSubTree(root1.left, root2);
            }
            if (!res) {
                res = hasSubTree(root1.right, root2);
            }
        }
        return res;
    }

    private boolean doesTree1HaveTree2(TreeNode3 node1, TreeNode3 node2) {
        if (node2 == null) return true;
        if (node1 == null) return false;
        if (!equal(node1.val, node2.val)) return false;

        return doesTree1HaveTree2(node1.left, node2.left) &&
                doesTree1HaveTree2(node1.right, node2.right);
    }

    private boolean equal(double val1, double val2) {
        if ((val1 - val2 < 0.0000001) && (val1 - val2 > -0.0000001)) {
            return true;
        }
        return false;
    }

}


