import org.junit.Assert;
import org.junit.Test;


public class TestHesh {

    @Test
    public void testClass(){
        Item i = new Item("**");
        int size = 3;

        Table tableTest = new Table(size);

        Table result = new Table(size);
        result.add(i);
        result.add(i);
        result.add(i);

        Assert.assertEquals(tableTest,result);



    }

}
