import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    String husbandName;
    String wifeName;
    Person husband;
    Person wife;

    @Before
    public void setup() {
        husbandName = "Bob";
        wifeName = "Alice";
        husband = new Person(true, husbandName);
        wife = new Person(false, wifeName);
    }

    @Test
    public void marry() throws Exception {
        Person anotherWife = new Person(false, "Mallory");
        Person anotherHusband = new Person(true, "Walter");

        boolean isMarried = husband.marry(anotherHusband);
        Assert.assertFalse(isMarried);

        isMarried = wife.marry(anotherWife);
        Assert.assertFalse(isMarried);

        isMarried = husband.marry(anotherWife);
        Assert.assertTrue(isMarried);
        isMarried = wife.marry(anotherHusband);
        Assert.assertTrue(isMarried);

        isMarried = husband.marry(wife);
        Assert.assertTrue(isMarried);
        Assert.assertTrue(husband.getSpouse().equals(wife));
        Assert.assertTrue(wife.getSpouse().equals(husband));
        Assert.assertNull(anotherHusband.getSpouse());
        Assert.assertNull(anotherWife.getSpouse());
    }

    @Test
    public void divorce() throws Exception {
        husband.setSpouse(wife);
        wife.setSpouse(husband);

        boolean isDivorced = husband.divorce();

        Assert.assertTrue(isDivorced);
        Assert.assertNull(husband.getSpouse());
        Assert.assertNull(wife.getSpouse());

        isDivorced = husband.divorce();

        Assert.assertFalse(isDivorced);
    }

}