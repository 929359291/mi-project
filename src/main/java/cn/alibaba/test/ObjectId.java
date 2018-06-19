package cn.alibaba.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zengxc
 * @since 2018/6/13
 */
public class ObjectId {

    private ObjectId() {
    }

    static ExecutorService pool = Executors.newFixedThreadPool(100);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
//        List<Future<Boolean>> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            Future<Boolean> submit = pool.submit((Callable<Boolean>) () ->{
//                return getObjectId() == getObjectId();
//            });
//            list.add(submit);
//        }
//        for (Future future: list) {
//             println(future.get());
//        }
        for (int i = 0; i < 100; i++) {
            println(getObjectId() == getObjectId());
        }
        println("线程并发比较耗时： " + (System.currentTimeMillis() - start));
    }

    private static ObjectId objectId = null;


    public static synchronized ObjectId getObjectId02() {
        if (objectId == null) {
            objectId = new ObjectId();
        }
        return objectId;
    }

    /**
     * 单例模式终极解
     */
    private static class SingletonFactory {
        private final static ObjectId OBJECT_ID = new ObjectId();
    }

    public static ObjectId getObjectId() {
        return SingletonFactory.OBJECT_ID;
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }
}
