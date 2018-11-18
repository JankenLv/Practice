package org.lvjing.Resource;

import org.junit.Test;

/**
 * 提供头发的设置参数
 */
public class HairConf {

    /**
     * 发型选项
     */
    public enum HairStyle {
        straight("直发"), wave("大波浪型"), pony_tail("马尾发型");

        private String cn_hairStyle;

        HairStyle(String cn_hairStyle) {
            this.cn_hairStyle = cn_hairStyle;
        }

        public String getCn_hairStyle() {
            return cn_hairStyle;
        }
    }


    /**
     * 发色选项
     */
    public enum HairColor {
        red("红色"), black("黑色"), golden("金色");

        private String cn_hairColor;

        HairColor(String cn_hairColor) {
            this.cn_hairColor = cn_hairColor;
        }

        public String getCn_hairColor() {
            return cn_hairColor;
        }
    }

    /*@Test
    public void testHairStyle() {
        System.out.println(HairStyle.pony_tail);
    }*/

}
