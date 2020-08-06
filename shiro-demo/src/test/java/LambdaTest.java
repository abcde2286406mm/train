import com.ucarinc.wtf.train.Lambda;
import org.junit.Test;

/**
 * @ProjectName: shiro-demo
 * @Package: PACKAGE_NAME
 * @ClassName: LambdaTest
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/5/8 10:24
 * @Version: 1.0
 */
public class LambdaTest {

    @Test
    public void LambdaTest(){
        System.out.println(Lambda.intLambda(1,Integer::bitCount));
        System.out.println(Lambda.intLambdaV2(1,2,Integer::compare));
        System.out.println(Lambda.intLambdaV3(1,2,(x,y) -> {
            if (x > y){
                return x+y;
            }else {
                return y-x;
            }
        }));
    }
    @Test
    public void insetLambdaTest(){
       Lambda.intLambdaV4(1,2, Integer::sum);
    }
}
