public class ComplexNumber
{
    private double a;
    private double b;

    public ComplexNumber(double realPart, double imaginaryPart)
    {
        a = realPart;
        b = imaginaryPart;
    }

    public ComplexNumber(ComplexNumber other)
    {
        a = other.a;
        b = other.b;
    }

    public double getRealMagnitude()
    {
        return a;
    }

    public double getImaginaryMagnitude()
    {
        return b;
    }


    public void add(double scalar)
    {
        a = a + scalar;
    }

    public void add(ComplexNumber other)
    {
        a = a + other.a;
        b = b + other.b;
    }

    public void subtract(double scalar)
    {
        a = a - scalar;
    }

    public void subtract(ComplexNumber other)
    {
        a = a - other.a;
        b = b - other.b;
    }

    public void multiply(double scalar)
    {
        a = a * scalar;
        b = b * scalar;
    }

    public void multiply(ComplexNumber other)
    {
        a = a * other.a;
        double c = a * other.b;
        c = c + (b * other.a);
        double d = (other.b * b) * -1;
        a = a + d;
        b = c;
    }

    public boolean divideBy(double scalar)
    {
        if (scalar == 0)
        {
            return false;
        }
        else
        {
            a = a / scalar;
            b = b / scalar;
            return true;
        }
    }

    public boolean divideBy(ComplexNumber other)
    {
        if (other.a == 0 && other.b == 0)
        {
            return false;
        }
        else
        {
            this.a = ((this.a * other.a) + (this.b * other.b)) / ((other.a * other.a) + (other.b * other.b));
            this.b = ((-this.a * other.b) + (this.b * other.a)) / ((other.a * other.a) + (other.b * other.b));
            return true;
        }
    }

    public String toString()
    {
        return this.a + " + " + this.b + "i";
    }
}
