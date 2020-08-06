package com.ucarinc.wtf.train;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;


/**
 * @author shengzhen.feng
 * @date 2020/6/24 15:06
 **/
public class OpenChrome {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String str = df.format(date);
        String fileUrl = "C:\\D-drive-67453\\screen\\" + str;
        File file = new File(fileUrl);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 指定chrome driver的获取地址
        System.setProperty("webdriver.chrome.driver", "C:\\D-drive-67453\\chromedriver.exe");

        //实例化webdriver的对象，启动谷歌浏览器
        WebDriver driver = new ChromeDriver(chromeOptions());

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 元素等待时间
        //driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);// 页面加载时间
        //driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);// ajax请求
        driver.manage().window().maximize();

        //通过对象driver调用具体的get方法来打开网页
        driver.get("https://110.80.12.205:446/cas/login?service=https%3A%2F%2F110.80.12.205%3A9090%2Fcoms%2F%3Fhome_page%3Dhttps%3A%2F%2F110.80.12.205%3A446%2Fcas%2Feportal%2Fhome.action%26_random%3D0103966446544");

        driver.findElement(By.className("u-input2")).sendKeys("xmhdw");
        driver.findElement(By.className("ipt-pswd")).sendKeys("HDW@5111151");
        driver.findElement(By.className("btn-login")).click();

        WebElement developElement = driver.switchTo().frame("_iframe").findElement(By.cssSelector(".textbox-addon.textbox-addon-right"));
        developElement.click();
        WebElement webElement = driver.findElement(By.className("tree"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        traversalNode(driver, developElement, webElement, fileUrl);

        //退出浏览器
        driver.quit();

    }

    /**
     * 禁止chrome弹出忽略网站证书错误提示
     * @return
     */
    public static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type", "--ignore-certificate-errors");

        return options;
    }

    public static void traversalNode(WebDriver driver, WebElement developElement, WebElement webElement, String fileUrl) {
        if (webElement == null) {
            return;
        }
        Queue<WebElement> list = new LinkedList<>();
        list.add(webElement);
        while (!list.isEmpty()) {
            WebElement element = list.remove();
            List<WebElement> webElements = element.findElements(By.tagName("li"));
            for (WebElement web : webElements) {
                if (web.findElements(By.cssSelector(".tree-hit.tree-collapsed")).size() == 0) {
                    WebElement nowWeb = web.findElement(By.className("tree-title"));
                    nowWeb.click();
                    System.out.println(nowWeb.getAttribute("title"));
                    print(driver, fileUrl + "\\" + nowWeb.getAttribute("title") + ".png");
                    developElement.click();
                } else {
                    web.findElement(By.cssSelector(".tree-hit.tree-collapsed")).click();
                    System.out.println(element.findElements(By.tagName("ul")).size());
                    list.add(web.findElement(By.tagName("ul")));
                }
            }
        }
    }

    public static void print(WebDriver driver, String fileUrl) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(fileUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
