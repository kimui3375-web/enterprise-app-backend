package com.gildong.enterprise_app;

import com.gildong.enterprise_app.domain.Member;
import com.gildong.enterprise_app.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnterpriseAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterpriseAppApplication.class, args);
    }

    // 애플리케이션 시작 시 한 번 실행되는 테스트용 코드
    @Bean
    public CommandLineRunner testData(MemberRepository memberRepository) {
        return args -> {
            // DB에 데이터가 하나도 없을 때만 샘플 회원 저장
            if (memberRepository.count() == 0) {
                Member m = new Member("gildong", "길동님", "gildong@example.com");
                memberRepository.save(m);
                System.out.println(">>> 샘플 회원 저장 완료: " + m.getId());
            } else {
                System.out.println(">>> 기존 회원 수: " + memberRepository.count());
            }
        };
    }
}
