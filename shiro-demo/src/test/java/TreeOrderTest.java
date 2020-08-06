import com.ucarinc.wtf.demo.Tree.TreeOrder;
import com.ucarinc.wtf.demo.Tree.TreeNode;
import org.junit.Test;

/**
 * @ProjectName: shiro-demo
 * @Package: PACKAGE_NAME
 * @ClassName: LevelOrder
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/13 10:26
 * @Version: 1.0
 */
public class TreeOrderTest {
    @Test
    public void TreelOrderTest(){
        TreeNode treeNode = new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15,null,null),new TreeNode(17,null,null)));
        TreeOrder.levelOrder(treeNode);
        System.out.println(TreeOrder.binaryTreePaths(treeNode));
    }
}
