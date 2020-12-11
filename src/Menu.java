import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final static int CREATE = 1;
    private final static int DELETE = 2;
    private final static int GET_SQUARE = 3;
    private final static int EXIT = 0;

    private List<Figure> figures = new ArrayList<>();

    public void start() {
        int figureType;
        int userChoice;
        do {
            printMainMenu();
            userChoice = getUserIntInput(1);

            if (userChoice != CREATE && userChoice != DELETE && userChoice != GET_SQUARE && userChoice != EXIT) {
                start();
            }

             printFigureTypeMenu();
             figureType = getUserIntInput(2);

             if(figureType != 1 && figureType !=2 && figureType !=3){
                 start();
             }
            switch (userChoice) {
                case CREATE:
                    System.out.println("Введите первую сторону");
                    double a = getUserDoubleInput();
                    System.out.println("Введите вторую сторону");
                    double b = getUserDoubleInput();
                    createFigure(figureType, a, b);
                    break;
                case DELETE:
                    boolean deleteResult = deleteFigure(figureType);
                    if (!deleteResult)
                        System.out.println("Таких фигур в списке нет");
                    break;
                case GET_SQUARE:
                    printAllSquares(figureType);
            }
            printFiguresStatus();
        }
        while (true);
    }

    private void printFiguresStatus() {
        System.out.println("Общее колличество фигур - " + figures.size());
        System.out.println("Общее колличество кругов - " + countFigures(1));
        System.out.println("Общее колличество треугольников - " + countFigures(2));
        System.out.println("Общее колличество квадратов - " + countFigures(3));
    }

    private int countFigures(int type) {
        int result = 0;
        if (type == 1) {
            for (Figure figure : figures) {
                if (figure.getClass() == Circle.class) {
                    result++;
                }
            }
        }
        if (type == 2)
            for (Figure figure : figures) {
                if (figure.getClass() == Triangle.class) {
                    result++;
                }
            }
        if (type == 3)
            for (Figure figure : figures) {
                if (figure.getClass() == Square.class) {
                    result++;
                }
            }


        return result;
    }

    private void printAllSquares(int type) {
        if (type == 1) {
            for (Figure figure : figures) {
                if (figure.getClass() == Circle.class) {
                    System.out.println("В прямоугольник со сторонами " + figure.getA() + " и "+ figure.getB() + " можно вписать - " + figure.getName());
                    System.out.println("S = " + figure.getSquare());
                    System.out.println("l = " + ((Circle) figure).getLength());
                }
            }
        }
        if (type == 2)
            for (Figure figure : figures) {
                if (figure.getClass() == Triangle.class) {
                    System.out.println("В прямоугольник со сторонами " + figure.getA() + " и "+ figure.getB() + " можно вписать - " + figure.getName());
                    System.out.println("S = " + figure.getSquare());
                    System.out.println("P = " + ((Triangle) figure).getPerimeter());
                }
            }
        if (type == 3)
            for (Figure figure : figures) {
                if (figure.getClass() == Square.class) {
                    System.out.println("В прямоугольник со сторонами " + figure.getA() + " и "+ figure.getB() + " можно вписать - " + figure.getName());
                    System.out.println("S = " + figure.getSquare());
                    System.out.println("d = " + ((Square) figure).getDiagonal());
                }
            }
    }

    private void createFigure(int type, double a, double b) {
        Figure c = new Circle(a,b);
        Figure t = new Triangle(a,b);
        Figure s = new Square(a,b);
        if (type == 1)
            figures.add(c);
        if (type == 2)
            figures.add(t);
        if (type == 3)
            figures.add(s);

    }

    private boolean deleteFigure(int type) {
        if (type == 1) {
            for (Figure figure : figures) {
                if (figure.getClass() == Circle.class) {
                    figures.remove(figure);
                    return true;
                }
            }
        }
        if (type == 2)
            for (Figure figure : figures) {
                if (figure.getClass() == Triangle.class) {
                    figures.remove(figure);
                    return true;
                }
            }
        if (type == 3)
            for (Figure figure : figures) {
                if (figure.getClass() == Square.class) {
                    figures.remove(figure);
                    return true;
                }
            }
       return false;
   }

    private void printMainMenu() {
        System.out.println("1 - создать");
        System.out.println("2 - удалить");
        System.out.println("3 - информация");
        System.out.println("0 - выход");
    }

    private void printFigureTypeMenu() {
        System.out.println("1 – круг");
        System.out.println("2 – треугольник");
        System.out.println("3 – квадрат");
    }

    private int getUserIntInput(int level) {
        Scanner in = new Scanner(System.in);
        int result = -1;
        try {
            result =  Integer.parseInt(in.nextLine());
            if (result == EXIT)
               System.exit(0);

            if (result != CREATE && result != DELETE && result != GET_SQUARE && result != EXIT) {
                throw new RuntimeException();
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Ошибка ввода , команда должна быть цифрой!");
        }
        catch (RuntimeException e){
            System.out.println("Ошибка ввода");
        }

        return result;
    }

    private double getUserDoubleInput() {
        Scanner in = new Scanner(System.in);
        double result = -1;
        try {
            result =  Double.parseDouble(in.nextLine());
            if (result == EXIT)
                System.exit(0);

        }
        catch (NumberFormatException e)
        {
            System.out.println("Ошибка ввода!");
            getUserDoubleInput();
        }


        return result;
    }
}