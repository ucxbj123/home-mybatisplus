package com.atguigu.mybatisplus.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@EqualsAndHashCode
@Data
@ApiModel(description = "用户实体类",value = "用户对象")
public class User {
    @ApiModelProperty(notes = "id of the user",name="id",value = "工号")
    private Long id;

    @ApiModelProperty(notes = "name of the user",name="name",value = "姓名")
    private String name;

    @ApiModelProperty(notes = "age of the user",name="age",value = "年龄")
    private Integer age;

    @ApiModelProperty(notes = "email of the user",name="email",value = "邮件")
    private String email;


}
