package com.github.chrislin.builderdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import java.util.concurrent.atomic.AtomicInteger;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PointBuilder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private PointHistoryService pointHistoryService;

    private static final AtomicInteger instanceCounter = new AtomicInteger(0);

    // build args
    private int x;
    private int y;
    private int z;

    public PointBuilder() {
        instanceCounter.incrementAndGet();
    }

    @Autowired
    public PointBuilder pointHistoryService(PointHistoryService service) {
        this.pointHistoryService = service;
        return this;
    }

    public PointBuilder x(int x) {
        this.x = x;
        return this;
    }

    public PointBuilder y(int y) {
        this.y = y;
        return this;
    }

    public PointBuilder z(int z) {
        this.z = z;
        return this;
    }


    static int getInstanceCounter() {
        return instanceCounter.get();
    }

    public Point build() {
        System.out.println(pointHistoryService.returnHello());
        return new Point(x, y, z);
    }

    public static PointBuilder newBuilder() {
        return applicationContext.getBean(PointBuilder.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PointBuilder.applicationContext = applicationContext;
    }
}
