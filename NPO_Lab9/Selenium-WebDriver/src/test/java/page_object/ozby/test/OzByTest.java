package page_object.ozby.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.ozby.page.*;

public class OzByTest {

    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        driver = null;
    }


    @Test
    public void LeaveComment_ShouldReturnError_WhenTheCommentTextLength_IsMoreThan300Symbols() {
        String login = "valdaitsevv@mail.ru";
        String password = "4cLMSR";
        String commentText = "qweqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqweqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqweqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqweqweqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqweqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqweqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqweqweqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqweqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqweqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqwe";

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(login, password)
                .openFirstGoodPage();

        Boolean checkIfCommentIsSent = new OzByGoodsPage(driver)
                .waitForGoodsPageToLoad()
                .clickOnLeaveCommentButton()
                .enterComment(commentText)
                .sendComment()
                .checkIfCommentIsSent(commentText);

        Assert.assertFalse(checkIfCommentIsSent);
    }


    @Test
    public void EnterNumberOfGoods_ShouldReturnError_WhenNumberOfGoods_IsMoreThan99() {
        String login = "valdaitsevv@mail.ru";
        String password = "4cLMSR";
        int numberOfGoods = 358;

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(login, password)
                .openFirstGoodPage();

        new OzByGoodsPage(driver)
                .waitForGoodsPageToLoad()
                .openCartPage();

        Boolean checkIfNumberOfGoodsIsSent = new OzByCartPage(driver)
                .waitForCartPageToLoad()
                .enterNumberOfGoods(numberOfGoods)
                .checkIfNumberOfGoodsIsSent(numberOfGoods);

        Assert.assertFalse(checkIfNumberOfGoodsIsSent);
    }


    @Test
    public void OrderCall_ShouldReturnError_WhenUserName_IsLongerThan100Symbols() {
        String login = "valdaitsevv@mail.ru";
        String password = "4cLMSR";
        String userName = "емеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеляемеля";

        Boolean checkIfOrderCallSucceed = new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(login, password)
                .clickOrderCallLink()
                .enterOrderCallUserName(userName)
                .clickOrderCallButton();

        Assert.assertFalse(checkIfOrderCallSucceed);
    }


    @Test
    public void TextFeedbackForm_ShouldReturnError_WhenMessage_IsLongerThan100Symbols() throws InterruptedException {
        String login = "valdaitsevv@mail.ru";
        String password = "4cLMSR";
        String feedbackMessage = "Приходит к маленькому сыну отец и говорит: «Завтра ты первый раз пойдешь в детский садик и если ты весь год отучишься там хорошо, то в конце года я куплю тебе всё, что ты захочешь!». И сын такой: «Говно вопрос!».\n" +
                "Целый год сын ходил в детский садик, всё хорошо там сдавал, рисовал картинки. В конце года он приходит к отцу и говорит: «Отец, я всё хорошо сдал», и отец ему отвечает: «Молодец! Что же мне тебе подарить?», а сын такой: « Парту, отец! Купи мне парту!», и отец удивлённо спрашивает: «Точно парту??? Я могу купить тебе маши игрушечную или конструктор Лего..», но сын недослушав ответил: «Нет! Мне нужна парта». На что отец сказал: «Ладно, говно вопрос, куплю тебе парту».\n" +
                "На следующих год отец говорит сыну: «Ты снова идешь в детский сад, давай такую же тему, как и в том году: закончишь хорошо – проси, что хочешь». Сын опять: «Говно вопрос, Бать!».\n" +
                "Хуяк-хуяк-хуяк. Год закончился. Детский сад закончен на отлично. Сын приходит к отцу и показывает, что всё заебись. Отец же восхитился и снова подарил сыну парту, потому что он снова ее попросил.\n" +
                "На следующий год идёт сын в школу. 1 класс. 1-ого сентября отец сыну говорит: «Школа – это ответственность! Закончишь год на одни пятёрки – я подарю тебе всё, что ты захочешь». Сын такой «Я вас понял!».\n" +
                "Идёт, хуярит весь год только так! Одни пятёрки! Заканчивает 1 класс, приходит к отцу, говорит: «Бать, я закончил, дари парту», на что отец: «Ты уверен, что парту?? У тебя их блять и так две, нахуя тебе третья?», сын в ответ: «Блять, Бать, дари парту!». Отец соглашается и покупает парту.\n" +
                "Идёт сын во второй класс. Батя к нему подходит и говорит: «Та же схема, сын. На одни пятёрки год – дарю всё, что захочешь». На что сын: «Я вас услышал!».\n" +
                "Итак, весь год на одни пятёрки. Заканчивает 2-ой класс, приходит к отцу и говорит: «Всё! Вот! Одни пятёрки. Хочу еще одну парту, Бать», на что отец: «Бляяяять, ну ты заебал. Ну ладно» и дарит еще одну ёбаную парту.\n" +
                "Пошел сын в 3 класс и отец ему говорит: «Весь год будешь хорошо учиться – в конце года подарю всё, что ты захочешь».\n" +
                "Сын хорошо учился весь год и в конце года он приходит к отцу и говорит: «Подари мне, пожалуйста, парту». Батя дарит парту.\n" +
                "А сын идет в 4-ый класс. И вот 4-ый класс сын учится на отлично. В конце года батя ему говорит: «Красава! Чё тебе подарить?». Сын отвечает: «Блять, парту, Батя!», Отец в ответ: «Тебе эти парт уже девать некуда!». Но батя блять – человек СЛОВО. Он пошёл и купил сыну еще одну парту.\n" +
                "В 5-ый класс идёт сын. Весь 5-ый класс сын пиздец задрачивается. Тупо всё на пятёрки блять. В конце года приходит к бати и говорит: «Батя, одни пятёрки! Давай! Ещё одну парту!», отец такой: «Да мне похуй уже. Давай парту!».\n" +
                "В 6-ой класс пошел сын. Опять на изичах одни пятёрки. Всё вывез. Подходит к отцу и говорит: «Блять, одни пятёрки. Всё. Давай парту». Отец покупает.\n" +
                "В 7-ой класс пошел пацан. Весь год учился на пятёрки, вообще ни одной четвёрки. Приходит к отцу, говорит: «Дари парту». Отец подарил и говорит: «Давай 8-ой класс так же заканчиваешь – подарю всё, что захочешь». На что сын: «Пфф. Аля-олю!»\n" +
                "Пошел в 8 класс. Целый год на одни пятёрки, Подходит в конце года к отцу: «Бать, всё отлично. Подари еще одну парту». Ну отец и дарит парту.\n" +
                "9-ый класс. Отец говорит сыну: «Так, хорошо. Сдашь эти экзамены ебаные – я тебя устрою в лучший университет страны!». Сын такой: «Бать! Забей! Работаем!»\n" +
                "Сын сдаёт эти экзамены – ОГЭ/ГИА. И просит у отца парту. Отец говорит: «Ну ты ебанутый или где? Давай уже что-нибудь другое», а сын в ответ: «Нет, я хочу парту» и ему дарят эту парту.\n" +
                "После чего отец говорит: «Всё, сын! 10-ый класс! Ты идешь в 10-ый класс, блять. Весь год на пятёрки – подарю, что хочешь». Сын такой: «Забились!».\n" +
                "Всё. Закрыл 10-ый класс на одни пятёрки, приходит к отцу и говорит: «Блять, парту, Бать! Мне нужно, чтоб ты подарил парту». Батя дарит парту.\n" +
                "11-ый класс. Всё. Отец говорит: «Блять! Сейчас закрываешь весь год, сдаешь ЕГЭ, и если ты сам поступишь в самый пиздатый универ , то я тебе подарю нахуй машину! Я тебе подарю дом нахуй! Что захочешь вообще подарю!». Сын такой: «Я тебя услышал!».\n" +
                "Заканчивает, поступает в лучший университет в стране. Приносит бате корочку и говорит: «Во! Годы не зря!», отец в ответ: «Блять! Красава! Чё тебе? Давай! Тачку купим?», сын: «Нет, мне нужна парта», отец: «Не, ну ты что, ебанутый? Нахуя тебе парта??», сын: «Отец! Не задавай вопросы блять! Я сын-отличник. Отъебись, всё», отец: «Понял. Отъебался» и подарил парню парту.\n" +
                "Сын поступает в университет на 1 курс. Батя ему говорит: «Закроешь без долгов, без всей хуйни, всё автоматом – будет, что хочешь! Тачки, срачки, что хочешь», сын: «Говно вопрос».\n" +
                "Закрывает весь год просто на автоматах, показывает бате, батя ему говорит: «Что же будем покупать?», сын: «Парту, Бать», отец: «Опять парту?», сын: «Да, опять парту», отец: «Ну и хуй с тобой, золотая рыбка» - сказал батя и подарил этому ебаному еще одну парту.\n" +
                "2-ой курс. Пацан опять всё закрывает на одни пятёрки автоматом. Преподы в восторге. Приходит к отцу и говорит: «Подари мне еще одну парту». Батя ,блять, дарит.\n" +
                "3-ий курс. Сын всё закрывает на пятёрки. Опять все в восторге. Батя дарит очередную парту. 4-ый курс. Батя подходит и говорит: «Закроешь универ, устроишься на ахуенную работу, я подарю тебе всё своё нахуй состояние» (а человек он был богатый), сын такой: «Я тебя услышал! Окей!»\n" +
                "Закрывает всё. Сдаёт идеально. Устраивается на самую оплачиваемую работу. Приходит к бате и говорит: «Батя, можно мне, пожалуйста, парту», батя: «Ты уверен блять?? Ты сука уверен? Я могу подарить лучшую машину!», сын: «Парту! Подари парту». Отец покупает парту.\n" +
                "Сын устраивается на работу. Отец ему говорит: «Найди себе жену, сын. Найди себе самую лучшую жену и я подарю вам на помолвку всё, что захочешь: романтическое путешествие, дом на Гавайях – всё, что захочешь».\n" +
                "Сын находит самую лучшую девушку, из приличной семьи. Знакомит ее с отцом, потом помолвка и отец говорит: «Что же вам подарить, молодые?», сын говорит: «Парту». Отец скрипя сердцем покупает еще одну ебучую блять парту.\n" +
                "Проходят годы. У отца юбилей. Ему исполняется 60 лет. Собирается вся семья. И он такой радостный, потому что наконец-то к нему приедет его сын, его гордость. Всю жизнь он вложил в этого сына. Он приедет со своей женой молодой. Отец так счастлив. И слышит, как подъезжает к дому машина и выбегает. Выбегает и видит, как паркуется красивая машина и из неё выходит его красавец сын со своей красавицей женой. Сын видит отца и бежит к нему и тут ХУЯК! Сына сбивает КамАЗ! Отец подбегает к окровавленному телу, берет его, трясёт, говорит: «Блять, сын! Живи!», сын отвечает: «Отец, похоже это всё. Похоже я умираю», отец видит смерть в его глазах и говорит: «Ну, давай напоследок хотя бы скажи мне, почему все эти годы ты просил у меня парту?», и сын, смотря ему в глаза, говорит: «Отец…потому что..» и умирает нахуй.";

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(login, password)
                .openTextFeedbackPage();

        OzByFeedbackPage ozByFeedbackPage = new OzByFeedbackPage(driver)
                .waitForFeedbackPageToLoad()
                .sendFeedbackMessage(feedbackMessage);
        Thread.sleep(5000);
        Boolean checkIfFeedbackMessageIsSent = ozByFeedbackPage.checkIfFeedbackMessageIsSent();

        Assert.assertFalse(checkIfFeedbackMessageIsSent);
    }


    @Test
    public void SearchPage_ShouldShowSearchResults() {
        String searchText = "гуль";

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .enterSearchText(searchText);

        Boolean checkIfSearchPageReturnsSearchResult =
                new OzBySearchResultsPage(driver)
                .checkIfSearchPageReturnsSearchResult();

        Assert.assertTrue(checkIfSearchPageReturnsSearchResult);
    }


    @Test
    public void SearchFilter_ShouldShowFilterResults() {
        String searchText = "гуль";

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .enterSearchText(searchText);

        Boolean checkIfSearchFilterIsCorrect =
                new OzBySearchResultsPage(driver)
                        .checkIfSearchFilterIsCorrect();

        Assert.assertTrue(checkIfSearchFilterIsCorrect);
    }


    @Test
    public void CourierDelivery_ShouldShowAddressInput() {
        String login = "valdaitsevv@mail.ru";
        String password = "4cLMSR";

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(login, password)
                .openCartPage();

        Boolean checkIfCourierDeliveryOptionShowsAddressInput = new OzByCartPage(driver)
                .waitForCartPageToLoad()
                .chooseCourierDeliveryOption()
                .checkIfCourierDeliveryOptionShowsAddressInput();

        Assert.assertTrue(checkIfCourierDeliveryOptionShowsAddressInput);
    }


    @Test
    public void AddersAdding_ShouldReturnError_WhenAddressIsNonExistent() {
        String login = "valdaitsevv@mail.ru";
        String password = "4cLMSR";
        String street = "димитриади антон";
        String house = "лох 123";

        new OzByHomePage(driver)
                .waitForHomePageToLoad()
                .openPage()
                .loginIntoAccount(login, password)
                .openCartPage();

        Boolean checkIfAddressHasBeenAdded = new OzByCartPage(driver)
                .waitForCartPageToLoad()
                .chooseCourierDeliveryOption()
                .addDeliveryAddress(street, house)
                .checkIfAddressHasBeenAdded();

        Assert.assertFalse(checkIfAddressHasBeenAdded);
    }
}
