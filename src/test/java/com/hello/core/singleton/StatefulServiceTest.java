package com.hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // 실제 Thread 는 사용하지 않았음

        //ThreadA: 사용자A 주문
        statefulService1.order("A",10000);

        //ThreadB: 사용자B 주문
        statefulService2.order("B",20000);

        //주문 조회 - 사용자A의 주문
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        // statefulService1.getPrice() 에서 10000이 아닌 20000의 결과값을 가져온다
        //  -> 필드를 공유해서 사용하는 문제점
        assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}