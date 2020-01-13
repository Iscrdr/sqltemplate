package com.bzz.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @description：jdbc测试
 * @author ：Iscrdr
 * @email ：624003618@qq.com
 * @date ：2020/01/13 15:52
 * @modified By：
 * @version: 1.0.0$
 */
@SpringBootApplication(scanBasePackages = "com.bzz.cloud")
public class JdbcApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JdbcApp.class,args);
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(
                "select partition_name,count(*) from bzz_boss group by partition_name");
        maps.forEach(x ->{
            System.out.println(x.toString());
        });

    }
}
