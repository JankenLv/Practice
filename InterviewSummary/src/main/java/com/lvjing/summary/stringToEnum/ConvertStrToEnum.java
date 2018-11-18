package com.lvjing.summary.stringToEnum;

import org.junit.Test;

/**
 * String转换为Enum类型
 */
public class ConvertStrToEnum {

    @Test
    public void testEnum(){
//        System.out.println(RoleEnum.getRoleName(RoleEnum.Doctor));
        String role = "Teacher";
        User user = new User();
        user.setRole(RoleEnum.valueOf(role));
        System.out.println(user);
    }

}
