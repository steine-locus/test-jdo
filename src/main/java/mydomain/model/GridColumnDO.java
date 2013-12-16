package mydomain.model;

public final class GridColumnDO {

    private int id;
    private Integer displayOrder;
    private String displayName;
    private String fieldName;
    private String valueType;

    public GridColumnDO() {
        super();
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(final Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(final String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValueType() {
        return this.valueType;
    }

    public void setValueType(final String valueType) {
        this.valueType = valueType;
    }
}
