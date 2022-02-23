package com.carsonlius.aspects;

//import cn.hutool.core.thread.NamedThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version V1.0
 * @author: liusen
 * @date: 2022年02月23日 15时30分
 * @contact liusen@huice.com
 * @company 掌上先机 (http://www.huice.com)
 */
public class ConfineManager {

    private static Logger logger = LoggerFactory.getLogger(ConfineManager.class);


//    // 定时线程
//    private final ScheduledThreadPoolExecutor scheduledCheck = new ScheduledThreadPoolExecutor(2);
//    // 执行补充线程池
//    private final ExecutorService executorService = new ThreadPoolExecutor(5, 200,
//            60L, TimeUnit.SECONDS, new SynchronousQueue<>(),
//            new NamedThreadFactory("supplement",true,false));
//
//    // 限流器容器
//    private Map<String,RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();
//
//    @PostConstruct
//    public void init(){
//        scheduledCheck.scheduleAtFixedRate(new SupplementRateLimiter(), 1, 1, TimeUnit.SECONDS);
//    }
//
//    @PreDestroy
//    public void destroy(){
//        scheduledCheck.shutdown();
//    }
//
//    /**
//     * 通过key获取相应的限流器
//     */
//    public void acquire(String key,int tokenCount){
//        RateLimiter rateLimiter = rateLimiterMap.get(key);
//        // 双检锁确保安全创建
//        if(rateLimiter==null){
//            synchronized (this){
//                // init RateLimiter
//                rateLimiter = rateLimiterMap.computeIfAbsent(key, k -> new RateLimiter(tokenCount));
//            }
//        }
//        // 尝试获取令牌
//        if(!rateLimiter.acquire()){
//            // 获取失败，根据实际情况进行处理，这里直接抛异常了
////            Assert.throwBizException(ErrorCode.API_CONFINE_RATE_LIMITER);
//            System.out.println("被限流了");
//        }
//    }
//
//    /**
//     * 补充相应的令牌数
//     */
//    private class SupplementRateLimiter implements Runnable{
//        @Override
//        public void run(){
//            rateLimiterMap.values().forEach(rateLimiter -> rateLimiter.supplement(executorService));
//        }
//    }

    public static void main(String[] args) {


//        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
//        pool.scheduleAtFixedRate(() -> {
//            Random random = new Random();
//            int i = random.nextInt(5) * 1000;
//            try {
//                Thread.sleep(i);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            logger.info("run task, sleep :{}", i);
//        }, 1, 2, TimeUnit.SECONDS);



//        String url = "http://127.0.0.1:8080/limitTest2?name={name}";
//        Map<String,String> map = new HashMap<>();
//        map.put("name","zhang3");
//        ResponseEntity<String> result = restTemplate.getForEntity(url,String.class, map);


        String url = "http://127.0.0.1:8080/limitTest2";
        int j = 50;

        ExecutorService executor = Executors.newFixedThreadPool(j);
// 提交任务:
//        executor.submit(task2);
//        executor.submit(task3);
//        executor.submit(task4);
//        executor.submit(task5);
        for (int i = 0; i < j; i++) {

                    executor.submit(new Runnable() {
                        @Override
                        public void run() {
                            ResponseEntity<Map> result = (new RestTemplate()).getForEntity(url, Map.class);
                            System.out.println(" name: " + Thread.currentThread().getName() + result.getBody());
                        }
                    });
        }
        executor.shutdown();




    }
}
