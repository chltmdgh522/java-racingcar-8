package racingcar.domain.car.application.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.domain.car.application.service.RacingCarService;
import racingcar.domain.car.domain.entity.Car;
import racingcar.domain.car.domain.repository.CarRepository;
import racingcar.domain.car.presentation.view.OutputView;

/**
 * 자동차 경주 비즈니스 로직을 담당하는 서비스 구현 클래스.
 * <p>
 * 레이싱 준비, 진행, 우승자 계산 등의 핵심 로직을 수행한다.
 */
public class RacingCarServiceImpl implements RacingCarService {

    private final CarRepository carRepository;

    public RacingCarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * 경주 시작 전 자동차 목록을 저장한다.
     *
     * @param cars 경주에 참여할 자동차 리스트
     */
    @Override
    public void setupRace(List<Car> cars) {
        carRepository.save(cars);
    }

    /**
     * 주어진 시도 횟수만큼 경주를 진행한다.
     * 각 시도마다 자동차를 이동시키고, 이동 결과를 출력한다.
     *
     * @param attemptCount 시도 횟수
     */
    @Override
    public void playRace(long attemptCount) {
        while (attemptCount-- > 0) {
            moveCars();
            OutputView.printRaceStatus(carRepository.findAll());
        }
    }

    /**
     * 가장 멀리 이동한 자동차(우승자) 목록을 반환한다.
     *
     * @return 우승한 자동차 리스트
     */
    @Override
    public List<Car> winnerCars() {
        List<Car> cars = carRepository.findAll();
        long maxDistance = findMaxDistance(cars);
        return findCarsByDistance(cars, maxDistance);
    }

    /**
     * 각 자동차의 이동을 수행한다.
     * <p>
     * 0~9 사이의 랜덤 값을 생성하여, 4 이상일 경우 자동차를 한 칸 전진시킨다.
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
     * 모든 자동차 중 가장 멀리 이동한 거리(최대 거리)를 계산한다.
     *
     * @param cars 자동차 리스트
     * @return 가장 멀리 이동한 거리
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
     * 특정 거리만큼 이동한 자동차들을 찾아 반환한다.
     *
     * @param cars           자동차 리스트
     * @param targetDistance 기준 거리
     * @return 기준 거리에 도달한 자동차 리스트
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
