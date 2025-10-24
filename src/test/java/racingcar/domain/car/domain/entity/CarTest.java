package racingcar.domain.car.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 객체 생성 시 이름과 초기 거리가 정상적으로 설정되는지 확인")
    void createCar() {
        // Given
        String carName = "pobi";

        // When
        Car car = new Car(carName);

        // Then
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getDistance()).isEqualTo(0L);
    }

    @Test
    @DisplayName("자동차 전진 메소드 호출 시 거리가 1 증가하는지 확인")
    void moveCar() {
        // Given
        Car car = new Car("pobi");
        long initialDistance = car.getDistance();

        // When
        car.move();

        // Then
        assertThat(car.getDistance()).isEqualTo(initialDistance + 1);
    }
}