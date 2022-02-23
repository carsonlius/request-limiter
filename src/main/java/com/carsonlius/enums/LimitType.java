package com.carsonlius.enums;


/**
 * @version V1.0
 * @author: liusen
 * @date: 2022年02月22日 16时19分
 * @contact liusen@huice.com
 * @company 掌上先机 (http://www.huice.com)
 */
public enum LimitType {
    CUSTOMER("自定义限制"),
    IP("IP限制");

    private String desc;

    LimitType(String desc) {
        this.desc = desc;
    }
}
