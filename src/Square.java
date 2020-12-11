public class Square extends Figure{
    private double weight;

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public Square(double a , double b){
        super(a,b);
        weight = Math.min(a,b);
    }

    @Override
    public String getName(){
        return "Квадрат";
    }

    @Override
    public double getSquare(){
        return weight * weight;
    }

    public double getDiagonal(){
        return Math.sqrt(2) * weight;
    }
}
