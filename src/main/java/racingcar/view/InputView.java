package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<String> readCarNames() { //크기가 동적으로 변하는 리스트 선언
        System.out.println("자동차 이름을 입력하세요.(쉼표로 구분하여 5자 이하로 입력):");
        String input = Console.readLine();
        List<String> carNames = Arrays.stream(input.split(",")).map(String::trim).collect(Collectors.toList());
        return carNames;
    }

    public static int readTryCount() {
        System.out.println("몇번 시도 하실건가요?");
        String input = Console.readLine();
        int tryCount = Integer.parseInt(input);
        return tryCount;
    }
}