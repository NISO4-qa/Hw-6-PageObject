package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class MoneyTransfer {
    private final SelenideElement sumField = $("[data-test-id=amount] .input__control");
    private final SelenideElement fromField = $("[data-test-id=from] .input__control");
    private final SelenideElement button = $("[data-test-id=action-transfer]");

    private final SelenideElement errorMassage = $("[data-test-id = error-notification] .notification__content");

    public Dashboard toTransMoney(String sum, DataHelper.CardInfo cardInfo) {
        makeTransfer(sum, cardInfo);
        return new Dashboard();
    }

    public void makeTransfer(String sum, DataHelper.CardInfo cardInfo) {
        sumField.setValue(sum);
        fromField.setValue(cardInfo.getCardNumber());
        button.click();
    }

    public void findErrorMassage(String expectedText) {
        errorMassage.shouldHave(text(expectedText));
    }
}
