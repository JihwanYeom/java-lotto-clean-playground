package domain;

public enum LottoRank {
    FOURTH_PRIZE(3,5000),
    THIRD_PRIZE(4,50000),
    SECOND_PRIZE(5,1500000),
    //SECOND_PRIZE(5,30000000),
    FIRST_PRIZE(6,2000000000);

    //final boolean isMatchedWithBonus;
    final int matchNumberCount;
    final long prize;

    LottoRank(int matchNumberCount/*, boolean isMatchedWithBonus*/, long prize) {
        this.matchNumberCount = matchNumberCount;
        //this.isMatchedWithBonus = isMatchedWithBonus;
        this.prize = prize;
    }

    public static LottoRank valueOfMatch(int matchCount) {
        if (matchCount == 6) return FIRST_PRIZE;
        if (matchCount == 5) return SECOND_PRIZE;
        if (matchCount == 4) return THIRD_PRIZE;
        return FOURTH_PRIZE;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public long getPrize() {
        return prize;
    }
}
