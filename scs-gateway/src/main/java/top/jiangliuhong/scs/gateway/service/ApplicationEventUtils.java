package top.jiangliuhong.scs.gateway.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * spring路由工具类
 */
@Component
public class ApplicationEventUtils implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher PUBLISHER;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        ApplicationEventUtils.PUBLISHER = publisher;
    }

    /**
     * 发布事件
     * @param event 事件
     */
    public static void pushEvent(ApplicationEvent event) {
        ApplicationEventUtils.PUBLISHER.publishEvent(event);
    }
}
