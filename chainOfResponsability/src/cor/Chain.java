package cor;

public abstract class Chain {

    private Chain next;

    public Chain linkNext(Chain nextChain) {
        this.next = nextChain;
        return next;
    }

    public abstract String check(int request);

    public String calculate(int request) {
        if (this.next == null) {
            return "EMPTY";
        }
        return next.check(request);
    }
}
