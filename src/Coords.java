import java.util.ArrayList;

public class Coords
{
    private double x;
    private double y;

    public Coords(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Coords()
    {
        x = 0.0;
        y = 0.0;
    }

    public Coords(double value)
    {
        x = value;
        y = value;
    }

    public Coords(Coords other)
    {
        this.x = other.x;
        this.y = other.y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public void reflectOnXAxis()
    {
        this.y = y * -1;
    }

    public void reflectonYAxis()
    {
        this.x = x * -1;
    }

    public void reflectOnOrigin()
    {
        this.y = y * -1;
        this.x = x * -1;
    }

    public void translate(double horizontal, double vertical)
    {
        x = x + horizontal;
        y = y + vertical;
    }

    public void dilate(double dilationFactor)
    {
        x = x * dilationFactor;
        y = y * dilationFactor;
    }

    public double distanceFromOrigin()
    {
        return Math.sqrt(x * x + y * y);
    }

    public double distanceFrom(Coords other)
    {
        double deltaX = this.x - other.x;
        double deltaY = this.y - other.y;
        double deltaXSquared = deltaX * deltaX;
        double deltaYSquared = deltaY * deltaY;
        double deltaSquaredSum = deltaXSquared + deltaYSquared;
        double distance = Math.sqrt(deltaSquaredSum);
        return distance;
    }

    public boolean equals(Coords otherPoint)
    {
        return (this.x == otherPoint.x && this.y == otherPoint.y);
    }

    public double getSlopeOfLineSegment(Coords other)
    {
        double rise = other.y + this.y;
        double run = other.x + this.x;
        return rise/run;
    }

    public boolean slopeOfLineSegmentDefined(Coords other)
    {
        return (this.x - other.x ) != 0;
    }

    public static Coords closestPointToOrigin(ArrayList<Coords> points)
    {
        Coords closestPoint = points.get(0);
        for (Coords c : points)
        {
            if (c.distanceFromOrigin() < closestPoint.distanceFromOrigin())
            {
                closestPoint = c;
            }
        }

        return closestPoint;
    }

    public int compareByDistanceFromOrigin(Coords other)
    {
        int comparison = 0;

        if (this.distanceFromOrigin() > other.distanceFromOrigin())
        {
            comparison = 1;
        }

        if (this.distanceFromOrigin() < other.distanceFromOrigin())
        {
            comparison = -1;
        }

        return comparison;
    }

    public static void sortByDistanceFromOrigin(Coords[] points)
    {
        for (int i = 0; i < points.length - 1; i++)
        {
            int lowPosition = i;

            for (int j = i + 1; j <points.length; j++)
            {
                if (points[j].compareByDistanceFromOrigin(points[lowPosition]) < 0)
                {
                    lowPosition = j;
                }

                swap(i, lowPosition, points);
            }
        }
    }

    private static void swap(int indexA, int indexB, Coords[] arr)
    {
        Coords temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public int compareByDistanceFromThis(Coords p1, Coords p2)
    {
        int comparison = 0;

        if (this.distanceFrom(p1) > this.distanceFrom(p2))
        {
            comparison = 1;
        }

        if (this.distanceFrom(p1) < this.distanceFrom(p2))
        {
            comparison = -1;
        }

        return comparison;
    }

    public void sortByDistanceFromThis(Coords[] points)
    {
        for (int i = 0; i < points.length - 1; i++)
        {
            int lowPosition = i;

            for (int j = i + 1; j <points.length; j++)
            {
                if (this.compareByDistanceFromThis(points[j], points[lowPosition]) < 0)
                {
                    lowPosition = j;
                }

                swap(i, lowPosition, points);
            }
        }
    }

}
