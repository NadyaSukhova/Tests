package ruOzon;

import ruOzon.listeners.TestListener;
import ruOzon.pages.Page1ObjectMain;
import ruOzon.util.SupportTestSettings;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
Авторизоваться на сайте, после авторизации проверить что на главной
странице отображается логин. Убедиться что кнопка “Войти в аккаунт”
сменилась на “Мой профиль”
 */
@Listeners({TestListener.class})
public class FirstTest extends SupportTestSettings {

    @Test
    public void firstTest() {
        Page1ObjectMain pageObjectMain = new Page1ObjectMain(driver, webDriverWait);
        pageObjectMain.loginIn();
        pageObjectMain.inNumber();
        pageObjectMain.clickNumber();
        pageObjectMain.inCode();

    }
}