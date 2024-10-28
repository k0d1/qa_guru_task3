import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Grigorii");
        $("#lastName").setValue("Plugin");
        $("#userEmail").setValue("grifa111@yandex.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9603123455");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--018").click();
        $("#subjectsInput").setValue("physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("qa_guru.png");
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $("#state").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#city").$(byText("Agra")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));

        $$(".table-responsive tbody tr").filterBy(text("Student Name")).first().shouldHave(text("Grigorii Plugin"));
        $$(".table-responsive tbody tr").filterBy(text("Student Email")).first().shouldHave(text("grifa111@yandex.ru"));
        $$(".table-responsive tbody tr").filterBy(text("Gender")).first().shouldHave(text("Male"));
        $$(".table-responsive tbody tr").filterBy(text("Mobile")).first().shouldHave(text("9603123455"));
        $$(".table-responsive tbody tr").filterBy(text("Date of Birth")).first().shouldHave(text("18 April,1995"));
        $$(".table-responsive tbody tr").filterBy(text("Subjects")).first().shouldHave(text("physics"));
        $$(".table-responsive tbody tr").filterBy(text("Hobbies")).first().shouldHave(text("Sports"));
        $$(".table-responsive tbody tr").filterBy(text("Picture")).first().shouldHave(text("qa_guru.png"));
        $$(".table-responsive tbody tr").filterBy(text("Address")).first().shouldHave(text("Russia"));
        $$(".table-responsive tbody tr").filterBy(text("State and City")).first().shouldHave(text("Uttar Pradesh Agra"));

    }


}