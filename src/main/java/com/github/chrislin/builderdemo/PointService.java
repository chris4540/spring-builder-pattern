package com.github.chrislin.builderdemo;

import org.springframework.stereotype.Service;



@Service
class PointService {

    private final PointBuilder pointBuilder;

    public PointService(PointBuilder pointBuilder) {
        this.pointBuilder = pointBuilder;
    }

    Point createZero() {
        return pointBuilder.build();
    }

    Point createOne() {
        return PointBuilder.newBuilder()
            .x(1)
            .y(1)
            .z(1)
            .build();
    }
}