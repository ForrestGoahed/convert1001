import java.util.HashMap;
import java.util.Map;

/**
 * ClassName：
 * Description：
 * <p>company：58同城 <br>
 * Copyright：Copyright ? 2011 58.com All Rights Reserved<br>
 *
 * @author shaohongtao
 * @Date 2017/11/13 15:29
 * @since JRE 1.6.0_22  or higher
 */
public class convert1001 {

    private static Map<Integer,String> numMap = new HashMap<Integer, String>();

    static {
        numMap.put(0,"零");numMap.put(1,"壹");numMap.put(2,"贰");numMap.put(3,"叁");
        numMap.put(4,"肆");numMap.put(5,"伍"); numMap.put(6,"陆");numMap.put(7,"柒");
        numMap.put(8,"捌");numMap.put(9,"玖");numMap.put(10,"拾");numMap.put(100,"佰");
        numMap.put(1000,"仟");
    }


    public static String ToConvert1001(int integer){
        String cNum = "";
        int bitnum = 1000, rem = -1,result = -1;//要除的级数;余数;除的商
        while(0 != rem && 0 != bitnum ){
            result = integer / bitnum; rem = integer % bitnum;
            cNum += numMap.get(result);
            if(1000 == bitnum && 0 != result){cNum += numMap.get(1000);}
            else if(100 == bitnum && 0 != result){ cNum += numMap.get(100);}
            else if(10 == bitnum && 0 != result){cNum += numMap.get(10); }
            bitnum /= 10; integer = rem;
        }
        //处理中间位为0的情况
        if(cNum.contains("零零"))cNum = cNum.replaceFirst("零","");
        System.out.println(cNum);
        return cNum;
    }

    public static void main(String[] args) {
        ToConvert1001(1004);
    }
}
