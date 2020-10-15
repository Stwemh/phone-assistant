package com.tzh.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TangZongHua
 * @date 2020/10/15
 * @description 待完善
 */

@Data
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
public class MyException extends RuntimeException {
    /**
     * 异常信息, 待完善
     */
    private String msg;
}
