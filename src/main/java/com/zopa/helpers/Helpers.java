package com.zopa.helpers;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Helpers {

    public static void setChromeDriverSystemProperty() {
        String pathToChromeDriverPrefix = "src/main/resources/chromedrivers/";
        String fullPathToChromeDriver = "";
        if (SystemUtils.IS_OS_MAC_OSX) {
            fullPathToChromeDriver = pathToChromeDriverPrefix.concat("chromedriver_mac64");
        } else if (SystemUtils.IS_OS_WINDOWS) {
            fullPathToChromeDriver = pathToChromeDriverPrefix.concat("chromedriver.exe");
        } else if (SystemUtils.IS_OS_LINUX) {
            fullPathToChromeDriver = SystemUtils.OS_ARCH.equals("x86_64") ? pathToChromeDriverPrefix.concat("chromedriver_linux64") : pathToChromeDriverPrefix.concat("src/main/resources/chromedrivers/chromedriver_linux32");
        }
        System.setProperty("webdriver.chrome.driver", fullPathToChromeDriver);
    }

    public static String nameGenerator() {
        String name = RandomStringUtils.randomAlphabetic(9);
        return StringUtils.capitalize(name.toLowerCase());
    }

    public static void writeToFile(String path, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }
}
