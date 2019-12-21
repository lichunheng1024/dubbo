package com.alibaba.dubbo.demo.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author lch
 */
public class PrintServiceImpl implements PrintService {

    @Override
    public void printInfo() {
        System.out.println("--hello dubbo spi mechanism---");
    }


    public static void main(String[] args) {
        PrintService printService= ExtensionLoader.getExtensionLoader(PrintService.class).getExtension("aaa");

        printService.printInfo();
    }
}



