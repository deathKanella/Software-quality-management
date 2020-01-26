import org.junit.Assert;
import org.junit.Test;

public class TestCalc {
    @Test
    public void testAdd(){
        main.java.Calc calc = new main.java.Calc();
        int add = calc.add(3,4);
        Assert.assertEquals(7,add);
    }
}
