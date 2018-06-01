package ru.job4j.tracker;

/**
 * ValidateInput.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class ValidateInput extends ConsoleInput {
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
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Plese select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Plese enter validate data again.");
            }
        } while (invalid);
        return  value;
    }
}
