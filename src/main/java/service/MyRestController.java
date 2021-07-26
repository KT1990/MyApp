package service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import service.jms.myClient;

@RestController
public class MyRestController {

    @Autowired
    myClient jsmClient;

    @Autowired
    private MyModelRepository userRepository;

    @PostMapping("/add/")
    public void Add(MyModel user) {
        MyModel newUser=userRepository.save(user);

        //Отправляем newUser в json формате на проверку
        jsmClient.send(newUser.toString());

        //В приёмник получаем ответ
        String status=jsmClient.receive();

        //Если status ок, то отправляем письмо на почту newUser.getMail()
    }
}
