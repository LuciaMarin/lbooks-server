package net.ausiasmarch.dao.daointerface;

import java.util.ArrayList;
import net.ausiasmarch.bean.BeanInterface;

public interface DaoInterface {

    BeanInterface get(int id) throws Exception;

    Integer getCount(Integer id, String filter) throws Exception;

    ArrayList getPage(int page, int rpp, String orden, String direccion, String word, Integer id, String filter) throws Exception;

    Integer insert(BeanInterface oBean) throws Exception;

    Integer remove(int id) throws Exception;

    Integer update(BeanInterface oBean) throws Exception;

}
