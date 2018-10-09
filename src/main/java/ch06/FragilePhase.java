package ch06;

// Using ordinal() to index array of arrays - DON'T DO THIS!
public enum FragilePhase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
        // Rows indexed by from-ordinal, cols by to-ordinal
        private static final Transition[][] TRANSITIONS = {
            {null, MELT, SUBLIME},
            {FREEZE, null, BOIL},
            {DEPOSIT, CONDENSE, null}
        };

        // Returns the phase transition from one phase to another
        public static Transition from(FragilePhase from, FragilePhase to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}

