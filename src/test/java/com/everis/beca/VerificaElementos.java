package com.everis.beca;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.remote.AndroidMobileCapabilityType;;

public class VerificaElementos {

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
        public void elementosTest () throws InterruptedException {
        	MobileElement el1 = (MobileElement) driver.findElementById("android:id/title");
        	el1.click();
        	String primeiroElemento = driver.findElementById("android:id/title").getText();
        	System.out.println("\nPrimeiro elemento: " + primeiroElemento);
        	assertEquals ("selendroid-test-app", primeiroElemento);
        	
        	
        	MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]");
        	el2.click();
        	String segundoElemento = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]").getText();
        	System.out.println("\nSegundo elemento: " + segundoElemento);
        	assertEquals ("Hello Default Locale, Selendroid-test-app!", segundoElemento);
        	
        	MobileElement el3 = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"l10nCD\"]/android.widget.TextView");
        	el3.click();
        	String terceiroElemento = driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"l10nCD\"]/android.widget.TextView").getText();
        	System.out.println("\nTerceiro elemento: " + terceiroElemento);
        	assertEquals ("Localization (L10n) locator test", terceiroElemento);
        	
        	Thread.sleep(3000);
        	
        	MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("buttonTestCD");
        	String quartoElemento = driver.findElementByAccessibilityId("buttonTestCD").getText();
        	System.out.println("\nQuarto elemento: " + quartoElemento);
        	assertEquals ("EN Button", quartoElemento);
        	el4.click();
        	
        	Thread.sleep(3000);
        	
        	MobileElement el5 = (MobileElement) driver.findElementById("android:id/button2");
        	String quintoElemento = driver.findElementById("android:id/button2").getText();
        	System.out.println("\nQuinto elemento: " + quintoElemento);
        	assertEquals ("No, no", quintoElemento);
        	el5.click();
        	
        	MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("waitingButtonTestCD");
        	String sextoElemento = driver.findElementById("waitingButtonTestCD").getText();
        	System.out.println("\nSexto elemento: " + sextoElemento);
        	assertEquals ("Show Progress Bar for a while", sextoElemento);
        	el6.click();
        	Thread.sleep(15000);
        	driver.navigate().back();
        	
        	
        	MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("visibleButtonTestCD");
        	String setimoElemento = driver.findElementByAccessibilityId("visibleButtonTestCD").getText();
        	System.out.println("\nSetimo elemento: " + setimoElemento);
        	assertEquals ("Display text view", setimoElemento);
        	el7.click();
        	
        	MobileElement el8 = (MobileElement) driver.findElementById("io.selendroid.testapp:id/visibleTextView");   	
        	String oitavoElemento = driver.findElementById("io.selendroid.testapp:id/visibleTextView").getText();
        	System.out.println("\nOitavo elemento: " + oitavoElemento);
        	assertEquals ("Text is sometimes displayed", oitavoElemento);
        	el8.click();
        	
        	MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("showToastButtonCD");
        	String nonoElemento = driver.findElementByAccessibilityId("showToastButtonCD").getText();
        	System.out.println("\nNono elemento: " + nonoElemento);
        	assertEquals ("Displays a Toast", nonoElemento);
        	el9.click();
        	
        	MobileElement el10 = (MobileElement) driver.findElementByAccessibilityId("showPopupWindowButtonCD");
        	String decimoElemento = driver.findElementByAccessibilityId("showPopupWindowButtonCD").getText();
        	System.out.println("\nDecimo elemento: " + decimoElemento);
        	assertEquals ("Display Popup Window", decimoElemento);
        	el10.click();
        	
        	Thread.sleep(3000);
        	
        	TouchAction <?> action = new TouchAction <> (driver);
        	action.tap(PointOption.point(368, 659)).perform();
        	
        	
        	String dsElemento = driver.findElementByAccessibilityId("exceptionTestButtonCD").getText();
        	System.out.println("\nDecimo segundo elemento: " + dsElemento);
        	assertEquals ("Press to throw unhandled exception", dsElemento);
        	
        	String dtElemento = driver.findElementById("io.selendroid.testapp:id/exceptionTestField").getText();
        	System.out.println("\nDecimo terceiro elemento: " + dtElemento);
        	assertEquals ("Type to throw unhandled exception", dtElemento);
        	
        	String dcElemento = driver.findElementById("io.selendroid.testapp:id/encodingTextview").getText();
        	System.out.println("\nDecimo quarto elemento: " + dcElemento);
        	assertEquals ("パソコン版にする", dcElemento);
        	
        	MobileElement el15 = (MobileElement) driver.findElementById("io.selendroid.testapp:id/topLevelElementTest");
        	String dqElemento = driver.findElementById("io.selendroid.testapp:id/topLevelElementTest").getText();
        	System.out.println("\nDecimo quinto elemento: " + dqElemento);
        	assertEquals ("Display and focus on layout", dqElemento);
        	el15.click();
        	
        	
        	String dsexElemento = driver.findElementById("io.selendroid.testapp:id/focusedText").getText();
        	System.out.println("\nDecimo sexto elemento: " + dsexElemento);
        	assertEquals ("Should only be found once", dsexElemento);
        	
        	
        	String dsetElemento = driver.findElementById("io.selendroid.testapp:id/touchTest").getText();
        	System.out.println("\nDecimo setimo elemento: " + dsetElemento);
        	assertEquals ("Touch Actions", dsetElemento);
        
        	
        	
        	Thread.sleep(4000);
        	
        }
       
         
        @After
        public void finishTest() {
                driver.closeApp();
                driver.quit();
        }
}