package com.ucarinc.wtf.train.Tree;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: IsSubtree
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 另一个树的子树
 * @Date: 2020/5/7 14:07
 * @Version: 1.0
 */
public class IsSubtree {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        //对每一个节点都进行对比
        if (isCompare(s,t)){
            return true;
        }else {
            //当s已经遍历完了，返回false
            if (s == null){
                return false;
            }else {
                //先对左节点进行遍历，再对右节点遍历
                if (isSubtree(s.left, t) || isSubtree(s.right, t)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    public static boolean isCompare(TreeNode s, TreeNode t){
        //都为null说明最后一个节点已经比对过了
        if (s == null && t == null){
            return true;
        //若其中一个为null说明节点不一致
        }else if (s == null || t == null){
            return false;
        //到这步说明s和t都不为null，则对比其值，遍历左节点，遍历右节点
        }else if (s.val == t.val && isCompare(s.left,t.left) && isCompare(s.right,t.right)){
            return true;
        } else {
            return false;
        }
    }
}
