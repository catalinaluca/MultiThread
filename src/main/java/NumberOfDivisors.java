import java.util.concurrent.Callable;

public class NumberOfDivisors implements Callable {
    private int order,maximum=0;

    public NumberOfDivisors(int order) {
        this.order = order;
    }

    public int numberOfDivisors(int numberToBeDivided){
        int numberOfDivisors=0;
        for(int i=1;i<=numberToBeDivided;i++){
            if(numberToBeDivided%i==0)numberOfDivisors++;
        }

        return numberOfDivisors;
    }
    @Override
    public Integer call(){
        for (int i=order*10000;i<=(order+1)*10000;i++){
            int newNumberOfDivisors=numberOfDivisors(i);
            if(newNumberOfDivisors>this.maximum){
                this.maximum=newNumberOfDivisors;
            }
        }
        return maximum;
    }

    public int getMaximum() {
        return this.maximum;
    }
}
