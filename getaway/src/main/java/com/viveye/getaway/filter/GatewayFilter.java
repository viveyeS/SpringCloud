package com.viveye.getaway.filter;

import com.alibaba.fastjson.JSON;
import com.viveye.common.enumeration.CommonEnum;
import com.viveye.common.util.ResponseResult;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 全局过滤器
 *
 * @author Sssp
 * @date 2020/8/13 11:39
 */
@Component
public class GatewayFilter implements GlobalFilter, Ordered {

    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //通过 ServerWebExchange 获取 Request,Response
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //获取ip(0:0:0:0:0:0:0:1=127.0.0.1)
        String ip = request.getRemoteAddress().getAddress().getHostAddress().equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : request.getRemoteAddress().getAddress().getHostAddress();

        //黑名单
        List<String> BlackUrlList = new ArrayList<String>();
//        BlackUrlList.add("127.0.0.1");
        if(!BlackUrlList.isEmpty() && StringUtils.isNotBlank(ip) && BlackUrlList.contains(ip)){
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            return response.writeWith(
                    Mono.just(response.bufferFactory().wrap(JSON.toJSONBytes(new ResponseResult(CommonEnum.RETURN_CODE.FAIL.getValue(),"黑名单拒绝访问服务")))));
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }


}
