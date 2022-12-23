package secxndary_framework.model;
import org.apache.logging.log4j.LogManager;

import java.util.Objects;


public class GiftCard {

    private int maxTotalCostForGiftCards;
    private int singleGiftCardPrice;
    private int numberOfGiftCards;
    private int maxAmountOfGiftCards;


    public GiftCard() {
    }

    public GiftCard(int maxTotalCostForGiftCards, int singleGiftCardPrice, int numberOfGiftCards) {
        this.maxTotalCostForGiftCards = maxTotalCostForGiftCards;
        this.singleGiftCardPrice = singleGiftCardPrice;
        this.numberOfGiftCards = numberOfGiftCards;
        this.maxAmountOfGiftCards = maxTotalCostForGiftCards / singleGiftCardPrice;
        LogManager.getRootLogger().warn("Expected number of gift cards: " + this.maxTotalCostForGiftCards +
                " / " + this.singleGiftCardPrice + " = " + this.maxAmountOfGiftCards);
    }


    public int getMaxTotalCostForGiftCards() {
        return maxTotalCostForGiftCards;
    }

    public void setMaxTotalCostForGiftCards(int maxTotalCostForGiftCards) {
        this.maxTotalCostForGiftCards = maxTotalCostForGiftCards;
    }

    public int getSingleGiftCardPrice() {
        return singleGiftCardPrice;
    }

    public void setSingleGiftCardPrice(int singleGiftCardPrice) {
        this.singleGiftCardPrice = singleGiftCardPrice;
    }

    public int getNumberOfGiftCards() {
        return numberOfGiftCards;
    }

    public void setNumberOfGiftCards(int numberOfGiftCards) {
        this.numberOfGiftCards = numberOfGiftCards;
    }

    public int getMaxAmountOfGiftCards() {
        return maxAmountOfGiftCards;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftCard giftCard = (GiftCard) o;
        return maxTotalCostForGiftCards == giftCard.maxTotalCostForGiftCards && singleGiftCardPrice == giftCard.singleGiftCardPrice && numberOfGiftCards == giftCard.numberOfGiftCards;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxTotalCostForGiftCards, singleGiftCardPrice, numberOfGiftCards);
    }
}
