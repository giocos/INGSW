package cor;

public class Blue extends Chain {


    @Override
    public String check(int request) {
        if (request == 0) {
            return "BLUE";
        } else {
            return this.calculate(request);
        }
    }
}
