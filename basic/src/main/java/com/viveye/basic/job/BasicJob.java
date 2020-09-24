package com.viveye.basic.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 * BasicJob
 *
 * @author Sssp
 * @date 2020/8/27 11:12
 */
@Component
public class BasicJob {

    @XxlJob("testBacisJob")
    public ReturnT<String> testBacisJob(String param) throws Exception{
        XxlJobLogger.log("----测试任务开始----");
        System.out.println("--------------------------------");
        System.out.println("----------测试测试测试测试--------");
        System.out.println("--------------------------------");
        XxlJobLogger.log("----测试任务结束----");
        return ReturnT.SUCCESS;
    }

}
