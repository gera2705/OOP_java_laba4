public abstract class Figure {
    protected double a;
    protected double b;

    public Figure(double a,double b){
        this.a = a;
        this.b = b;
    }

    public Figure(){}

    public double getA(){
        return a;
    }

    public void setA(double a){
        this.a = a;
    }

    public double getB(){
        return b;
    }

    public void setB(double b){
        this.b = b;
    }

    public abstract String getName();

    public abstract double getSquare();
}
