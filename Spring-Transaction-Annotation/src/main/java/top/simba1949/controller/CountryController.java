package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.common.CountryCommon;
import top.simba1949.service.CountryService;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/24 23:17
 */
@RestController
@RequestMapping("country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("insert")
    public String insert(CountryCommon countryCommon){
        int i = countryService.insert(countryCommon);
        return i + "";
    }

    @PostMapping("insertrollback")
    public String insertRollBack(CountryCommon countryCommon){
        int i = countryService.insertRollBack(countryCommon);
        return i + "";
    }
}
