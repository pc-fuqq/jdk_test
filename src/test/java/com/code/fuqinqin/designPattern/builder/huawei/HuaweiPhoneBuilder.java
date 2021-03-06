package com.code.fuqinqin.designPattern.builder.huawei;

import com.code.fuqinqin.designPattern.builder.IPhone;
import com.code.fuqinqin.designPattern.builder.PhoneBuilder;

/**
 * <p>华为手机构建者</p>
 *
 * @author fuqinqin3
 * @version 1.0
 * @date 2021/1/21 10:16
 */
public class HuaweiPhoneBuilder implements PhoneBuilder {
    @Override
    public void marketAnalysis() {
        System.out.println("华为手机-市场调研");
    }

    @Override
    public void marketResearch() {
        System.out.println("华为手机-市场分析");
    }

    @Override
    public void design() {
        System.out.println("华为手机-工业设计");
    }

    @Override
    public void hardwareProduct() {
        System.out.println("华为手机-硬件生产");
    }

    @Override
    public void softwareDevelop() {
        System.out.println("华为手机-软件开发");
    }

    @Override
    public void productTest() {
        System.out.println("华为手机-产品测试");
    }

    @Override
    public IPhone listed() {
        System.out.println("华为手机-上市");
        return new HuaweiPhone();
    }
}
