import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import service.MyModel;
import service.MyModelRepository;
import static org.junit.Assert.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MyModelRepository userRepository;

    @Test(expected=NullPointerException.class)
    public void testAdd() {
        MyModel user = new MyModel();
        user.setLogin("test");
        user.setPass("test");
        user.setMail("test@gmail.com");
        user.setFio("test");

        MyModel savedUser = userRepository.save(user);
        MyModel existUser = entityManager.find(MyModel.class, savedUser.getId());

        assertEquals(savedUser.getMail(),existUser.getMail());
    }
}