package com.viveye.basic.controller;

import com.viveye.common.enumeration.CommonEnum;
import com.viveye.common.util.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author Sssp
 * @date 2020/8/12 15:10
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public ResponseResult test(){
        return new ResponseResult(CommonEnum.RETURN_CODE.SUCCESS.getValue(),"成功");
    }

    @GetMapping("/getValue")
    public ResponseResult getValue(){
        return new ResponseResult("100",CommonEnum.RETURN_CODE.SUCCESS.getValue(),"成功");
    }

}
