package com.g7go.springbootstartercachedemo.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private String id;

    private String name;

    private String address;

    private String tel;

    private Integer age;


}