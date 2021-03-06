package laxa.multithreading.framework.characteristics;

import laxa.multithreading.framework.Strategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: Chekulaev Alexey
 * Date: 09.03.12
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface BestStrategy {
	Class<? extends Strategy>[] value();
}