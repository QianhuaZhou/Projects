package com.hmdp;

import com.hmdp.service.impl.ShopServiceImpl;
import com.hmdp.utils.CacheClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class HmDianPingApplicationTests {
    @Resource
    private CacheClient cacheClient;

    @Resource
    private ShopServiceImpl shopService;


    @Test
    void testSaveShop() throws InterruptedException {
        shopService.saveShop2Redis(1L, 10L);
    }



}
