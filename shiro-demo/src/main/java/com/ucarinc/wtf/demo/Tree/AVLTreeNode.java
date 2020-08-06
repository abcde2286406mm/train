package com.ucarinc.wtf.demo.Tree;

import org.checkerframework.checker.units.qual.A;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Tree
 * @ClassName: AVLTree
 * @Author: tengfei.wu01@ucarinc.com
 * @Description: 平衡二叉树
 * @Date: 2020/5/11 14:32
 * @Version: 1.0
 */
public class AVLTreeNode {
    private AVLTreeNode leftChild;
    private AVLTreeNode rightChild;
    private int val;
    private int high;


    public AVLTreeNode(int val){
        this.val = val;
        this.leftChild = null;
        this.rightChild = null;
        this.val = val;
        this.high = 0;
    }

    public AVLTreeNode(){

    }
    public int nodeHigh(AVLTreeNode avlTreeNode){
        if (avlTreeNode == null){
            return 0;
        }
        int leftHigh = nodeHigh(avlTreeNode.leftChild);
        int rightHigh = nodeHigh(avlTreeNode.rightChild);
        return leftHigh > rightHigh ? leftHigh + 1 : rightHigh + 1;
    }
    public AVLTreeNode leftRotate(AVLTreeNode avlTreeNode){
        AVLTreeNode node = avlTreeNode.rightChild;
        avlTreeNode.rightChild = avlTreeNode.rightChild.leftChild;
        node.leftChild = avlTreeNode;
        avlTreeNode.high = nodeHigh(avlTreeNode);
        node.high = nodeHigh(node);
        return node;
    }
    public AVLTreeNode rightRotate(AVLTreeNode avlTreeNode){
        AVLTreeNode node = avlTreeNode.leftChild;
        avlTreeNode.leftChild = avlTreeNode.leftChild.rightChild;
        node.rightChild = avlTreeNode;
        avlTreeNode.high = nodeHigh(avlTreeNode);
        node.high = nodeHigh(node);
        return node;
    }
    public AVLTreeNode insert(AVLTreeNode avlTreeNode,int val){
        if (avlTreeNode == null){
            avlTreeNode = new AVLTreeNode(val);
        }else if (val < avlTreeNode.val){
            avlTreeNode.leftChild = insert(avlTreeNode.leftChild,val);
            if (Math.abs(nodeHigh(avlTreeNode.leftChild) - nodeHigh(avlTreeNode.rightChild)) == 2){
                if (avlTreeNode.leftChild != null && val < avlTreeNode.leftChild.val){
                    avlTreeNode = rightRotate(avlTreeNode);
                }else if (avlTreeNode.rightChild != null && val < avlTreeNode.rightChild.val){
                    avlTreeNode = leftRotate(avlTreeNode) ;
                    avlTreeNode = rightRotate(avlTreeNode);
                }
            }
        }else if (val > avlTreeNode.val){
            avlTreeNode.rightChild = insert(avlTreeNode.rightChild,val);
            if (Math.abs(nodeHigh(avlTreeNode.leftChild) - nodeHigh(avlTreeNode.rightChild)) == 2){
                if (avlTreeNode.rightChild != null && val < avlTreeNode.rightChild.val){
                    avlTreeNode = leftRotate(avlTreeNode);
                }else if (avlTreeNode.leftChild != null && val < avlTreeNode.leftChild.val){
                    avlTreeNode = rightRotate(avlTreeNode);
                    avlTreeNode = leftRotate(avlTreeNode) ;
                }
            }
        }
        avlTreeNode.high = nodeHigh(avlTreeNode);
        return avlTreeNode;
    }

    public AVLTreeNode max(AVLTreeNode avlTreeNode){
        AVLTreeNode result = null;
        if (avlTreeNode == null){
            return null;
        }else {
            while (avlTreeNode.rightChild != null){
                result = avlTreeNode.rightChild;
                avlTreeNode = avlTreeNode.rightChild;
            }
        }
        return result;
    }
    public AVLTreeNode min(AVLTreeNode avlTreeNode){
        AVLTreeNode result = null;
        if (avlTreeNode == null){
            return null;
        }else {
            while (avlTreeNode.leftChild != null){
                result = avlTreeNode.leftChild;
                avlTreeNode = avlTreeNode.leftChild;
            }
        }
        return result;
    }

    public AVLTreeNode remove(AVLTreeNode avlTreeNode, int val){
        if (avlTreeNode != null){
            if (avlTreeNode.val == val){
                if (avlTreeNode.leftChild != null && avlTreeNode.rightChild != null){
                    if (nodeHigh(avlTreeNode.leftChild) > nodeHigh(avlTreeNode.rightChild)) {
                        AVLTreeNode max = max(avlTreeNode);
                        avlTreeNode.val = max.val;
                        avlTreeNode.leftChild = remove(avlTreeNode.leftChild,max.val);
                    }else {
                        AVLTreeNode min = min(avlTreeNode);
                        avlTreeNode.val = min.val;
                        avlTreeNode.rightChild = remove(avlTreeNode.rightChild,min.val);
                    }
                }else {
                    if (avlTreeNode.leftChild != null){
                        avlTreeNode = avlTreeNode.leftChild;
                    }else {
                        avlTreeNode = avlTreeNode.rightChild;
                    }
                }
            }else if (avlTreeNode.val > val){
                avlTreeNode.leftChild = remove(avlTreeNode.leftChild,val);
                if (nodeHigh(avlTreeNode.rightChild) - nodeHigh(avlTreeNode.leftChild) == 2){
                    AVLTreeNode rightChild = avlTreeNode.rightChild;
                    if (nodeHigh(rightChild.leftChild) > nodeHigh(rightChild.rightChild)){
                        avlTreeNode = rightRotate(avlTreeNode);
                        avlTreeNode = leftRotate(avlTreeNode);
                    }else {
                        avlTreeNode = rightRotate(avlTreeNode);
                        avlTreeNode = rightRotate(avlTreeNode);
                    }
                }
            }else {
                avlTreeNode.rightChild = remove(avlTreeNode.rightChild,val);
                if (nodeHigh(avlTreeNode.leftChild) - nodeHigh(avlTreeNode.rightChild) == 2){
                    AVLTreeNode rightChild = avlTreeNode.leftChild;
                    if (nodeHigh(rightChild.rightChild) > nodeHigh(rightChild.leftChild)){
                        avlTreeNode = leftRotate(avlTreeNode);
                        avlTreeNode = rightRotate(avlTreeNode);
                    }else {
                        avlTreeNode = leftRotate(avlTreeNode);
                        avlTreeNode = leftRotate(avlTreeNode);
                    }
                }
            }
            return avlTreeNode;
        }else {
            return  null;
        }
    }
}
