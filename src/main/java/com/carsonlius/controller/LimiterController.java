package com.carsonlius.controller;

import com.carsonlius.annos.Limit;
import com.carsonlius.enums.LimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version V1.0
 * @author: liusen
 * @date: 2022年02月22日 15时53分
 * @contact liusen@huice.com
 * @company 掌上先机 (http://www.huice.com)
 */
@RestController
public class LimiterController {
    public static final AtomicInteger ATOMIC_INTEGER_1 = new AtomicInteger();
    public static final AtomicInteger ATOMIC_INTEGER_2 = new AtomicInteger();
    public static final AtomicInteger ATOMIC_INTEGER_3 = new AtomicInteger();

    /**
     * @author fu
     * @description
     * @date 2020/4/8 13:42
     */
    @Limit(key = "limitTest", preiod = 10, count = 3)
    @GetMapping("/limitTest1")
    public int testLimiter1() {

        return ATOMIC_INTEGER_1.incrementAndGet();
    }


    /**
     * @author fu
     * @description
     * @date 2020/4/8 13:42
     */
    @Limit(key = "customer_limit_test", preiod = 20, count = 3, limitType = LimitType.CUSTOMER)
    @GetMapping("/limitTest2")
    public Map<String, Integer> testLimiter2() {
        Map<String, Integer> result = new HashMap<String, Integer>();
        result.put("放行的请求个数", ATOMIC_INTEGER_2.incrementAndGet());
        return result;
    }

    /**
     * @author fu
     * @description
     * @date 2020/4/8 13:42
     */
    @Limit(key = "ip_limit_test", preiod = 10, count = 3, limitType = LimitType.IP)
    @GetMapping("/limitTest3")
    public int testLimiter3() {

        return ATOMIC_INTEGER_3.incrementAndGet();
    }

}
