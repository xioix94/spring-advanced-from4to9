package hello.proxy.config.v1_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import hello.proxy.config.v1_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import hello.proxy.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
        OrderControllerV2 controllerImpl = new OrderControllerV2(orderServiceV2(logTrace));
        OrderControllerConcreteProxy orderControllerConcreteProxy = new OrderControllerConcreteProxy(controllerImpl, logTrace);
        return orderControllerConcreteProxy;
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 serviceImpl = new OrderServiceV2(orderRepository(logTrace));
        OrderServiceConcreteProxy orderServiceConcreteProxy = new OrderServiceConcreteProxy(serviceImpl, logTrace);
        return orderServiceConcreteProxy;
    }

    @Bean
    public OrderRepositoryV2 orderRepository(LogTrace logTrace) {
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();
        OrderRepositoryConcreteProxy orderRepositoryConcreteProxy = new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
        return orderRepositoryConcreteProxy;
    }
}
