package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * 
 * Represents a Address's block number in the address book
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class Block {
	
	public static final String EXAMPLE = "123";
	public static final String MESSAGE_BLOCK_CONSTRAINTS = "Address block number should only contain numbers";
	public static final String BLOCK_VALIDATION_REGEX = "\\d+";
	
	private final String blockNumber;
	private boolean isPrivate;
	
	/**
	 * Validates given block number
	 * 
	 * @throws IllegalValueException if given block string is invalid.
	 */
	public Block(String blockNumber, boolean isPrivate) throws IllegalValueException {
		this.isPrivate = isPrivate;
		if(!isValidBlock(blockNumber)){
			throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
		}
		this.blockNumber = blockNumber.trim();
	}

    /**
     * Checks if a given string is a valid address block number.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.blockNumber;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.blockNumber.equals(((Block) other).blockNumber)); // state check
    }

    @Override
    public int hashCode() {
        return this.blockNumber.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
