package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<String> readCarNames() { //크기가 동적으로 변하는 리스트 선언
        System.out.println("자동차 이름을 입력하세요.(쉼표로 구분하여 5자 이하로 입력):");
        String input = Console.readLine();
        List<String> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        validateCarNames(names);
        return names;
    }

    public static int readTryCount() {
        System.out.println("몇번 시도 하실건가요?");
        String input = Console.readLine();

        try {
            int tryCount = Integer.parseInt(input);
            validateTryCount(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력해주세요!");
        }
    }

   private static void validateCarNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 한 개 이상 입력해주세요!");
        }

       boolean hasBlankName = names.stream().anyMatch(String::isBlank);
       if (hasBlankName) {
           throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다!");
       }
   }

    private static void validateTryCount(int tryCount) {
        if (tryCount <= 0 ) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다!");
        }
    }
}