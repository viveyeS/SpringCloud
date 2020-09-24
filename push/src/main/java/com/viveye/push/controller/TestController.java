package com.viveye.push.controller;

import com.viveye.basicapi.service.ApiBasicService;
import com.viveye.common.config.SpringConfig;
import com.viveye.common.enumeration.CommonEnum;
import com.viveye.common.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ApiBasicService apiBasicService;

    @RequestMapping("/test")
    public ResponseResult test(){
        ResponseResult responseResult = apiBasicService.getValue();
        String str = "许少的身高:";
        if(CommonEnum.RETURN_CODE.SUCCESS.getValue() == responseResult.getCode()){
            str = "许少的身高:"+responseResult.getData();
        }
        return new ResponseResult(str,CommonEnum.RETURN_CODE.SUCCESS.getValue(),"成功");
    }

}
