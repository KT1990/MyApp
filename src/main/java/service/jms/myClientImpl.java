package service.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class myClientImpl implements myClient {
    @Autowired
    Sender sender;

    @Autowired
    Receiver receive;

    @Override
    public void send(String msg) {
        sender.send(msg);
    }

    @Override
    public String receive() {
        return receive.receive();
    }
}
