package pages;

import com.microsoft.playwright.Page;
import components.*;

public class PageManager {
    private final Page page;

    public PageManager(Page page) {
        this.page = page;
    }

    public MainPage mainPage() {
        return new MainPage(page);
    }

    public RegistrationPage registrationPage() {
        return new RegistrationPage(page);
    }

    public RegistrationSuccessPage successPage(){
        return new RegistrationSuccessPage(page);
    }


    public NavigationMenu navigationMenu() {
        return new NavigationMenu(page);
    }

    public TopLinksBlock topLinksBlock() {
        return new TopLinksBlock(page);
    }

}
