import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Demo {
    public static void main(String[] args){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));


        BrowserContext context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        Page page  = context.newPage();
        page.navigate("https://www.google.com/");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Alles accepteren")).click();
        assertThat(page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Google"))).isVisible();
        
        System.out.println(page.title());
        System.out.println("Hello Playwright");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target//example.png")));

        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("target//trace.zip")));

        page.close();
    }
}
