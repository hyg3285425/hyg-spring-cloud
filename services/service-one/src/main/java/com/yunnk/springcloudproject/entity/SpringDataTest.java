package com.yunnk.springcloudproject.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 默认驼峰规则
 * @author huangyigang
 */
@Getter
@Setter
@ToString
@Entity
public class SpringDataTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String bigName;

    private String gentle;

    @Transient
    private String smallName;
}
