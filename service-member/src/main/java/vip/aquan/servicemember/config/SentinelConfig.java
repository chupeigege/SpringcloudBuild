package vip.aquan.servicemember.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wcp
 * @date: 2020/9/29 23:22
 * @Description:
 */
@Configuration
public class SentinelConfig {
    public SentinelConfig(){
        WebCallbackManager.setUrlBlockHandler(new UrlBlockHandler() {
            @Override
            public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setCharacterEncoding("utf-8");
                httpServletResponse.getWriter().write("抱歉，您被Sentinel流控");
            }
        });
    }
}
