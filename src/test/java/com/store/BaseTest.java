package com.store;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookshopApplication.class) //springboot的启动类
@Transactional // 该注解保证测试用例会回滚
public class BaseTest {

}
