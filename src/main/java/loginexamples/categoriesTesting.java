package loginexamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class categoriesTesting {

    static WebElement urunlerButton;
    static WebElement closeButton;
    static WebElement AdetButton;
    static WebElement close1Button;
    static WebElement favButton;
    static WebElement kategori1Button;
    static WebDriver cdriver;
    static WebElement MixButton;
    static WebElement kategoriButton;
    static WebElement ocakButton;
    static int milis = 1000;
    static JavascriptExecutor jsx;
    static String expectedProductNameMessage = "GAYRET UCUZ OSMANLI OCAĞI";
    static String expectedFavButtonMessage = "Ürün Başarı ile Favorilere Eklendi";
    static String expectedMixButtonMessage = "Ürün Başarı ile Karşılaştırmalara Eklendi";
    static String actualFavButtonMessage;
    static String actualMixButtonMessage;
    static String actualProductNameMessage;


    @BeforeClass
    public void setUp() {
        cdriver = new ChromeDriver();
        jsx = (JavascriptExecutor) cdriver;
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cdriver.navigate().to("https://e-ticaretv1.sayedrabilisim.com/");
    }

    @AfterClass
    public void tearDown() {
        cdriver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        urunlerButton = cdriver.findElement(By.xpath("//span[normalize-space()='3D ÜRÜNLER']"));
        urunlerButton.click();
        Thread.sleep(milis);

    }

    @Test
    public void test02() throws InterruptedException {
        ocakButton = cdriver.findElement(By.xpath("//body/div[@class='dis']/div[@class='col-md-9 urunler_dis']/div[1]/div[1]/div[1]"));
        ocakButton.click();
        Thread.sleep(milis);
    }

    @Test
    public void test03() throws InterruptedException {
        jsx.executeScript("window.scrollBy(0,165)"); // sayfayı aşaği kaydirma
        Thread.sleep(milis);
    }

    @Test
    public void test04() throws InterruptedException {
        actualProductNameMessage = cdriver.findElement(By.cssSelector("div[class='col-md-12'] h1")).getText();
        Assert.assertEquals(actualProductNameMessage, expectedProductNameMessage);
        System.out.println("GAYRET UCUZ OSMANLI OCAĞI");
    }

    @Test
    public void test05() throws InterruptedException {
        kategoriButton = cdriver.findElement(By.xpath("//span[normalize-space()='3D YAZICI PARÇALARI']")); ////h2[normalize-space()='3D ÜRÜNLER']
        kategoriButton.click();
        Thread.sleep(milis);
    }

    @Test
    public void test06() throws InterruptedException {
        kategori1Button = cdriver.findElement(By.xpath("//ul[@class='kategoriler']//a[@title='3D ÜRÜNLER'][normalize-space()='3D ÜRÜNLER']"));
        kategori1Button.click();
        Thread.sleep(milis);

    }
    /*@Test
    /*public void test07() throws InterruptedException {

        favButton = cdriver.findElement(By.xpath("//span[normalize-space()='Favorilere Ekle']"));
        favButton.click();
        Thread.sleep(milis);
        actualFavButtonMessage = cdriver.findElement(By.cssSelector("div[class='modal-body'] center h3")).getText();
        Assert.assertEquals(actualFavButtonMessage, expectedFavButtonMessage);
        System.out.println("Ürün Başarı ile Favorilere Eklendi");
        closeButton = cdriver.findElement(By.cssSelector("button[type='button']"));
        closeButton.click();
        Thread.sleep(milis);
        MixButton = cdriver.findElement(By.xpath("//span[contains(text(),'Karşılaştır')]"));
        MixButton.click();
        Thread.sleep(milis);
        actualMixButtonMessage = cdriver.findElement(By.cssSelector("div[class='modal-body'] center h3")).getText();
        Assert.assertEquals(actualMixButtonMessage, expectedMixButtonMessage);
        System.out.println("Ürün Başarı ile Karşılaştırmalara Eklendi");
        close1Button = cdriver.findElement(By.cssSelector("button[type='button']"));
        close1Button.click();
        Thread.sleep(milis);
    }
    @Test
    public void test13() throws InterruptedException {
        AdetButton = cdriver.findElement(By.id("adet")); // id her zaman locatorlarda öneceliğe sahiptir!!
        boolean isClickableNoButton = AdetButton.isEnabled();
        Thread.sleep(milis);
        System.out.println("STATE: " + isClickableNoButton);
        if (isClickableNoButton ){
            System.out.println("Number of pieces is not selected");
        }else{
            System.out.println("Number of pieces selected");
            cdriver.quit();
        }
    }*/
}