package com.lvjing.summary.stringToEnum;

/**
 * 身份枚举类
 */
public enum RoleEnum {

    Teacher("老师"),
    PoliceMan("警察"),
    Doctor("医生");

    /**
     * 角色中文名称
     */
    private String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public static RoleEnum getRole(String name) {
        return RoleEnum.valueOf(name);
    }

    public static String getRoleName(RoleEnum r) {
        return r.role;
    }
}
