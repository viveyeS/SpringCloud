package com.viveye.basicapi.service;

import com.viveye.common.util.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ApiBasicService
 *
 * @author Sssp
 * @date 2020/8/13 16:11
 */
@FeignClient(value = "basic")
public interface ApiBasicService {

    @GetMapping("/getValue")
    ResponseResult getValue();

}
