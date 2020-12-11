public class Triangle extends Figure {

    private double leg;

    public double getLeg(){
        return leg;
    }

    public void setLeg(double leg){
        this.leg = leg;
    }

    public Triangle(double a , double b){
        super(a,b);
        leg = Math.min(a,b);
    }

    @Override
    public String getName(){
        return "Треугольник";
    }

    @Override
    public double getSquare(){
        return leg * leg / 2;
    }

    public double getPerimeter(){
        return (2 + Math.sqrt(2)) * leg;
    }
}
