import javax.sound.sampled.Line;

public class QuadraticEquation
{
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(QuadraticEquation other)
    {
        other.a = a;
        other.b = b;
        other.c = c;
    }

    public QuadraticEquation()
    {
        a = 1;
        b = 0;
        c = 0;
    }

    public QuadraticEquation(double coeffecient, Coords vertex)
    {
        a = coeffecient;
        double h = vertex.getX();
        double k = vertex.getY();
        b = -2 * coeffecient * h;
        c = (h * h) * coeffecient + k;

    }

    public double getDiscriminant()
    {
        double discriminant = ((b * b) - (4 * a * c));
        return discriminant;
    }

    public boolean hasRealRoots()
    {
        return getDiscriminant() >= 0;
    }

    public boolean hasEqualRoots()
    {
        return getDiscriminant() == 0;
    }

    public boolean hasMinimum()
    {
        return a > 0;
    }

    public boolean hasMaximum()
    {
        return a < 0;
    }

    public LinearEquation axisOfSymmetry()
    {
        return new LinearEquation(1, 0, b / (2 * a));
    }

    public LinearEquation derivative()
    {
        return new LinearEquation(a * 2, -1, b);
    }

    public QuadraticRoots getRoots()
    {
        if (a != 0)
        {
            double real1 = -b / (2 * a);
            double real2 = real1;
            double imag = Math.sqrt(((b * b) - (4 * a * c)) / (2 * a));
            if (hasRealRoots() || hasEqualRoots())
            {
                real1 += imag;
                real2 -= imag;
                return new QuadraticRoots(real1, real2);
            }
            else
            {
                ComplexNumber root = new ComplexNumber(real1, imag);
                return new QuadraticRoots(root);
            }
        }

        return null;
    }
}
