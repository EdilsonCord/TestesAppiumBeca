package com.everis.beca;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class TestaTelas {
	
	private AppiumDriver<MobileElement> driver;

    @Before
    public void setup() throws MalformedURLException {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator_container");
            String appFile = "C:\\chromedriver\\selendroid-test-app-0.17.0.apk";
            cap.setCapability(MobileCapabilityType.APP, appFile);
            cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
            cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }
	@Test 
    public void testaTelas () throws InterruptedException {
    	
    	MobileElement el17 = (MobileElement) driver.findElementById("io.selendroid.testapp:id/touchTest");
    	el17.click();
    	MobileElement action = (MobileElement) driver.findElementById("io.selendroid.testapp:id/LinearLayout1");
    	action.click();
    	Thread.sleep(4000);
    	String confirma = driver.findElementById("io.selendroid.testapp:id/gesture_type_text_view").getText();
    	System.out.println("\nResultado: " + confirma);
    	assertEquals ("SINGLE TAP CONFIRMED", confirma);
    	Thread.sleep(3000);
    	
    	TouchAction <?> action1 = new TouchAction <> (driver);
    	action1.press(PointOption.point(620, 329)).moveTo(PointOption.point(238,835)).release().perform();
    	String confirma2 = driver.findElementById("io.selendroid.testapp:id/gesture_type_text_view").getText();
    	System.out.println("\nResultado2: " + confirma2);
    	assertEquals ("FLICK", confirma2);
    	Thread.sleep(3000);
    	driver.navigate().back();
    	
    	MobileElement clickChrome = (MobileElement) driver.findElementByAccessibilityId("buttonStartWebviewCD");
    	clickChrome.click();
    	MobileElement apagaNome = (MobileElement) driver.findElementByAccessibilityId("Enter your name here!");
    	apagaNome.clear();
    	MobileElement insereNome = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"Say Hello Demo\"]/android.view.View[2]/android.widget.EditText");
    	insereNome.sendKeys("Ed");
    	MobileElement clicaNoMenu = (MobileElement) driver.findElementByAccessibilityId("Volvo");
    	clicaNoMenu.click();
    	MobileElement selecionaCarro = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
    	selecionaCarro.click();
    	MobileElement confirmaEscolhas = (MobileElement) driver.findElementByAccessibilityId("Send me your name!");
    	confirmaEscolhas.click();
    	Thread.sleep(3000);
    	driver.navigate().back();
    	
    	MobileElement clicarRegistro = (MobileElement) driver.findElementByAccessibilityId("startUserRegistrationCD");
    	clicarRegistro.click();
    	MobileElement inserirNome = (MobileElement) driver.findElementById("io.selendroid.testapp:id/inputUsername");
    	inserirNome.sendKeys("Edilson");
    	MobileElement inserirEmail = (MobileElement) driver.findElementByAccessibilityId("email of the customer");
    	inserirEmail.sendKeys("edilson.cordeiro@outlook.com");
    	MobileElement inserirSenha = (MobileElement) driver.findElementById("io.selendroid.testapp:id/inputPassword");
    	inserirSenha.sendKeys("aloalo@");
    	MobileElement inserirMr = (MobileElement) driver.findElementById("io.selendroid.testapp:id/inputName");
    	inserirMr.clear();
    	inserirMr.sendKeys("Mr. Ed");
    	MobileElement clicarLinguagem = (MobileElement) driver.findElementById("io.selendroid.testapp:id/input_preferedProgrammingLanguage");
    	clicarLinguagem.click();
    	MobileElement selecionarLinguagem = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[6]");
    	selecionarLinguagem.click();
    	MobileElement aceitarAdds = (MobileElement) driver.findElementById("io.selendroid.testapp:id/input_adds");
    	aceitarAdds.click();
    	MobileElement clicarEmRegistrar = (MobileElement) driver.findElementById("io.selendroid.testapp:id/btnRegisterUser");
    	clicarEmRegistrar.click();
 
    	
    	String confirmaNome = driver.findElementById("io.selendroid.testapp:id/label_name_data").getText();
    	System.out.println("\nNome: " + confirmaNome);
    	assertEquals ("Mr. Ed", confirmaNome);
    	Thread.sleep(4000);
    	String confirmaUser = driver.findElementById("io.selendroid.testapp:id/label_username_data").getText();
    	System.out.println("\nUsername: " + confirmaUser);
    	assertEquals ("Edilson", confirmaUser);
    	Thread.sleep(4000);
    	String confirmaSenha = driver.findElementById("io.selendroid.testapp:id/label_password_data\r\n").getText();
    	System.out.println("\nSenha: " + confirmaSenha);
    	assertEquals ("aloalo@", confirmaSenha);
    	Thread.sleep(4000);
    	String confirmaEmail = driver.findElementById("io.selendroid.testapp:id/label_email_data").getText();
    	System.out.println("\nE-mail: " + confirmaEmail);
    	Thread.sleep(4000);
    	assertEquals ("edilson.cordeiro@outlook.com", confirmaEmail);
    	String confirmaLinguagem = driver.findElementById("io.selendroid.testapp:id/label_preferedProgrammingLanguage_data\r\n").getText();
    	System.out.println("\nLinguagem: " + confirmaLinguagem);
    	assertEquals ("Java", confirmaLinguagem);
    	Thread.sleep(4000);
    	String confirmaAdds = driver.findElementById("io.selendroid.testapp:id/label_acceptAdds_data\r\n").getText();
    	System.out.println("\nAdds: " + confirmaAdds);
    	assertEquals ("true", confirmaAdds);
    	Thread.sleep(4000);
    	
    	Thread.sleep(4000);
    	MobileElement finalizar = (MobileElement) driver.findElementById("io.selendroid.testapp:id/buttonRegisterUser");
    	finalizar.click();
    	
    	Thread.sleep(3000);
    	
    }
	
    @After
    public void finishTest() {
            driver.closeApp();
            driver.quit();
    }
}
    

