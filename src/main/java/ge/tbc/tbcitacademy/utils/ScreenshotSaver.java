package ge.tbc.tbcitacademy.utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.selenide.AllureSelenide;

public class ScreenshotSaver extends AllureSelenide {
    private boolean saveScreenshots;

    @Override
    public AllureSelenide screenshots(boolean saveScreenshots) {
        if (WebDriverRunner.hasWebDriverStarted()){
            this.saveScreenshots = saveScreenshots;
        }
        return this;
    }
}
