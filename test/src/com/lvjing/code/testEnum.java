package com.lvjing.code;

public class testEnum {
    private enum size {
        small("小码"),middel("中码"),large("大码");
        private String cn_size;
        size(String cn_size){
            this.cn_size = cn_size;
        }
        public String getCn_size() {
            return cn_size;
        }
    };

    public static void main(String[] args) {
        for (size size : size.values()) {
            System.out.println(size);
        }
    }
}
