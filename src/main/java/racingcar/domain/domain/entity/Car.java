package racingcar.domain.domain.entity;

import java.util.UUID;

public class Car {

    private final String id;       // 자동차 고유 ID
    private final String name;     // 자동차 이름
    private long distance;         // 전진 거리

    public Car(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.distance = 0L;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getDistance() {
        return distance;
    }

    /**
     * 자동차 전진
     */
    public void move() {
        this.distance += 1;
    }
}
