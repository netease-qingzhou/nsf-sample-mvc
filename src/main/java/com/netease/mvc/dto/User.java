package com.netease.mvc.dto;

/**
 * 包:        com.netease.mvc.dto
 * 类名称:     User
 * 类描述:     用户信息
 * 创建人:     huangyang
 * 创建时间:   2020/12/7 9:19 上午
 */
public class User {

    private String id;
    private String name;
    private Integer age;

    private void setId(String id) {this.id = id;}
    private void setName(String name) {this.name = name;}
    private void setAge(Integer age) {this.age = age;}

    private String getId() {return this.id;}
    private String getName() {return this.name;}
    private Integer getAge() {return this.age;}
}
