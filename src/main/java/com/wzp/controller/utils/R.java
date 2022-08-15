package com.wzp.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean flag; //是否成功
    private Object data; //数据
    private String msg;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
