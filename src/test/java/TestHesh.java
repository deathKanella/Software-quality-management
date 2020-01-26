import org.junit.Assert;
import org.junit.Test;


public class TestHesh {

//    @Test
//    public void testClass() {
//        Item i = new Item("**");
//        int size = 3;
//
//        Table tableTest = new Table(size);
//
//        Table result = new Table(size);
//        result.add(i);
//        result.add(i);
//        result.add(i);
//
//        Assert.assertEquals(tableTest, result);
//
//    }

    @Test
    public void testHashInsert() {
        Table hashTableTest = new Table(7);
        hashTableTest.insert("rhino");
        hashTableTest.insert("man");
        hashTableTest.insert("computer");
        hashTableTest.insert("home");
        hashTableTest.insert("basket");
        hashTableTest.insert("Ferrari");
        hashTableTest.insert("nam");

        Table heshTableResult = new Table(7);

    }

    @Test
    public void testClass1() {

        Table tableTest = new Table(3);

    }
}
