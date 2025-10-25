package racingcar.domain.car.domain.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.domain.entity.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRepositoryTest {

    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
    }

    @Test
    @DisplayName("자동차 저장 및 조회 테스트")
    void saveAndFindAll() {
        // Given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        // When
        carRepository.save(List.of(car1,car2));


        // Then
        List<Car> cars = carRepository.findAll();
        assertThat(cars).hasSize(2);
        assertThat(cars).extracting(Car::getName)
                .containsExactly("pobi", "woni");
    }

    @Test
    @DisplayName("빈 저장소에서 조회 시 빈 리스트 반환")
    void findAllFromEmptyRepository() {
        // When
        List<Car> cars = carRepository.findAll();

        // Then
        assertThat(cars).isEmpty();
    }
}