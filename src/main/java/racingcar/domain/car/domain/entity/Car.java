package racingcar.domain.car.domain.entity;

import java.util.UUID;

/**
 * 자동차 경주에 사용되는 개별 자동차를 표현하는 엔티티 클래스.
 * <p>
 * 각 자동차는 고유 ID, 이름, 이동 거리 정보를 가진다.
 */
public class Car {

    /**
     * 자동차 고유 식별자 (UUID 기반)
     */
    private final String id;

    /**
     * 자동차 이름
     */
    private final String name;

    /**
     * 현재까지 이동한 거리
     */
    private long distance;

    public Car(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.distance = 0L;
    }

    /**
     * 자동차를 한 칸 전진시킨다.
     * <p>
     * distance 값을 1 증가시킨다.
     */
    public void move() {
        this.distance += 1;
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

}
