package vip.openpark.resources.bean;

import lombok.Getter;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author anthony
 * @version 2023/11/19 11:14
 */
@Getter
@Component
public class CustomResourceLoaderAware implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    /**
     *  spring 本身会将 ResourceLoader 注入进来
     * @param resourceLoader the ResourceLoader object to be used by this object
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}