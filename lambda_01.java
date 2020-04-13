package lambda;

import java.util.Map;

/**
 * @program: test
 * @description:
 * @author: zzh
 * @create: 2020-04-13 16:03
 **/
/*
 * @Description:
 *Lambda 表达式允许开发者将函数作为参数传给某个方法，即支持函数式编程
 *即对数据进行抽象，而函数式编程则是对行为进行抽象，是面向函数进行编程。
 * Lambda 表达式:由 3 部分组成：1、参数。2、->。3、函数主体。
 * 注意:
 *    能够使用 Lambda 表达式的必须是一个函数接口，函数接口是指该接口中只包含一个方法，如 Runnable 接口。
 */
public class lambda_01 {
    public static void main(String[] args) {
        lambda_01 test = new lambda_01();

//        如果函数接口的方法体只有一条语句，可省略 {};
        MathOperater add = (a,b)->a+b;
        MathOperater multi = (a,b)->a*b;
//        test.test(multi,1,2);
        test.test((a,b)->a+b);
//        如果函数接口的方法体包含多条语句，需要在 {} 中添加相关语句



    }
    public void test(MathOperater mathOperater){
        int a=10;
        int b=20;
        System.out.println(mathOperater.operater(a,b));
    }
     interface MathOperater{
         int operater(int a,int b);
    }
}
