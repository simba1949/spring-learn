package vip.openpark.bean.ioc.annotation.config;

import org.springframework.context.annotation.Import;
import vip.openpark.bean.ioc.annotation.bean.UserWithImport;

/**
 * @author anthony
 * @version 2023/12/29 13:59
 */
@Import(UserWithImport.class)
public class UserWithImportConfig {
}