package ru.job4j.tracker;

/**
 * ValidateInput.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     *
     * @param question - question.
     * @return - result of the ask method of the incoming parameter.
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     *
     * @param question - question.
     * @param range -array of valid menu keys.
     * @return - menu key or -1.
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return  value;
    }
}
