package ruOzon;

import ruOzon.listeners.TestListener;
import ruOzon.pages.PageJucierPower;
import ruOzon.util.SupportTestSettings;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
Авторизоваться на сайте, после авторизации проверить что на главной
странице отображается логин. Убедиться что кнопка “Войти в аккаунт”
сменилась на “Мой профиль”
 */
@Listeners({TestListener.class})
public class FourthTest extends SupportTestSettings {

    @Test
    public void thirdTest() {
        PageJucierPower pageObjectMain = new PageJucierPower(driver, webDriverWait);
        pageObjectMain.clickCatalog();
        pageObjectMain.clickTech();
        pageObjectMain.clickJuicer();
        pageObjectMain.minCost();
        pageObjectMain.maxCost();
        pageObjectMain.minPower();
        pageObjectMain.chooseCheap();
        pageObjectMain.checkCost();
        pageObjectMain.oneJuicier();
        pageObjectMain.goTo();
        pageObjectMain.clickBut();
        pageObjectMain.court();
    }
}