package cor;

public class Yellow extends Chain {




    @Override
    public String check(int request) {
        if (request == 2) {
            return "YELLOW";
        } else {

           return  this.calculate(request);
        }
    }
}
