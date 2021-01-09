package com.sst;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class CmsApplicationTests {

    @Test
    void contextLoads() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
    }

}
