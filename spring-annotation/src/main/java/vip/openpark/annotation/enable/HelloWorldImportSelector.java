package vip.openpark.annotation.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author anthony
 * @since 2024/1/2 23:47
 */
public class HelloWorldImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"vip.openpark.annotation.enable.HelloWorldConfiguration"};
	}
}