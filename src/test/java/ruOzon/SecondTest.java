package ruOzon;

import ruOzon.listeners.TestListener;
import ruOzon.pages.PageMain;
import ruOzon.util.SupportTestSettings;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
Авторизоваться на сайте, после авторизации проверить что на главной
странице отображается логин. Убедиться что кнопка “Войти в аккаунт”
сменилась на “Мой профиль”
 */
@Listeners({TestListener.class})
public class SecondTest extends SupportTestSettings {

    @Test
    public void secondTest() {
        PageMain pageObjectMain = new PageMain(driver, webDriverWait);
        pageObjectMain.clickCity();
        pageObjectMain.changeCity();
        pageObjectMain.loginIn();
        pageObjectMain.inNumber();
        pageObjectMain.clickNumber();
        pageObjectMain.inCode();
        pageObjectMain.checkCity();

    }
}