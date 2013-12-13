package mydomain.model;

import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public final class GridDO {

    private int id;
    private String name;
    private Set<GridColumnDO> columns;

    public GridDO() {
        super();
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setColumns(final Set<GridColumnDO> columns) {
        this.columns = columns;
    }

    public Set<GridColumnDO> getColumns() {
        return this.columns;
    }
}
