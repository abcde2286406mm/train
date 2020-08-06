import com.ucarinc.wtf.demo.MaximalSquare;
import org.junit.Test;

/**
 * @ProjectName: shiro-demo
 * @Package: PACKAGE_NAME
 * @ClassName: MaximalSquareTest
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/8 14:29
 * @Version: 1.0
 */
public class MaximalSquareTest {
    @Test
    public void maximalSquareTest(){
        char[][] chars = {{'1','1','0'},{'1','1','1'},{'1','1','1','1','1'}};
        System.out.println(MaximalSquare.maximalSquareV2(chars));
//        System.out.println(MaximalSquare.isSquare(chars,0,0,2,3));
    }
}
