package com.ucarinc.wtf.demo.Tree;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Tree
 * @ClassName: SimpleTree
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/7 14:10
 * @Version: 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
