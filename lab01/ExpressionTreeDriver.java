import expressiontree.*;
public class ExpressionTreeDriver {
    public static void main(String[] args) {
        // 2 + (8 * 3)
        ValueNode two = new ValueNode(2);
        ValueNode three = new ValueNode(3);
        ValueNode eight = new ValueNode(8);
        OpNode eightTimes3 = new OpNode(eight, "*", three);
        OpNode twoPlusEightTimesThree = new OpNode(two, "+", eightTimes3); 
        ExpressionTree tree = new ExpressionTree(twoPlusEightTimesThree); 
        System.out.println("print():");
        tree.print();
        System.out.println("evaluate():");
        System.out.println("" + tree.evaluate());
        System.out.println("");
        // (13 / 4) - (2 + (8 * 3))
        ValueNode thirteen = new ValueNode(13);
        ValueNode four = new ValueNode(4);
        OpNode thirteenOverFour = new OpNode(thirteen, "/", four); 
        OpNode bigExpression = new OpNode(thirteenOverFour,"+", twoPlusEightTimesThree);
        ExpressionTree tree2 = new ExpressionTree(bigExpression); 
        System.out.println("print():");
        tree2.print();
        System.out.println("evaluate():");
        System.out.println("" + tree2.evaluate()); 
    }
}