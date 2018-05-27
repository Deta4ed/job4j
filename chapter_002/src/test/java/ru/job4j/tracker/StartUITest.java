package ru.job4j.tracker;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * StartUITest.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class StartUITest {
    private static final String LN = System.lineSeparator();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Tracker tracker;

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @Before
    public void creatTracker() {
        this.tracker = new Tracker();
        Item item = this.tracker.add(new Item("test1", "testDescription", 1527405484168L));
        item.setId("1526211524702");
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.getAll()[1].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[]{"2", "1526211524702", "test name", "desc", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.findById("1526211524702").getName(), is("test name"));
    }

    @Test
    public void whenDeleteThenTrackerHasItemWithSameName() {
        Item item1 = this.tracker.add(new Item("test name", "testDescription", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", "1526211524702", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(this.tracker.getAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenShowAllThenOut() {
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                    StartUITest.menu(
                        StartUITest.request(
                            StartUITest.menu(new StringBuilder()
                            )
                        )
                    ).toString()
                )
        );
    }

    @Test
    public void whenFindIdThenOut() {
        Input input = new StubInput(new String[]{"4", "1526211524702", "6"});
        new StartUI(input, this.tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        StartUITest.menu(
                                StartUITest.request(
                                        StartUITest.menu(new StringBuilder()
                                        )
                                )
                        ).toString()
                )
        );
    }

    private static StringBuilder menu(StringBuilder str) {
        str.append("Menu:").append(LN);
        str.append("0. Add new Item").append(LN);
        str.append("1. Show all items").append(LN);
        str.append("2. Edit item").append(LN);
        str.append("3. Delete item").append(LN);
        str.append("4. Find item by Id").append(LN);
        str.append("5. Find items by name").append(LN);
        str.append("6. Exit Program").append(LN);
        return str;
    }

    private static StringBuilder request(StringBuilder str) {
        str.append(LN);
        str.append("------------ Request ID : 1526211524702 --------------").append(LN);
        str.append("Create :      2018/05/27 10:18:04").append(LN);
        str.append("Name :        test1").append(LN);
        str.append("Description : testDescription").append(LN);
        str.append("------------------------------------------------------").append(LN);
        return str;
    }
}
