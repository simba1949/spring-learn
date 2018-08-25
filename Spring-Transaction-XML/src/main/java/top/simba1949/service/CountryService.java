package top.simba1949.service;

import top.simba1949.common.CountryCommon;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/24 23:22
 */
public interface CountryService {

    /**
     * 增
     * @param countryCommon
     * @return
     */
    int insert(CountryCommon countryCommon);

    /**
     * 增，回滚
     * @param countryCommon
     * @return
     */
    int insertRollBack(CountryCommon countryCommon);
}
