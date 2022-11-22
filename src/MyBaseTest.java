import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.test.BaseTest;

public class MyBaseTest extends BaseTest {
    @Override
    protected Exercises createExercises() {
        return new MyExercises();
    }
}
