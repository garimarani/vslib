package org.vsfamily.vslib.common;

import java.util.List;

public interface VslibBaseDAO {
	
	public boolean			delete(Object obj);
	public boolean			save(Object obj);
	public boolean			saveOrUpdate(Object obj);
	public boolean			update(Object obj);
	
	public Object 			getObjectByArg(Class<?> clazz, String arg, Object value);
	public Object 			getObjectByArgTwo(Class<?> clazz, String arg, Object value, String argTwo, Object valueTwo);
	public Object			getObjectByCode(Class<?> clazz, String code);
	public Object			getObjectById(Class<?> clazz, Long id);

	public List<?>			listObject(Class<?> className);
	public List<?>			listObjectArg(Class<?> className, String arg, Object value);
	public List<?>			listObjectArg(Class<?> className, String arg, Object value, int firstResult, int maxResults);
	public List<?>			listObjectSorted(Class<?> className, String sortBy, String sortOrder);
	public List<?>			listObjectSortedTwo(Class<?> className, String sortByOne, String sortOrderOne, String sortByTwo, String sortOrderTwo);
	public List<?> 			listObjectSorted(Class<?> className, String sortBy, String sortOrder, int firstResult, int maxResults);
	public List<?>			listObjectArgSorted(Class<?> className, String arg, Object value, String sortBy, String sortOrder);
	public List<?>			listObjectArgSorted(Class<?> className, String arg, Object value, String sortBy, String sortOrder, int firstResult, int maxResults);
	public List<?>			listObjectArgSortedTwo(Class<?> className, String arg, Object value, String sortBy, String sortOrder, String sortByTwo, String sortOrderTwo);
}
