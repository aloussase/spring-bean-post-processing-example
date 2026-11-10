package io.github.aloussase.beanpostprocessor.infrastructure.processors;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;

@Component
public class DisallowNullArgumentsPostProcessor implements BeanPostProcessor {
    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        final var klass = bean.getClass();
        if (!klass.getPackageName().startsWith("io.github.aloussase.beanpostprocessor.services")) {
            return bean;
        }
        final var enhancer = new Enhancer();
        enhancer.setSuperclass(klass);
        enhancer.setCallback((MethodInterceptor) (o, method, args, proxy) -> {
            for (final var arg : args) {
                if (arg == null) {
                    throw new IllegalArgumentException("Null arguments are not allowed");
                }
            }
            return method.invoke(bean, args);
        });
        return enhancer.create();
    }
}
