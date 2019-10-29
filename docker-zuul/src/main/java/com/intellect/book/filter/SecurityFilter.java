package com.intellect.book.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @author yang jianbing
 * @Description 自定义filter 网关鉴权
 * @date 2019-07-18 21:22
 */
public class SecurityFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(SecurityFilter.class);

    @Override
    public String filterType() {
//        logger.info("filterType");
        return "pre";
    }

    @Override
    public int filterOrder() {
//        logger.info("filterOrder");
        return 0;
    }

    @Override
    public boolean shouldFilter() {
//        logger.info("shouldFilter");
        return false;
    }

    @Override
    public Object run() {
//        logger.info("run");
        return null;
    }
}
