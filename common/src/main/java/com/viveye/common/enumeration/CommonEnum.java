package com.viveye.common.enumeration;

/**
 * CommonEnum
 *
 * @author Sssp
 * @date 2020/8/12 15:15
 */
public class CommonEnum {

    /**
     * 通用返回状态码
     */
    public enum RETURN_CODE{
        /**
         * 成功
         */
        SUCCESS(200),
        /**
         * 失败
         */
        FAIL(500);

        private int value;

        private RETURN_CODE(final int value){ this.value = value; }

        public int getValue(){ return value; }
    }

}
