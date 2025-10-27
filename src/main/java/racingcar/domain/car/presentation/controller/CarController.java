package racingcar.domain.car.presentation.controller;

import racingcar.domain.car.application.service.RacingCarService;
import racingcar.domain.car.presentation.view.InputView;
import racingcar.domain.car.presentation.view.OutputView;

/**
 * 자동차 경주의 전체 흐름(입력, 처리, 출력)을 제어하는 컨트롤러 클래스.
 * <p>
 * 사용자의 입력을 받아 서비스 로직을 실행하고,
 * 결과를 출력 뷰에 전달한다.
 */
public class CarController {

    private final RacingCarService racingCarService;

    /**
     * RacingCarService를 주입받아 컨트롤러를 초기화한다.
     *
     * @param racingCarService 자동차 경주 비즈니스 로직을 처리하는 서비스
     */
    public CarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    /**
     * 자동차 경주 프로그램의 전체 실행 흐름을 담당한다.
     * <p>
     * 1. 사용자로부터 자동차 이름 목록을 입력받고 저장한다.
     * 2. 시도 횟수를 입력받아 경주를 진행한다.
     * 3. 최종 우승자를 출력한다.
     */
    public void racingCarRun() {
        racingCarService.setupRace(InputView.inputCars());
        racingCarService.playRace(InputView.inputAttemptCount());
        OutputView.printWinners(racingCarService.winnerCars());
    }
}
