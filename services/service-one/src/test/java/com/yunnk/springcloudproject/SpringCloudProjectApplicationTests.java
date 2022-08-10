package com.yunnk.springcloudproject;

import com.yunnk.springcloudproject.dao.TestDao;
import com.yunnk.springcloudproject.entity.SpringDataTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
class SpringCloudProjectApplicationTests {
    @Resource
    private TestDao testDao;

    @Test
    void testJpaSave() {
        SpringDataTest springDataTest = new SpringDataTest();
        springDataTest.setBigName("ksadjfaklsjdfaskfj");
        springDataTest.setGentle("女");
        springDataTest.setName("黄三刚");
        springDataTest.setSmallName("cat");
        SpringDataTest save = testDao.save(springDataTest);
        log.info(save.toString());
    }

    @Test
    void testJpaExample(){
        SpringDataTest springDataTest = new SpringDataTest();
        springDataTest.setName("黄一刚");
        Example<SpringDataTest> springDataTestExample = Example.of(springDataTest);
        List<SpringDataTest> all = testDao.findAll(springDataTestExample);
        log.info(all.toString());
    }

    @Test
    void testJpaExampleMatcher(){
        SpringDataTest springDataTest = new SpringDataTest();
        springDataTest.setName("三");
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::contains);
        Example<SpringDataTest> springDataTestExample = Example.of(springDataTest,exampleMatcher);
        List<SpringDataTest> all = testDao.findAll(springDataTestExample);
        log.info(all.toString());
    }
}
