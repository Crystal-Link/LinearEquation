import java.util.ArrayList;

public class Test
{
    public static void main(String[] args)
    {
        Coords point1 = new Coords(3, -7);
        Coords point2 = new Coords(2,1);
        Coords point3 = new Coords();
        Coords point4 = new Coords(point1);

        System.out.println(point1);
        System.out.println(point1.getX());
        System.out.println(point1.getY());
        point2.reflectonYAxis();
        point4.reflectOnXAxis();
        System.out.println(point2);
        System.out.println(point4);

        ComplexNumber equation1 = new ComplexNumber(4, 9);
        System.out.println(equation1.getImaginaryMagnitude());
        System.out.println(equation1.getRealMagnitude());

        ArrayList<Coords> myList = new ArrayList<Coords>();
                myList.add(new Coords(6,5));
    }
}
