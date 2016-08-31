package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import seedu.addressbook.data.person.address.Block;
import seedu.addressbook.data.person.address.PostalCode;
import seedu.addressbook.data.person.address.Street;
import seedu.addressbook.data.person.address.Unit;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Hougang, #12-12, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in "
    		+ "the format of BLOCK, STREET, UNIT, POSTAL CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = address;
        
        String[] splitAddress = address.split(",");
        
        block = new Block(splitAddress[0]);
        this.street = new Street(splitAddress[1]);
        this.unit = new Unit(splitAddress[2]);
        this.postalCode = new PostalCode(splitAddress[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return "" + block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getAddress().equals(((Address) other).getAddress())); // state check
    }

    @Override
    public int hashCode() {
        return getAddress().hashCode();
    }
    public String getAddress() {
    	return this.toString();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}