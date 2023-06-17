package com.example.torder;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.torder.repository.ContentRepository;
import com.example.torder.repository.JdbcContentRepository;
import com.example.torder.repository.JdbcMemberRepository;
import com.example.torder.repository.MemberRepository;
import com.example.torder.service.ContentService;
import com.example.torder.service.MemberService;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
    }

    @Bean
    public ContentService contentService() {
        return new ContentService(contentRepository());
    }

    @Bean
    public ContentRepository contentRepository() {
        return new JdbcContentRepository(dataSource);
    }
}
