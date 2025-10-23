package racingcar.domain.car.presentation.controller;

import java.util.List;
import racingcar.domain.car.application.service.CarDataService;
import racingcar.domain.car.application.service.RacingCarService;
import racingcar.domain.car.domain.entity.Car;
import racingcar.domain.car.presentation.view.InputView;
import racingcar.domain.car.presentation.view.OutputView;

/**
 * 레이싱카의 저장, 이동, 멈춤, 입출력 흐름을 제어하는 컨트롤러
 */
public class CarController {

    private final RacingCarService racingCarService;

    /**
     * 생성자를 통한 레이싱 서비스 주입
     *
     * @param racingCarService 레이싱 이동, 멈춤 로직을 담당하는 서비스
     */
    public CarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void racingCarRun() {
        List<Car> cars = InputView.inputCars();
        long attemptCount = InputView.inputAttemptCount();

        racingCarService.setupRace(cars);
        racingCarService.playRace(attemptCount);

        OutputView.printWinners(racingCarService.winnerCars());
    }
}
