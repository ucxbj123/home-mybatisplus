package com.maven.mybatisplus.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@EqualsAndHashCode
@Data
public class User {
//    @TableId
    private Long id;

    private String name;

    private Integer age;

    private String email;

}
