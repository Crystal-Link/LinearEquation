public class QuadraticRoots
{
    private ComplexNumber root1;
    private ComplexNumber root2;

    public QuadraticRoots(ComplexNumber root)
    {
        root1 = root;
        double realPart = root.getRealMagnitude();
        double imaginaryPart = root.getImaginaryMagnitude();
        root2 = new ComplexNumber(realPart, imaginaryPart);
    }

    public QuadraticRoots(double r1, double r2)
    {
        root1 = new ComplexNumber(r1, 0);
        root2 = new ComplexNumber(r2, 0);
    }

    public ComplexNumber getRoot1()
    {
        return root1;
    }

    public ComplexNumber getRoot2()
    {
        return root2;
    }

    public String toString()
    {
        return "(" + root1.toString() + ", " + root2.toString() + ")";
    }

    public boolean areValid()
    {
        double real1 = root1.getRealMagnitude();
        double real2 = root2.getRealMagnitude();
        double imag1 = root1.getImaginaryMagnitude();
        double imag2 = root2.getImaginaryMagnitude();
        return (real1 == real2 && imag1 == imag2) || (imag1 == 0 && imag2 == 0);
    }
}
