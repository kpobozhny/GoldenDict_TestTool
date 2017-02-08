package com.goldendict.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Kostiantyn Pobozhni on 08.02.2017.
 */
public class RegisterPage {

    public static SelenideElement accountExistsLink = $(By.xpath(".//*[@text='Already have an account?']"));
}
