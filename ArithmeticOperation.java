/** Abstract class for arithmetic expressions */
abstract class ArithmeticExp {
    public abstract int evaluate();
    public abstract String toStringRep();
}
/** Class for representing numbers in expressions */
class Number extends ArithmeticExp {
    private final int value;
    public Number(int value) {
        this.value = value;
    }
    @Override
    public int evaluate() {
        return value;
    }
    @Override
    public String toStringRep() {
        return Integer.toString(value);
    }
}
/** Abstract class for binary operations in expressions */
abstract class Binary extends ArithmeticExp {
    protected ArithmeticExp left;
    protected ArithmeticExp right;
    public Binary(ArithmeticExp left, ArithmeticExp right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public String toStringRep() {
        return left.toStringRep() + " " + getOperator() + " " + right.toStringRep();
    }
    protected abstract String getOperator();
}
/** Class for representing addition in expressions */
class Sum extends Binary {
    public Sum(ArithmeticExp left, ArithmeticExp right) {
        super(left, right);
    }
    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
    @Override
    protected String getOperator() {
        return "+";
    }
}
/** Class for representing multiplication in expressions */
class Product extends Binary {
    public Product(ArithmeticExp left, ArithmeticExp right) {
        super(left, right);
    }
    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
    @Override
    protected String getOperator() {
        return "*";
    }
}
/** Class for representing modulo in expressions */
class Modulo extends Binary {
    public Modulo(ArithmeticExp left, ArithmeticExp right) {
        super(left, right);
    }
    @Override
    public int evaluate() {
        int divisor = right.evaluate();
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return left.evaluate() % divisor;
    }
    @Override
    protected String getOperator() {
        return "%";
    }
}
/** Main class for testing the expressions */
public class ArithmeticOperation {
    public static void main(String[] args) {
        // Constructing the expression 2 + 5 * 3
        ArithmeticExp term = new Sum(
                new Number(2),
                new Product(
                        new Number(5),
                        new Number(3)
                )
        );
        System.out.println(term.toStringRep());
        System.out.println(term.evaluate());
        // Adding a new expression with modulo
        ArithmeticExp moduloTerm = new Modulo(
                new Number(12),
                new Number(13)
        );
        System.out.println(moduloTerm.toStringRep());
        System.out.println(moduloTerm.evaluate());
        ArithmeticExp term2 = new Sum(
                new Number(12),new Number(13)
        );
        System.out.println(term2.toStringRep());
        System.out.println(term2.evaluate());
    }
}
