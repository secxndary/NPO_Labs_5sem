package secxndary_framework.creator;
import secxndary_framework.model.Address;
import secxndary_framework.utils.TestDataReader;


public class AddressCreator {

    public static final String TESTDATA_ADDRESS_STREET = "testdata.address.street";
    public static final String TESTDATA_ADDRESS_HOUSE = "testdata.address.house";


    public static Address withStreetAndHouse() {
        return new Address(TestDataReader.getTestData(TESTDATA_ADDRESS_STREET), TestDataReader.getTestData(TESTDATA_ADDRESS_HOUSE));
    }

}
