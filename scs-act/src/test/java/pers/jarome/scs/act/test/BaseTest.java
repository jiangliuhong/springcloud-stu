package pers.jarome.scs.act.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.jarome.scs.act.ActApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    public final Logger logger = LoggerFactory.getLogger(getClass());

}
