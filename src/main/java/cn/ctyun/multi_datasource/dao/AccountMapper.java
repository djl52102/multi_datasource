package cn.ctyun.multi_datasource.dao;

import cn.ctyun.multi_datasource.datasource.TargetDataSource;
import cn.ctyun.multi_datasource.entity.Account;
import cn.ctyun.multi_datasource.entity.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import javax.annotation.sql.DataSourceDefinition;

public interface AccountMapper {
    @TargetDataSource(value = "test")
    int countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    @TargetDataSource(value = "test")
    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}