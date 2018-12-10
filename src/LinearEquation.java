import javax.sound.sampled.Line;
import sun.plugin.javascript.navig.LinkArray;
import static java.lang.Double.isInfinite;

public class LinearEquation
{
    private double a;
    private double b;
    private double c;

    public boolean areValidParams(double a, double b)
    {
        if (a == 0 && b == 0)
        {
            return false;
        }
        else
            return true;
    }

    public LinearEquation(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public LinearEquation(double slope, Coords point)
    {
        a = slope * -1;
        double x = point.getX() * slope;
        c = x - point.getY();
        b = 1;
    }

    public LinearEquation(LinearEquation other)
    {
        a = other.a;
        b = other.b;
        c = other.c;
    }

    public LinearEquation(Coords point1, Coords point2)
    {
        double run = point1.getX() - point2.getX();
        double rise = point1.getY() - point2.getY();
        a = rise/run;
        b = 1;

    }

    public LinearEquation(LinearEquation other, Coords point)
    {
        this(other.slope(), point);
    }

    public double getA()
    {
        return a;
    }

    public double getB()
    {
        return b;
    }

    public double getC()
    {
        return c;
    }

    public double slope()
    {
        return a/b;
    }

    public boolean slopeDefined()
    {
        return (b != 0);
    }

    public boolean hasYIntercept()
    {
        return slopeDefined();
    }

    public boolean hasXIntercept()
    {
        return !isHorizontal();
    }

    public boolean isHorizontal()
    {
        return slope() == 0;
    }

    public double yIntercept()
    {
        return -this.c / this.b;
    }

    public double xIntercept()
    {
        return -this.c / this.a;
    }

    public double slopeOfPerpendicularLine()
    {
        return -this.b / this.a;
    }

    public boolean isIncreasing()
    {
        return slope() > 0;
    }

    public boolean isDecreasing()
    {
        return slope() < 0;
    }

    public boolean isVertical()
    {
        return isInfinite(slope());
    }

    public boolean isAFunction()
    {
        return this.b != 0;
    }

    public boolean isValidLinearEquation()
    {
        return this.a != 0 && this.b != 0;
    }

    public boolean isDirectVariation()
    {
        return this.c != 0;
    }

    public boolean equals(LinearEquation other)
    {
        return (this.a == other.a && this.b == other.b && this.c == other.c);
    }

    public LinearEquation parallelLine(Coords point)
    {
        return new LinearEquation(slope(), point);
    }

    public LinearEquation perpendicularLine(Coords point)
    {
        if (!this.isValidLinearEquation())
            return null;
        if (this.isHorizontal())
            return new LinearEquation(1, 0 , -1 * point.getX());
        if (this.isVertical())
            return new LinearEquation(0, 1, -1 * point.getX());
        else
            return new LinearEquation(slopeOfPerpendicularLine(), point);
    }

    public double shortestDistanceFrom(Coords point)
    {
        return point.distanceFrom(pointOfIntersection(perpendicularLine(point)));
    }

    public LinearEquation inverseFunction()
    {
        return new LinearEquation(this.b, this.a, this.c);
    }

    public boolean isParallel(LinearEquation other)
    {
        return this.slope() == other.slope();
    }

    public boolean isPerpendicular(LinearEquation other)
    {
        return this.slope() == -1 / other.slope();
    }

    public String toString()
    {
        return this.a + "x + " + this.b + "y + " + this.c + " = 0";
    }

    public String getSlopeInterceptForm()
    {
        return "y =  " + this.slope() + "x + " + this.yIntercept();
    }

    public Coords pointOfIntersection(LinearEquation other)
    {
        double d = other.a;
        double e = other.b;
        double f = other.c;
        double yIntersect = (c * d - a * f) / (b * d - a * e);
        double xIntersect = ((b * -1) * yIntersect - c) / a;
        return new Coords(xIntersect, yIntersect);
    }
}
