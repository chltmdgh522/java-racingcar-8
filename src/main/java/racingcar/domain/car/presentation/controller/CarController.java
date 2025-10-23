package racingcar.domain.car.presentation.controller;

import racingcar.domain.car.application.service.RacingCarService;
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
        racingCarService.setupRace(InputView.inputCars());
        racingCarService.playRace(InputView.inputAttemptCount());
        OutputView.printWinners(racingCarService.winnerCars());
    }
}
