import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://demo.playwright.dev/todomvc/");
            page.navigate("https://demo.playwright.dev/todomvc/#/");
            page.navigate("https://www.google.com/");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Alles accepteren")).click();
            page.getByLabel("Zoek", new Page.GetByLabelOptions().setExact(true)).click();
            page.getByLabel("Zoek", new Page.GetByLabelOptions().setExact(true)).fill("amazon");
            page.getByText("Amazon", new Page.GetByTextOptions().setExact(true)).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Amazon.nl: Groot aanbod, kleine prijzen in o.a. Elektronica ... Amazon.nl https://www.amazon.nl")).click();
            //page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Officiële site van Amazon.nl® — Producten voor een lage prijs amazon.nl https://www.amazon.nl › shop")).click();
            page.getByLabel("Cookies aanvaarden").click();
            page.getByPlaceholder("Zoeken Amazon.nl").click();
            page.getByPlaceholder("Zoeken Amazon.nl").fill("nutella");
            page.getByPlaceholder("Zoeken Amazon.nl").press("Enter");
            page.getByText("\"nutella\"").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gesponsorde advertentie - Ferrero Nutella, per stuk verpakt (1 x 3 kg)")).click();
            page.locator("#productTitle").click();
        }
    }
}