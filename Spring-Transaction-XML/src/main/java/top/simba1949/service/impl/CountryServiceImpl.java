package top.simba1949.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.simba1949.common.CountryCommon;
import top.simba1949.mapper.CountryMapper;
import top.simba1949.service.CountryService;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/24 23:22
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public int insert(CountryCommon countryCommon) {
        int i = countryMapper.insert(countryCommon);
        return i;
    }

    @Override
    public int insertRollBack(CountryCommon countryCommon) {
        int i = countryMapper.insert(countryCommon);
        int j = i / 0 ;
        return j;
    }

}
