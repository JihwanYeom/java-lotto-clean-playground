package view;

import domain.Lotto;
import domain.LottoNumber;
import domain.Price;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Price inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        return Price.from(scanner.nextInt());
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        List<String> winningNumbers = Arrays.asList(scanner.nextLine().split(","));
        List<LottoNumber> winningNumberList =
                winningNumbers.stream()
                .map(winningNumber -> LottoNumber.from(Integer.parseInt(winningNumber)))
                .collect(Collectors.toList());
        return Lotto.of(winningNumberList);
    }

}
