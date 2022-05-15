package prm2t.lab5;

public enum StrategyOutcome {
    /**
     * Punkty za "współpracę" obu graczy.
     */
    COOPERATION_REWARD(1),

    /**
     * Punkty za "zdradę" obu graczy.
     */
    DEFECTION_PUNISHMENT(-1),

    /**
     * Punkty dla gracza, który wybierze "zdradę", gdy drugi gracz wybierze "współpracę".
     */
    DEFECTION_REWARD(3),

    /**
     * Punkty dla gracza, który wybierze "współpracę", gdy drugi gracz wybierze "zdradę".
     */
    COOPERATION_PUNISHMENT(-2);

    final int points;
    StrategyOutcome(int points) {
        this.points = points;
    }
}
