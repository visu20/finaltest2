/** Abstract class for arithmetic expressions */
abstract class ArithmeticExp {
    public abstract int evaluate();
}

/** Class for representing numbers in expressions */
class Number extends ArithmeticExp {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
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

        System.out.println(term.evaluate());
    }
}
