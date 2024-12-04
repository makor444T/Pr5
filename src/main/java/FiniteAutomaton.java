public class FiniteAutomaton {
    private enum State {
        S, S1, S2, S3, F
    }

    private State state;

    public FiniteAutomaton() {
        state = State.S;
    }

    public int process(String input) {
        state = State.S;
        for (char c : input.toCharArray()) {
            switch (state) {
                case S -> state = (c == 'T') ? State.S1 : State.S;
                case S1 -> state = (c == 'E') ? State.S2 : (c == 'T' ? State.S1 : State.S);
                case S2 -> state = (c == 'S') ? State.S3 : (c == 'T' ? State.S1 : State.S);
                case S3 -> state = (c == 'T') ? State.F : State.S;
            }
        }
        return state.ordinal();
    }

    public boolean isAccepted() {
        return state == State.F;
    }
}
