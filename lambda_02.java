package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @program: test
 * @description: 遍历集合
 * @author: zzh
 * @create: 2020-04-13 16:31
 **/
public class lambda_02 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello","World","Java");

        //不用lambda遍历集合
        for(String str:list){
            System.out.println(str);
        }

        //lambda遍历集合
        list.forEach(str-> System.out.println(str));

//        双冒号 ::  表示方法引用，可以引用其他方法。
        list.forEach(System.out::print);
    }
}
