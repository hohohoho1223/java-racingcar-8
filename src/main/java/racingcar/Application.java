package racingcar;

import java.util.List;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        List<String> carNames = InputView.readCarNames();
        int tryCount =InputView.readTryCount();

        racingGame.start(carNames, tryCount);

        OutputView.printWinners(racingGame.getWinners());
    }
}
