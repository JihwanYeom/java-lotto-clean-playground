package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FIFTH_PRIZE(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000),
    NO_PRIZE(0, false, 0);

    final boolean hasBonusNumber;
    final int matchNumberCount;
    final long prize;

    LottoRank(int matchNumberCount, boolean hasBonusNumber, long prize) {
        this.matchNumberCount = matchNumberCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static LottoRank matchRank(int matchNumberCount, boolean hasBonusNumber) {
        if (matchNumberCount == 6) {
            return LottoRank.FIRST_PRIZE;
        }
        if (matchNumberCount == 5 && hasBonusNumber) {
            return LottoRank.SECOND_PRIZE;
        }
        if (matchNumberCount == 5) {
            return LottoRank.THIRD_PRIZE;
        }
        if (matchNumberCount == 4) {
            return LottoRank.FOURTH_PRIZE;
        }
        if (matchNumberCount == 3) {
            return LottoRank.FIFTH_PRIZE;
        }
        return LottoRank.NO_PRIZE;
    }

    public long getPrize() {
        return prize;
    }

    public static List<LottoRank> ranks() {
        return Stream.of(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.NO_PRIZE)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(matchNumberCount).append("개 일치");
        if (matchNumberCount == 5 && hasBonusNumber) {
            builder.append(", 보너스 볼 일치");
        }
        builder.append(" (").append(prize).append("원) - ");
        return builder.toString();
    }
}
