package ru.job4j.tracker;

/**
 * Tracker.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private Long create;
    private String[] comments;

    public Item(String name, String description, Long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * getName.
     * @return - name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getCreate.
     * @return - create.
     */
    public Long getCreate() {
        return this.create;
    }

    /**
     * getDescription.
     * @return - description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * getComments
     * @return - array comments.
     */
    public String[] getComments() {
        return comments;
    }
    /**
     * getId.
     * @return - id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * setId
     * @param id - id.
     */
    public void setId(String id) {
        this.id = id;
    }


}
