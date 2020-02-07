package com.pluralsight.calculatorengine;

public class Main {

    /*
    public static void main(String[] args) {
	//From Java Fundamentals (Pluralsight Course Java)
        int val1 = 95;
        int val2 = 75;
        int result;
        char operator = '/';

        if (operator == '+')
            result = val1 + val2;
        else if (operator == '-')
            result = val1 - val2;
        else if (operator == '*')
            result = val1 * val2;
        else if (operator == '/')
            result = val2 != 0 ? val1 / val2 : 0;
            /* if (val2 != 0)
                result = val1 / val2;
            else
                result = 0;
        else {
            System.out.println("Invalid operator!");
            result = 0;
        }
        System.out.println("result is " + result);
    }
    */

    /*
    public static void main (String[] args) {

        //float[] val1 = { 100.0f, 25.0f, 225.0f, 11.0f };
        //float[] val2 = { 75.0f, 85.0f, 95.0f, 105.0f };
        //char[] opCode = { 'a', 's', 'm', 'd' };
        //float[] result = new float[opCode.length];

        /*  EITHER THIS, OR SWITCH
        for(int i = 0; i < opCode.length; i++) {
            if (opCode[i] == 'a')
                result[i] = val1[i] + val2[i];
            else if (opCode[i] == 's')
                result[i] = val1[i] - val2[i];
            else if (opCode[i] == 'm')
                result[i] = val1[i] * val2[i];
            else if (opCode[i] == 'd') {
                result[i] = val2[i] !=0.0f ? val1[i] / val2[i] : 0.0f;
            }
        }

        /*
        //MathEquation[] equations = new MathEquation[4];
        //equations[0] = new MathEquation();

        MathEquation[] equations = new MathEquation[4];
        equations[0] = create(100.0f, 50.0f, 'd');
        equations[1] = create(25.0f, 92.0f, 'a');
        equations[2] = create(225.0f, 17.0f, 's');
        equations[3] = create(11.0f, 3.0f, 'm');

        //for(int i = 0; i < opCode.length; i++) {
        //}

        //for(float theResult : result) {
        //    System.out.println("result is " + theResult);
        // }

        */

    /*
        for(MathEquation equation : equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }
    }

    public static MathEquation create(float val1, float val2, char opCode) {
        MathEquation equation = new MathEquation();
        equation.setVal1(val1);
        equation.setVal2(val2);
        equation.setOpCode(opCode);

        return equation;

        //we have updated our mathequation class to properly hide the data inside it,
        //which will allow us to evolve it more effectively over time without impacting code that users our class
    }
    */

    public static void main(String[] args) {
//        MathEquation testEquation = new MathEquation();
//        testEquation.execute();
//        System.out.print("test=");
//        System.out.println(testEquation.getResult());

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);
        //now we're using constructor to create all the array elements

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());
        //widening conversion for double -> int

        equationOverload.execute((double)leftInt, rightInt);
        System.out.print("result=");
        System.out.println(equationOverload.getResult());
        //narrowing conversion is not legal, so it uses the method for double
        //java is intuitive :)
        //how the system uses a particular overload? http://bit.ly/javamethodselection

        //Class Inheritance: Calculator with Specialized Classes
        System.out.println();
        System.out.println("USING INHERITANCE");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d ),
                new Adder(25.0d, 92.0d ),
                new Subtracter(225.0d, 17.0d ),
                new Multiplier(11.0d, 3.0d)
        };

        for(CalculateBase calculator:calculators) {
            calculator.calculate();
            System.out.println("result = ");
            System.out.println(calculator.getResult());
        }
    }

//    public static MathEquation create(double leftVal, double rightVal, char opCode) {
//        MathEquation equation = new MathEquation();
//        equation.setLeftVal(leftVal);
//        equation.setRightVal(rightVal);
//        equation.setOpCode(opCode);

//        return equation;
//    }

}