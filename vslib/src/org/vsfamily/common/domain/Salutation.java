package org.vsfamily.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Salutation class for implementing salutation codes.
 * 
 * The sub-fields used in the database are:
 * <ul>
 * <li> id - system generated identifier [ long, not-null, primary key ] and
 * <li> code - salutation code [ string , size(10), not-null, unique ].
 * </ul> 
 *
 */
@SuppressWarnings("serial")
public class Salutation extends VslibBaseClass {

}
