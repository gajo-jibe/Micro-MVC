
package org.mmvc.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Method to be invoked when a model of interest has changed.
 * <p> A model of interest
 * 
 * @author jbg
 *  17 mars 2011
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ModelChanged
{

}
