package com.alibaba.dubbo.demo.spi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author lch
 */
@SPI("impl")
public interface PrintService {

    void printInfo();
}


