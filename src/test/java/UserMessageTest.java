import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.jms.myClient;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class UserMessageTest {

    @Autowired
    private myClient jsmClient;

    @Test(expected=NullPointerException.class)
    public void testReceive() throws Exception {
        jsmClient.send("Send data json");
        String status= jsmClient.receive();
        assertNotNull(status);
    }
}