package ruOzon;

import ruOzon.listeners.TestListener;
import ruOzon.pages.Page3ObjectMain;
import ruOzon.util.SupportTestSettings;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
Авторизоваться на сайте, после авторизации проверить что на главной
странице отображается логин. Убедиться что кнопка “Войти в аккаунт”
сменилась на “Мой профиль”
 */
@Listeners({TestListener.class})
public class ThirdTest extends SupportTestSettings {

    @Test
    public void thirdTest() {
        Page3ObjectMain pageObjectMain = new Page3ObjectMain(driver, webDriverWait);
        pageObjectMain.clickCatalog();
        pageObjectMain.clickTech();
        pageObjectMain.clickJuicer();
        pageObjectMain.minCost();
        pageObjectMain.maxCost();
        pageObjectMain.chooseCheap();
        pageObjectMain.checkCost();
        pageObjectMain.oneJuicier();
        pageObjectMain.goTo();
        pageObjectMain.clickBut();
        pageObjectMain.court();
    }
}