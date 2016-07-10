package org.vsfamily.vslib.common;

import java.util.List;

/**
 * Base DAO class, used for accessing data from the database. All the DAO classes of the
 * VSLib software are an extension of this class. 
 * 
 */
public interface VslibBaseDAO {
	
	/**
	 * Delete the object from the database.
	 * @param obj - the object to be deleted.
	 * @return true if the object is deleted successfully, false otherwise.
	 */
	public boolean			delete(Object obj);
	
	/**
	 * Save the object into the database.
	 * @param obj - the object to be saved.
	 * @return true if the object is saved successfully, false otherwise.
	 */
	public boolean			save(Object obj);
	
	/**
	 * Save or update the object into the database.
	 * @param obj - the object to be saved or updated.
	 * @return true if the object is saved or updated successfully, false otherwise.
	 */
	public boolean			saveOrUpdate(Object obj);
	
	/**
	 * Update the object into the database.
	 * @param obj - the object to be updated.
	 * @return true if the object is saved or updated successfully, false otherwise.
	 */
	public boolean			update(Object obj);
	
	/**
	 * Retrieve object from the database based on it's one property.
	 * @param clazz - the class of the object to be retrieved.
	 * @param arg - the property to be used for retrieval. 
	 * @param value - the value of the property.
	 * @return the object if it exists in the database, null otherwise
	 */
	public Object 			getObjectByArg(Class<?> clazz, String arg, Object value);
	
	/**
	 * Retrieve object from the database based on it's two properties
	 * @param clazz - the class of the object to be retrieved
	 * @param arg - the first property to be used for retrieval
	 * @param value - the value of the first property
	 * @param argTwo - the second property to be used for retrieval
	 * @param valueTwo - the value of the second property
	 * @return the object if it exists in the database, null otherwise
	 */
	public Object 			getObjectByArgTwo(Class<?> clazz, String arg, Object value, String argTwo, Object valueTwo);
	
	/**
	 * Retrieve object from the database based on it's property 'code'
	 * @param clazz - the class of the object to be retrieved
	 * @param code - the value of the property 'code'
	 * @return the object if it exists in the database, null otherwise
	 */
	public Object			getObjectByCode(Class<?> clazz, String code);

	/**
	 * Retrieve object from the database based on it's property 'id'
	 * @param clazz - the class of the object to be retrieved
	 * @param id - the value of the property 'id'
	 * @return the object if it exists in the database, null otherwise
	 */
	public Object			getObjectById(Class<?> clazz, Long id);

	/**
	 * Retrieve the list of all objects from the database.
	 * @param className - the class of the object for which list is to be retrieved 
	 * @return the list of the objects or an empty list (if there are no objects in the repository)
	 */
	public List<?>			listObject(Class<?> className);
	
	/**
	 * Retrieve the list of objects from the database based on it's one property.
	 * @param className - the class of the object for which list is to be retrieved
	 * @param arg - the name of the property
	 * @param value - the value of the property
	 * @return the list of the objects or an empty list (if there are no matching objects in the repository)
	 */
	public List<?>			listObjectArg(Class<?> className, String arg, Object value);
	
	/**
	 * Retrieve the sorted list of all objects from the database. 
	 * @param className - the class of the object for which the list is to be retrieved
	 * @param sortBy - the property name to be used for sorting
	 * @param sortOrder - the sort order (asc - ascending / desc - descending)
	 * @return the list of the objects or an empty list (if there are no objects in the repository)
	 */
	public List<?>			listObjectSorted(Class<?> className, String sortBy, String sortOrder);
	
	/**
	 * Retrieve the sorted list of all objects from the database, sorting based on it's two properties.
	 * @param className - the class of the object for which the list is to be retrieved
	 * @param sortByOne - the name of the first property used for sorting
	 * @param sortOrderOne - the sort order for the first property
	 * @param sortByTwo - the name of the second property used for sorting
	 * @param sortOrderTwo - the sort order for the second property
	 * @return the list of objects or an empty list (if there are no objects in the repository)
	 */
	public List<?>			listObjectSortedTwo(Class<?> className, String sortByOne, String sortOrderOne, String sortByTwo, String sortOrderTwo);
	
	/**
	 * Retrieve the sorted limited list of objects from the database, sorting done based on its one property.
	 * @param className - the class of the object for which the list is to be prepared
	 * @param sortBy - the name of the property used for sorting
	 * @param sortOrder - the sort order for the property
	 * @param firstResult - the number of record in the result-set, from which the objects are to retrieved
	 * @param maxResults - the number of objects starting from firstResult from the result-set
	 * @return the list of objects or an empty list (if there are no matching objects in the repository)
	 */
	public List<?> 			listObjectSorted(Class<?> className, String sortBy, String sortOrder, int firstResult, int maxResults);
	
	/**
	 * Retrieve the sorted list of objects from the database based on one of its property.
	 * @param className - the class of the object for which the list is to be prepared
	 * @param arg - the name of the property used for selection of objects
	 * @param value - the value of the property based on which selection is made
	 * @param sortBy - the name of the property used for sorting
	 * @param sortOrder - the sort order for the property
	 * @return the list of objects or an empty list (if there are no matching objects in the repository)
	 */
	public List<?>			listObjectArgSorted(Class<?> className, String arg, Object value, String sortBy, String sortOrder);
	
	/**
	 * Retrieve the sorted and limited list of objects from the database.
	 * @param className - the class name of the object for which the list is to be prepared
	 * @param arg - the name of the property used for selection of objects
	 * @param value - the value of the property based on which selection is made
	 * @param sortBy - the name of the property used for sorting
	 * @param sortOrder - the sort order for the property
	 * @param firstResult - the number of record in the result-set, from which the objects are to retrieved
	 * @param maxResults - the number of objects starting from firstResult from the result-set
	 * @return the list of objects or an empty list (if there are no matching objects in the repository)
	 */
	public List<?>			listObjectArgSorted(Class<?> className, String arg, Object value, String sortBy, String sortOrder, int firstResult, int maxResults);
	
	/**
	 * Retrieve the sorted and limited list of objects from the database.
	 * @param className - the class name of the object for which the list is to be prepared
	 * @param arg - the name of the property used for selection of objects
	 * @param value - the value of the property based on which selection is made
	 * @param sortBy - the name of the first property used for sorting
	 * @param sortOrder - the sort order for the first property
	 * @param sortByTwo - the name of the second property used for sorting
	 * @param sortOrderTwo - the sort order for the second property
	 * @return the list of objects or an empty list (if there are no matching objects in the repository)
	 */
	public List<?>			listObjectArgSortedTwo(Class<?> className, String arg, Object value, String sortBy, String sortOrder, String sortByTwo, String sortOrderTwo);
}
