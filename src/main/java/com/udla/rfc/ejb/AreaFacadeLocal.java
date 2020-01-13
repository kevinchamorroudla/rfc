package com.udla.rfc.ejb;

import com.udla.rfc.model.Area;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AreaFacadeLocal {

    void create(Area area);

    void edit(Area area);

    void remove(Area area);

    Area find(Object id);

    List<Area> findAll();

    List<Area> findRange(int[] range);

    int count();
    
}
