package cor;

public class Green extends Chain{


    @Override
    public String check(int request) {
        if(request == 3) {
            return "GREEN";
        } else {
            return  this.calculate(request);
        }
    }
}
