package com.springcloud.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description : 自定义过滤器
 * @Author : wsz
 * @Date: 2020-07-02 14:16
 */
@Component
@Slf4j
public class CustomFilter extends ZuulFilter {

    /**
     * 返回字符串代表过滤器的类型
     * pre 路由前
     * routing 路由中
     * post 路由后
     * error 发送错误
     *
     * 不可为null，否则NPE异常
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否过滤
     * @return false不过滤，true过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体规则
     * @return
     */
    @SneakyThrows
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");

        if (StringUtils.isEmpty(token)) {
            log.warn("token is empty");

            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);

            context.getResponse().getWriter().write("token is empty");
            return null;
        }
        log.info("token=" + token);
        return null;
    }
}
