package org.datanucleus.test;

import org.junit.*;
import javax.jdo.*;

import static org.junit.Assert.*;
import mydomain.model.*;
import org.datanucleus.util.NucleusLogger;

import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

public class SimpleTest
{
    @Test
    public void testSimple()
    {
        NucleusLogger.GENERAL.info(">> test START");
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("MyTest");

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
            this.addGrid(pm);
            this.readGridColumns(pm);
            tx.commit();
        }
        catch (Throwable thr)
        {
            NucleusLogger.GENERAL.error(">> Exception thrown persisting data", thr);
            fail("Failed to persist data : " + thr.getMessage());
        }
        finally 
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        pmf.close();
        NucleusLogger.GENERAL.info(">> test END");
    }
    
    private void addGrid(
            final PersistenceManager pm) {
            
        final Set<GridColumnDO> columns = new HashSet<GridColumnDO>();
        columns.add(buildGridColumn(1));
        columns.add(buildGridColumn(2));
        
        final GridDO grid = new GridDO();
        grid.setId(1);
        grid.setName("Test Grid");
        /* Uncomment this line to try (and fail) to persist some
         * columns for the grid:
         * grid.setColumns(columns);
         */
        pm.makePersistent(grid);
    }
    
    private GridColumnDO buildGridColumn(final int id) {
        final GridColumnDO gridColumn = new GridColumnDO();
        gridColumn.setId(id);
        gridColumn.setDisplayOrder(Integer.valueOf(id));
        gridColumn.setDisplayName("Test Column " + id);
        gridColumn.setFieldName("Test Field " + id);
        gridColumn.setValueType("String");
        return gridColumn;
    }
    
    private void readGridColumns(
            final PersistenceManager pm) {
            
        final Query query = pm.newNamedQuery(GridDO.class, "FindByName");
        final Collection<GridDO> results = (Collection<GridDO>) query.execute("Test Grid");
        for (final GridDO result : results) {
            NucleusLogger.GENERAL.debug("RESULT: " + result.toString());
            NucleusLogger.GENERAL.debug("COLUMNS: " + result.getColumns());
        }
    }
    

}
