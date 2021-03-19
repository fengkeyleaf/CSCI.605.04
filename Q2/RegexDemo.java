package Q2;

import java.awt.*;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {
        //匹配邮箱
//        String regex="^.+@.+(\\..+){1,}$";
//        String str="fushb@163.com";
//      System.out.println(str.matches(regex));

        //匹配固定电话  4位区号-7位号码 或者 3位区号-8位号码
//        String regex2="^\\d{4}-\\d{7}|\\d{3}-\\d{8}$";
//        String str2="020-13222113";
//        String str3="0532-9989211";
//      System.out.println(str2.matches(regex2));
//      System.out.println(str3.matches(regex2));

        //匹配除了a和9之外的数字或字符
//        String regex3="^[^9a]{1,}$";
//        String str4="1234fsfse";
//        String str5="a2343";
//      System.out.println(str4.matches(regex3));
//      System.out.println(str5.matches(regex3));

        //^和$的用法
        String a = "3131sasfasd".replaceAll("\\d{2}", "Z");
        String b = "3131sasfasd".replaceAll("^\\d{2}", "Z");//仅替换字符串开头的两个数字
        String c = "3131sdasfasd".replaceAll("sd", "Z");
        String d = "3131sdsfasd".replaceAll("sd$", "Z");//仅替换字符串结尾一组的sd
        System.out.println(a); // ZZsasfasd
        System.out.println(b); // Z31sasfasd
        System.out.println(c); // 3131ZasfaZ
        System.out.println(d); // 3131sdsfaZ
        System.out.println(Pattern.matches("^\\d{2}", "3131sasfasd"));
//        String str6 = "aa3131sasfasd";
//        System.out.println(str6.matches("\\d{2}")); //false
//        System.out.println(str6.matches("^\\d{2}"));//false
    }
}