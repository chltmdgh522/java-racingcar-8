package racingcar.domain.car.application.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.car.application.service.RacingCarService;
import racingcar.domain.car.domain.entity.Car;
import racingcar.domain.car.domain.repository.CarRepository;

public class RacingCarServiceImpl implements RacingCarService {

    private final CarRepository carRepository;

    public RacingCarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void startRace(long attemptCount) {
        while (attemptCount-- > 0) {
            moveCars();
            printRaceStatus();
        }
    }


    @Override
    public void validateInput() {

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
     * 각 턴 결과 출력
     */
    private void printRaceStatus() {
        for (Car car : carRepository.findAll()) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(Math.toIntExact(car.getDistance())));
        }
        System.out.println();
    }
}
