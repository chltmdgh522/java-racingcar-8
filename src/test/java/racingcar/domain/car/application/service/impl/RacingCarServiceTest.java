package racingcar.domain.car.application.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.application.service.RacingCarService;
import racingcar.domain.car.domain.entity.Car;
import racingcar.domain.car.domain.repository.CarRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RacingCarServiceTest {

    private CarRepository carRepository;
    private RacingCarService racingCarService;
    private List<Car> testCars;

    @BeforeEach
    void setUp() {
        // 직접 테스트 데이터 설정
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        // 첫 번째 차량만 1칸 이동
        car1.move();

        testCars = Arrays.asList(car1, car2, car3);

        // 실제 CarRepository와 CarDataService를 사용
        carRepository = new CarRepository();
        racingCarService = new RacingCarServiceImpl(carRepository);
    }

    @Test
    @DisplayName("레이스 설정 후 모든 자동차가 저장되었는지 확인")
    void setupRace() {
        // Given & When
        racingCarService.setupRace(testCars);

        // Then
        List<Car> savedCars = carRepository.findAll();
        assertThat(savedCars).hasSize(testCars.size());
        assertThat(savedCars.stream().map(Car::getName))
                .containsExactlyInAnyOrder("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("가장 멀리 이동한 자동차가 우승자로 선정되는지 확인")
    void findWinners_SingleWinner() {
        // Given
        racingCarService.setupRace(testCars);

        // When
        List<Car> winners = racingCarService.winnerCars();

        // Then
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("동일한 거리를 이동한 자동차들이 공동 우승자로 선정되는지 확인")
    void findWinners_MultipleWinners() {
        // Given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move();
        car2.move();
        List<Car> tiedCars = Arrays.asList(car1, car2, new Car("jun"));

        racingCarService.setupRace(tiedCars);

        // When
        List<Car> winners = racingCarService.winnerCars();

        // Then
        assertThat(winners).hasSize(2);
        assertThat(winners.stream().map(Car::getName))
                .containsExactlyInAnyOrder("pobi", "woni");
    }
}