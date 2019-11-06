package com.lv.code.thread.test.futuretest;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class MfutureTest {
    private static final ThreadFactory threadFactory = new ThreadFactoryBuilder()
            //线程名格式
            .setNameFormat("MfutureTest-Thread-%d")
            .build();
    private static final ExecutorService executorService = new ThreadPoolExecutor(
            10, 20, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(100000), threadFactory);

    private static void test() {
        List<Integer> lis = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<List<Integer>> tradeDataList = Lists.partition(lis, 3);
        List<Future<int[]>> futureList = new ArrayList<>();
        tradeDataList.forEach(list ->
                futureList.add(executorService.submit(() -> {
                    try {
                        log.error("ShardUtil.setShardContext(shopShard)");
                        return doProcessTrade(list);
                    } catch (Exception e) {
                        log.error("doProcessTrade error,", e);
                        return new int[]{0, 0};
                    } finally {
                        log.error("ShardUtil.cleanShardContext()");
                    }
                })));

        futureList.forEach(future -> {
            try {
                int[] countSet = future.get();
                log.error("第一个值 | {}", countSet[0]);
                log.error("第二个值 | {}", countSet[1]);
            } catch (Exception e) {
                log.warn("doProcessTrade error,", e);
            }
        });
    }

    private static int[] doProcessTrade(List<Integer> list) {
        int[] countSet = {0, 0};
        countSet[0] = list.get(0);
        countSet[1] = list.get(1);
        return countSet;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            test();
        }
    }

}
