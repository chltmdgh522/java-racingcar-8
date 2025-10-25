package racingcar.domain.car.application.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.domain.car.application.service.RacingCarService;
import racingcar.domain.car.domain.entity.Car;
import racingcar.domain.car.domain.repository.CarRepository;
import racingcar.domain.car.presentation.view.OutputView;

public class RacingCarServiceImpl implements RacingCarService {

    private final CarRepository carRepository;

    public RacingCarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void setupRace(List<Car> cars) {
        carRepository.save(cars);
    }

    @Override
    public void playRace(long attemptCount) {
        while (attemptCount-- > 0) {
            moveCars();
            OutputView.printRaceStatus(carRepository.findAll());
        }
    }

    @Override
    public List<Car> winnerCars() {
        List<Car> cars = carRepository.findAll();
        long maxDistance = findMaxDistance(cars);
        return findCarsByDistance(cars, maxDistance);
    }

    /**
     * 각 자동차의 랜덤 이동 거리 4 이상이면 한 칸씩 전진 아니면 정지
     */
    private void moveCars() {
        for (Car car : carRepository.findAll()) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                car.move();
            }
        }
    }

    /**
     * 가장 멀리 이동한 거리(우승 기준 거리)를 계산한다.
     */
    private long findMaxDistance(List<Car> cars) {
        long maxDistance = 0L;
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }

    /**
     * 특정 거리까지 도달한 자동차 목록을 반환한다.
     */
    private List<Car> findCarsByDistance(List<Car> cars, long targetDistance) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (Objects.equals(car.getDistance(), targetDistance)) {
                winners.add(car);
            }
        }
        return winners;
    }


}
