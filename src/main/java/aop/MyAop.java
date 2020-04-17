package aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component//这个aop的类由spring来new出来
@Aspect //并且将这个类设置成警察，用来抓捕service方法
public class MyAop {

	
	
}
