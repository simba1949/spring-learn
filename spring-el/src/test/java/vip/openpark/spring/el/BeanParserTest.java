package vip.openpark.spring.el;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import vip.openpark.spring.el.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 16:19
 */
@Slf4j
public class BeanParserTest {
	@Test
	public void beanParserTest() {
		// 创建 beanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		applicationContext.register(SpringAnnotationConfig.class);
		// 刷新容器：启动应用上下文
		applicationContext.refresh();

		// SpEL 表达式的求值提供了一个上下文环境
		StandardEvaluationContext context = new StandardEvaluationContext();
		BeanFactoryResolver beanFactoryResolver = new BeanFactoryResolver(applicationContext);
		context.setBeanResolver(beanFactoryResolver);

		ExpressionParser parser = new SpelExpressionParser();

		// 访问某个bean，使用 @ 开头，如果 bean 名称存在特殊字符，使用单引号包裹
		Expression exp0 = parser.parseExpression("@systemPropertiesComponent");
		log.info("@systemPropertiesComponent: {}", exp0.getValue(context));
		Expression exp1 = parser.parseExpression("@systemPropertiesComponent.username");
		log.info("\"@systemPropertiesComponent.username: {}", exp1.getValue(context));

		// 访问某个 FactoryBean，使用 & 开头
		Expression exp2 = parser.parseExpression("&myFactoryBean");
		log.info("&myFactoryBean: {}", exp2.getValue(context));
		Expression exp3 = parser.parseExpression("&myFactoryBean.getObject");
		log.info("&myFactoryBean.getObject: {}", exp3.getValue(context));
	}
}