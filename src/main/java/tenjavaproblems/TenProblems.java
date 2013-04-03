package tenjavaproblems;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author yanghua
 */
public class TenProblems {

    public static void main(String[] args) {
//        two();
        three();
    }

    public void one() {
        //1. 很多类的命名相同（例如：常见于异常、常量、日志等类），导致在import时，有时候张冠李戴，这种错误有时候很隐蔽。因为往往同名的类功能也类似，所以IDE不会提示warn。
    }

    public static void two() {
        //1. 想当然的API, 可能老是false 
        boolean flag = Boolean.getBoolean("true");
        System.out.println(flag);
        Calendar cal = GregorianCalendar.getInstance();
        cal.roll(Calendar.DAY_OF_YEAR, -365);
        System.out.println(cal.getTime());
        //这才是去年
        cal.add(Calendar.DAY_OF_YEAR, -365);
        System.out.println(cal.getTime());
    }
    public static void three(){
        long x = Integer.MAX_VALUE + 1 ;
        System.out.println(x);
//        在检查是否为正数的参数校验中，为了避免重载，选用参数number, 于是下面代码结果小于0，也是因为溢出导致：
        Number n = Long.MAX_VALUE ;
        System.out.println(n.intValue());
        
        long y = Integer.MAX_VALUE + 1L ;
    }
}
