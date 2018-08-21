package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MenuDao {
    List<Menu> getAllMenu();

}
