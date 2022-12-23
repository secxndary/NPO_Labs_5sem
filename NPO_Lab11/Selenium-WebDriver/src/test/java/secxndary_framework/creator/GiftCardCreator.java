package secxndary_framework.creator;
import secxndary_framework.model.GiftCard;
import secxndary_framework.utils.TestDataReader;


public class GiftCardCreator {

    public static final String TESTDATA_MAX_TOTAL_COST = "testdata.giftcard.maxtotalcost";
    public static final String TESTDATA_SINGLE_GIFT_CARD_PRICE = "testdata.giftcard.singleprice";
    public static final String TESTDATA_NUMBER_OF_GIFT_CARDS = "testdata.giftcard.numberofcards";


    public static GiftCard getGiftCardWithAllData() {
        return new GiftCard(
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_MAX_TOTAL_COST)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_SINGLE_GIFT_CARD_PRICE)),
                Integer.parseInt(TestDataReader.getTestData(TESTDATA_NUMBER_OF_GIFT_CARDS)));
    }
}
