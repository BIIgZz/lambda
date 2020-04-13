package lambda;

/**
 * @program: test
 * @description: String流
 * @author: zzh
 * @create: 2020-04-13 16:36
 **/

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Description:
 *  Java8 针对数据处理提供了 Stream API，
 *  让开发者能够以声明的方式来处理数据，
 *  Stream 对数据的处理类似于 SQL 语句查询数据库，
 *  将数据集合抽象成一种流，提供传输流的管道，
 *  并且可以在管道的节点上添加处理，如过滤、排序等。
 *
 */
public class lambda_03 {
    /*
     * @Description: filter过滤
     *      filter() 方法是 Stream 提供的对数据进行过滤的 API，
     * 需要结合 Lambda 表达式来处理，比如过滤出目标集合中长度大于等于 5 的字符串
     */
    public void filterTest(List<String> list){
         list.stream().filter(str->str.length()>=5).forEach(str-> System.out.println("filter:"+str));
    }

    /*   Predicate 多条件过滤
     * @Description:如果需要通过多个条件对集合进行过滤，可以使用 Predicate 来处理，Predicate 可以定义具体的过滤条件，
     *              调用多次 filter() 方法，通过传入不同的 Predicate 对象来进行过滤
     */
    public void predicateTest(List<String> list){
        Predicate<String> predicate1 = str->str.length()>=5;
        Predicate<String> predicate2 = str->str.startsWith("H");
        list.stream()
                .filter(predicate1)
                .filter(predicate2)
                .forEach(s -> System.out.println("Predicate:"+s));

        // 也可以调用 Predicate 对象的 and() 方法，对多个 Predicate 对象进行且运算，或者用 or() 进行或运算
        list.stream()
                .filter(predicate1.and(predicate2))
                .forEach(s -> System.out.println("Predicate:"+s));
        
        //也可将 Predicate 作为参数传递给目标方法
    }
    
    /*  limit 截取
     * @Description:使用 limit() 方法可以对数据集合进行截取，原理与 SQL 语句的 limit 一致
     */
        public void  limitTest(List<String> list){
            list.stream()
                    .limit(2)
                    .forEach(s -> System.out.println("limit:"+s));

        //  limit() 也可以结合 filter() 来使用
            list.stream()
                    .filter(str->str.length()>=5)
                    .limit(1)
                    .forEach(str-> System.out.println("limit:"+str));
        }

    /*
     * @Description:sorted排序
     * 使用 sorted() 方法可以对目标集合的数据进行排序 默认升序
     *
     */
        public void sortTest (List<Integer> list){
            list.stream()
                    .sorted()
                    .forEach(num-> System.out.println("sorted降序："+num));

        //可通过添加 Comparator.reverseOrder() 进行降序排列
            list.stream()
                    .sorted(Comparator.reverseOrder())
                    .forEach(num-> System.out.println("sorted降序："+num));
        }
    /*
     * @Description:max 返回集合最大值，min 返回集合最小值
     * 需要注意的是 max() 和 min() 的返回值是 Optional 类型，Optional 也是 Java8 提供的新特性，
     * Optional 类是一个可以为 null 的容器对象，需要调用 get() 方法取出容器内的数据，具体操作如下所示。
     */
    public void maxAndMinTest (List<Integer> list){

        //  max
        System.out.println("max:"+list.stream().max(Integer::compareTo).get());

        // min
        System.out.println("min:"+list.stream().min(Integer::compareTo).get());

    }

    /*
     * @Description:map 对集合中元素进行特定操作
     *                  如集合中的每个元素 +10 之后输出，具体操作如下所示。
     */
    public void mapTest(List<Integer> list){
        list.stream()
                .map(num->num+10)
                .forEach(num-> System.out.println("mapTest:"+num));
    }

    /*
     * @Description:reduce 对集合中元素进行特定操作
     * reduce() 和 map() 一样，都可以对集合中元素进行操作，
     * 区别在于 reduce() 是将所有元素按照传入的逻辑进行处理，
     * 并将结果合并成一个值返回，如返回集合所有元素之和，操作如下所示。
     * 需要注意的是 reduce() 的返回值是 Optional 类型，需要调用 get() 方法取出容器内的数据
     */
    public void reduceTest(List<Integer> list){
        System.out.println("sum:"+list.stream().reduce((sum,num)->sum+num).get());
    }

    /*
     * @Description:collection 基于目标集合的元素生成新集合
     * 从目标集合中取出所有的奇数生成一个新的集合，具体操作如下所示。
     */
    public void collectionTest(List<Integer> list){
        List<Integer> collect = list.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
        collect.forEach(num-> System.out.println("collection:"+num));
    }



    public static void main(String[] args) {
        lambda_03 lambda_03 = new lambda_03();
        List<Integer> numList = Arrays.asList(1,6,2,3,5,4);
        List<String> stringList = Arrays.asList("Hello","World","Java");

        lambda_03.filterTest(stringList);
        lambda_03.limitTest(stringList);
        lambda_03.maxAndMinTest(numList);
        lambda_03.predicateTest(stringList);
        lambda_03.sortTest(numList);
        lambda_03.mapTest(numList);
        lambda_03.collectionTest(numList);
        lambda_03.reduceTest(numList);
    }
}
