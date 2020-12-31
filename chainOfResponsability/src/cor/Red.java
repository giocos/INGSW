package cor;

public class Red extends Chain {

    @Override
    public String check(int request) {
        if (request == 1) {
            return "RED";
        } else {
            return this.calculate(request);
        }
    }
}
