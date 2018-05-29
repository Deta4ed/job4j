package ru.job4j.tracker;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
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
        StartUITest startUITest = new StartUITest();
        assertThat(new String(out.toByteArray()),
            is(
                startUITest.menu(
                    startUITest.request(
                        startUITest.menu(new StringJoiner(System.lineSeparator())
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
        StartUITest startUITest = new StartUITest();
        assertThat(new String(out.toByteArray()),
            is(
                startUITest.menu(
                    startUITest.request(
                        startUITest.menu(new StringJoiner(System.lineSeparator())
                        )
                    )
                ).toString()
            )
        );
    }

    private StringJoiner menu(StringJoiner str) {
        str.add("Menu:");
        str.add("0. Add new Item");
        str.add("1. Show all items");
        str.add("2. Edit item");
        str.add("3. Delete item");
        str.add("4. Find item by Id");
        str.add("5. Find items by name");
        str.add("6. Exit Program");
        str.add("");
        return str;
    }

    private StringJoiner request(StringJoiner str) {
        str.add("------------ Request ID : 1526211524702 --------------");
        str.add("Create :      2018/05/27 10:18:04");
        str.add("Name :        test1");
        str.add("Description : testDescription");
        str.add("------------------------------------------------------");
        return str;
    }
}
