import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Created by Liliia_Klymenko on 13-May-15.
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Runner.class);
    }
}
