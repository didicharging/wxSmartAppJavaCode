package com.didi.mapper;

import com.didi.model.EWallet;
import com.didi.model.EWalletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EWalletMapper {
    int countByExample(EWalletExample example);

    int deleteByExample(EWalletExample example);

    int deleteByPrimaryKey(String id);

    int insert(EWallet record);

    int insertSelective(EWallet record);

    List<EWallet> selectByExample(EWalletExample example);

    EWallet selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EWallet record, @Param("example") EWalletExample example);

    int updateByExample(@Param("record") EWallet record, @Param("example") EWalletExample example);

    int updateByPrimaryKeySelective(EWallet record);

    int updateByPrimaryKey(EWallet record);
    
    EWallet selectByUserId(String userId);
    
	int addAmount(EWallet wallet);

	int subAmount(EWallet wallet);
    
}