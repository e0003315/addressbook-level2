package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * 
 * Represents a Address's block number in the address book
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class Block {

	public static final String EXAMPLE = "123";
	public static final String MESSAGE_BLOCK_CONSTRAINTS = "Address's block number should only contain numbers";
	public static final String BLOCK_VALIDATION_REGEX = "\\d+";

	private final String value;

	/**
	 * Validates given block number
	 * 
	 * @throws IllegalValueException if given block string is invalid.
	 */
	public Block(String blockNumber) throws IllegalValueException {
		if(!isValidBlock(blockNumber)){
			throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
		}
		value = blockNumber.trim();
	}

	/**
	 * Checks if a given string is a valid address block number.
	 */
	public static boolean isValidBlock(String test) {
		return test.matches(BLOCK_VALIDATION_REGEX);
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Block // instanceof handles nulls
						&& value.equals(((Block) other).value)); // state check
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
	public String getBlock() {
		return value;
	}
	
}