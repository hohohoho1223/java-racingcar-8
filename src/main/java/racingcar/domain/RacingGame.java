package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class RacingGame {
    private Cars cars; // Cars 클래스 타입의 객체 주소를 담을 (참조)변수 선언
    private final List<String> winners = new ArrayList<>();

    // 게임 시작 전, 참가 자동차(Car)들을 등록하는 생성자
    // 데이터와 행동을 함께 묶는 게 핵심이므로, 문자열 각 요소를 Car 객체로 바꿔서  데이터+행동을 하나로 묶기위함
    public void start(List<String> carNames, int tryCount) {
        this.cars = new Cars(carNames);
        playRounds(tryCount);
        winners.addAll(cars.findWinners());
    }

    private void playRounds(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            List<Integer> randomNumbers = generateRandomNumbers(cars.getCars().size());
            cars.moveAll(randomNumbers);
            OutputView.printRoundResult(cars.getCars());
        }
    }

    private List<Integer> generateRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(Randoms.pickNumberInRange(0,9));
        }
        return randomNumbers;
    }

    public List<String> getWinners() {
        return new ArrayList<>(winners);
    }
}
