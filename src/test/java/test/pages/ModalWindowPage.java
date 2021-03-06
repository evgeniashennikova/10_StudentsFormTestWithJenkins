package test.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowPage {

    private final String NAME_MODAL_WINDOW = "Thanks for submitting the form";
    private SelenideElement
            modalContentSelector = $(".modal-content"),
            tableResultsSelector = $(".table-responsive");



    public ModalWindowPage checkHeader() {
        modalContentSelector.shouldHave(text(NAME_MODAL_WINDOW));
        return this;
    }

    public ModalWindowPage checkResultsValue(String key, String value) {

        tableResultsSelector.$(byText(key)).parent().
                shouldHave(text(value));
        return this;
    }
}
