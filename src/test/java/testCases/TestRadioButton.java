package testCases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjects.RadioButtonPage;

import java.util.concurrent.TimeUnit;


public class TestRadioButton {
    private RemoteWebDriver wb;
    private RadioButtonPage rbp;
    private final String path="C:\\Users\\Tomasz\\Downloads\\chromedriver.exe";


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",path);
        wb = new ChromeDriver();
        wb.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wb.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void maleTestT1() throws Exception {
        rbp = new RadioButtonPage(wb);
        rbp.openViaUrl();
        rbp.initElements(wb);
        rbp.maleCheckBoxClickT1();
        rbp.buttonCheckClickT1();

        Assert.assertEquals("Radio button 'Male' is checked",rbp.getMessageAfterClickedT1().getText());
    }

    @Test
    public void femaleTestT1() throws Exception {
        rbp = new RadioButtonPage(wb);
        rbp.openViaUrl();
        rbp.initElements(wb);
        rbp.femaleCheckBoxClickT1();
        rbp.buttonCheckClickT1();

        Assert.assertEquals("Radio button 'Female' is checked",rbp.getMessageAfterClickedT1().getText());
    }

    @Test
    public void nothingCheckedTestT1() throws Exception {
        rbp = new RadioButtonPage(wb);
        rbp.openViaUrl();
        rbp.initElements(wb);
        rbp.buttonCheckClickT1();

        Assert.assertEquals("Radio button is Not checked",rbp.getMessageAfterClickedT1().getText());
    }

    @Test
    public void maleFifteenToFiftyTest() throws Exception {
        rbp=new RadioButtonPage(wb);
        rbp.openViaUrl();
        rbp.initElements(wb);
        rbp.maleCheckBoxClickT2();
        rbp.radioFifteenToFiftyClick();
        rbp.buttonCheckClickT2();

        Assert.assertEquals("Sex : Male\n" + "Age group: 15 - 50",rbp.getMessageAfterClickedT2().getText());
    }

    @Test
    public void femaleZeroToFive() throws Exception {
        rbp=new RadioButtonPage(wb);
        rbp.openViaUrl();
        rbp.initElements(wb);
        rbp.femaleCheckBoxClickT2();
        rbp.radioZeroToFiveClick();
        rbp.buttonCheckClickT2();

        Assert.assertEquals("Sex : Female\n" + "Age group: 0 - 5",rbp.getMessageAfterClickedT2().getText());
    }

    @Test
    public void nothingChckedT2() throws Exception {
        rbp=new RadioButtonPage(wb);
        rbp.openViaUrl();
        rbp.initElements(wb);
        rbp.buttonCheckClickT2();

        Assert.assertEquals("Sex :\n" + "Age group:",rbp.getMessageAfterClickedT2().getText());
    }

    @Test
    public void maleNothingCheckedT2() throws Exception {
        rbp=new RadioButtonPage(wb);
        rbp.openViaUrl();
        rbp.initElements(wb);
        rbp.maleCheckBoxClickT2();
        rbp.buttonCheckClickT2();

        Assert.assertEquals("Sex : Male\n" + "Age group:",rbp.getMessageAfterClickedT2().getText());
    }

    @Test
    public void nothingFiveFifteenCheckedT2() throws Exception {
        rbp=new RadioButtonPage(wb);
        rbp.openViaUrl();
        rbp.initElements(wb);
        rbp.radioFiveToFifteenClick();
        rbp.buttonCheckClickT2();

        Assert.assertEquals("Sex :\n" + "Age group: 5 - 15",rbp.getMessageAfterClickedT2().getText());
    }

    @After
    public void tearDown() throws Exception {
        wb.close();
        wb.quit();
    }
}
