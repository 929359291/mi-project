package cn.alibaba.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zengxc
 * @since 2018/6/14
 */
public class LambdasTest {
    final static List<Compiler> LIST = new ArrayList<>();
    static {
        Compiler compiler1 = new Compiler("200", "success", "请求成功");
        Compiler compiler2 = new Compiler("201", "success", "请求成功");
        Compiler compiler3 = new Compiler("202", "success", "请求成功");
        LIST.add(compiler1);
        LIST.add(compiler2);
        LIST.add(compiler3);
    }

    @Test
    public void test03(){
        // collect 收集
        List<String> collect = LIST.parallelStream().map(Compiler::getCode).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        Map<String, Compiler> collect = LIST.stream().collect(Collectors.toMap(Compiler::getCode, Function.identity(), (e1, e2) -> e1));
        List<String> collect1 = LIST.stream().map(Compiler::getCode).collect(Collectors.toList());
        Map<String, List<Compiler>> collect2 = LIST.stream().collect(Collectors.groupingBy(Compiler::getCode));

        System.out.println(collect2);
        System.out.println(collect1);
        System.out.println(collect);
    }



    String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray"};

    @Test
    public void test01(){
        for (String s : atp) {
            println(s);
        }
        println("================");

        List<String> atps = Arrays.asList(atp);
        atps.forEach(System.out::println);
        println("================");

        atps.forEach(str ->{
            println(str);
        });
    }

    @Test
    public void test02(){
    }

    public static void println(Object obj){
        System.out.println(obj);
    }
}
