package com.ucarinc.wtf.demo.Tree;

import com.ucarinc.wtf.demo.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo
 * @ClassName: LevelOrder
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 二叉树广度优先搜索
 * @Date: 2020/5/13 9:49
 * @Version: 1.0
 */
public class TreeOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root != null) {
            //辅助链表 用来存储每层树节点
            List<TreeNode> treeNodes = new LinkedList<>();
            treeNodes.add(root);
            //当前层存在节点时
            while (!treeNodes.isEmpty()){
                List<Integer> levelVal = new LinkedList<>();
                //将当前层节点全部移除并存储层数据，如果存在子节点则新增至辅助链表末尾，表示下一层节点
                int size = treeNodes.size();
                for (int i = 0; i < size; i++){
                    TreeNode treeNode = treeNodes.remove(0);
                    levelVal.add(treeNode.val);
                    if (treeNode.left != null){
                        treeNodes.add(treeNode.left);
                    }
                    if (treeNode.right != null){
                        treeNodes.add(treeNode.right);
                    }
                }
                result.add(levelVal);
            }
        }
        return result;
    }

    /**
     * @ProjectName: shiro-demo
     * @Package: com.ucarinc.wtf.demo
     * @ClassName: LevelOrder
     * @Author: tengfei.wu01@ucarinc.com
     * @Description: 二叉树深度优先搜索
     * @Date: 2020/5/13 9:49
     * @Version: 1.0
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root != null){
            return getPath(new String(), root, new ArrayList<>());
        }else{
            return null;
        }
    }
    private static List<String> getPath(String path,TreeNode root, List<String> paths){
        if (root != null){
            path += root.val;
        }
        if (root.right == null && root.left == null){
            paths.add(path);
        }else {
            path += "->" ;
            getPath(path, root.left, paths);
            getPath(path, root.right, paths);
        }
        return paths;
    }
}
