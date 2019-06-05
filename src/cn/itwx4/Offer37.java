package cn.itwx4;

import cn.source.BinaryTreeNode;

/**
 * 序列化二叉树
 *
 * @author wang
 */
public class Offer37 {

    /**
     * 序列化二叉树
     *
     * @param root
     * @return
     */
    public String serialize(BinaryTreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) sb.append("$,");

        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    /**
     * 反序列化二叉树
     */
    int index = -1;

    public BinaryTreeNode deSerialize(String str) {
        index++;
        String[] split = str.split(",");
        int len = split.length;
        BinaryTreeNode node = null;

        if (index >= len) return null;

        if (!split[index].equals("$")) {
            node = new BinaryTreeNode(Integer.parseInt(split[index]));
            node.left = deSerialize(str);
            node.right = deSerialize(str);
        }
        return node;
    }


    public static void main(String[] args) {
        Offer37 offer37 = new Offer37();
        String s = "1,2,4,$,$,$,3,5,$,$,6,$,$";
        BinaryTreeNode node = offer37.deSerialize(s);
        System.out.println(node.val);
    }
}
