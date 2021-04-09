package test;

import test.helper.NamedThreadFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: leetcode
 * @description: 线程池源码分析
 * @author: Micah
 * @create: 2021-03-28 16:28
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
        Analysis analysis = new ThreadPoolTest().new Analysis();
        analysis.entrance();
    }

    class Analysis{
        private final ThreadPoolExecutor excutor = new ThreadPoolExecutor(5,10,5,
                TimeUnit.MINUTES,new LinkedBlockingDeque<>(20),new NamedThreadFactory("thread-pool-"));
        private void entrance(){
            for (int i = 0; i < 30; i++) {
                excutor.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "正在执行");
                });
            }
        }
    }
}
