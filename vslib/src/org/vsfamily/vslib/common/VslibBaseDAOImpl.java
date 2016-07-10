package org.vsfamily.vslib.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Base DAO implementation class, used for accessing data from the database. All the DAO classes of the
 * VSLib software are an extension of this class.
 * 
 */
public class VslibBaseDAOImpl implements VslibBaseDAO {
	
	private Session session;
	private PlatformTransactionManager txm;
	private SessionFactory sessionFactory;
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Gets the hibernate session used for accessing data from database repository.
	 * @return the hibernate session.
	 */
	public Session getSession(){
		return this.session;
	}
	
	/**
	 * Sets the hibernate session used for assessing data from database repository.
	 * @param session - the hibernate session
	 */
	public void setSession(Session session) {
		this.session = session;
	}

	/**
	 * Gets the transaction manager for database transactions.
	 * @return the transaction manager
	 */
	public PlatformTransactionManager getTxm() {
		return txm;
	}

	/**
	 * Sets the transaction manager for database transactions.
	 * @param txm - the transaction manager.
	 */
	@Autowired
	public void setTxm(PlatformTransactionManager txm) {
		this.txm = txm;
	}

	/**
	 * Sets the hibernate session factory.
	 * @param sessionFactory - the hibernate session factory.
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Gets the hibernate session factory.
	 * @return the hibernate session factory.
	 */
	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}

	@Override
	public boolean delete(Object obj) {
		Transaction tx = session.beginTransaction();
		boolean status = false;
		try {
			session.delete(obj);
			tx.commit();
			status = true;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			logger.info(e);
			System.out.println(e);
			status = false;
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return status;
	}

	@Override
	public boolean save(Object obj) {
		Transaction tx = session.beginTransaction();
		boolean status = false;
		try {
			session.save(obj);
			tx.commit();
			status = true;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			logger.info(e);
			System.out.println(e);
			status = false;
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return status;
	}

	@Override
	public boolean saveOrUpdate(Object obj) {
		Transaction tx = session.beginTransaction();
		boolean status = false;
		try {
			session.saveOrUpdate(obj);
			tx.commit();
			status = true;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			logger.info(e);
			System.out.println(e);
			status = false;
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return status;
	}

	@Override
	public boolean update(Object obj) {
		Transaction tx = session.beginTransaction();
		boolean status = false;
		try {
			session.update(obj);
			tx.commit();
			status = true;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			logger.info(e);
			System.out.println(e);
			status = false;
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return status;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getObjectByArg(Class<?> clazz, String arg, Object value) {
		Object obj = null;
		try {
			Criteria crit = session.createCriteria(clazz);
			crit.add(Restrictions.eq(arg, value));
			List list = crit.list();
			if (!list.isEmpty()) obj = list.get(0);
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
			obj = null;
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getObjectByArgTwo(Class<?> clazz, String arg, Object value, String argTwo, Object valueTwo) {
		Object obj = null;
		try {
			Criteria crit = session.createCriteria(clazz);
			crit.add(Restrictions.eq(arg, value))
				.add(Restrictions.eq(argTwo, valueTwo));
			List list = crit.list();
			if (!list.isEmpty()) obj = list.get(0);
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
			obj = null;
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return obj;
	}
	@Override
	public Object getObjectByCode(Class<?> clazz, String code) {
		Object obj = null;
		try {
			obj = this.session.get(clazz, code);
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
			obj = null;
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return obj;
	}

	@Override
	public Object getObjectById(Class<?> clazz, Long id) {
		Object obj = null;
		try {
			obj = this.session.get(clazz, id);
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
			obj = null;
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> listObject(Class<?> className) {
		List<Object> listObject = new ArrayList<Object>();

		try {			
			Criteria crit = session.createCriteria(className);
			listObject = crit.list();
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return listObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> listObjectSorted(Class<?> className, String sortBy,
			String sortOrder) {
		List<Object> listObject = new ArrayList<Object>();

		try {
			Criteria crit = session.createCriteria(className);
			if (sortOrder.equals("asc")) {				
				crit.addOrder(Order.asc(sortBy));
			} else {
				crit.addOrder(Order.desc(sortBy));
			}
			listObject = crit.list();
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return listObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> listObjectSortedTwo(Class<?> className, String sortBy,
			String sortOrder, String sortByTwo, String sortOrderTwo) {
		List<Object> listObject = new ArrayList<Object>();

		try {
			Criteria crit = session.createCriteria(className);
			if (sortOrder.equals("asc")) {				
				crit.addOrder(Order.asc(sortBy));
			} else {
				crit.addOrder(Order.desc(sortBy));
			}
			if (sortOrderTwo.equals("asc")) {				
				crit.addOrder(Order.asc(sortByTwo));
			} else {
				crit.addOrder(Order.desc(sortByTwo));
			}
			listObject = crit.list();
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return listObject;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<?> listObjectSorted(Class<?> className, String sortBy,
			String sortOrder, int firstResult, int maxResults) {
		List<Object> listObject = new ArrayList<Object>();

		try {
			if (sortOrder.equals("asc")) {
				Criteria crit = session.createCriteria(className);
				
				crit.addOrder(Order.asc(sortBy));
				
				crit.setFirstResult(firstResult)
					.setFetchSize(maxResults);
				
				listObject = crit.list();
			} else {
				Criteria crit = session.createCriteria(className);
				
				crit.addOrder(Order.desc(sortBy));
				
				crit.setFirstResult(firstResult)
					.setFetchSize(maxResults);
				
				listObject = crit.list();
			}
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			session.close();
			session = this.sessionFactory.openSession();
		}
		return listObject;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<?> listObjectArg(Class<?> className, String arg, Object value) {
		List<Object> list = new ArrayList<Object>();
		try {
			Criteria crit = session.createCriteria(className);
			crit.add(Restrictions.eq(arg, value));
			list = crit.list();
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> listObjectArgSorted(Class<?> className, String arg,
			Object value, String sortBy, String sortOrder) {
		List<Object> listObject = new ArrayList<Object>();

		try {
			Criteria crit = session.createCriteria(className);
			crit.add(Restrictions.eq(arg, value));
			if (sortOrder.equals("asc")) {
				crit.addOrder(Order.asc(sortBy));
			} else {
				crit.addOrder(Order.desc(sortBy));
			}
			listObject = crit.list();
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return listObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> listObjectArgSortedTwo(Class<?> className, String arg,
			Object value, String sortBy, String sortOrder, String sortByTwo, String sortOrderTwo) {
		List<Object> listObject = new ArrayList<Object>();

		try {
			Criteria crit = session.createCriteria(className);
			crit.add(Restrictions.eq(arg, value));
			if (sortOrder.equals("asc")) {
				crit.addOrder(Order.asc(sortBy));
			} else {
				crit.addOrder(Order.desc(sortBy));
			}
			if (sortOrderTwo.equals("asc")) {
				crit.addOrder(Order.asc(sortByTwo));
			} else {
				crit.addOrder(Order.desc(sortByTwo));
			}
			listObject = crit.list();
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return listObject;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<?> listObjectArgSorted(Class<?> className, String arg,
			Object value, String sortBy, String sortOrder, int firstResult,
			int maxResults) {
		List<Object> listObject = new ArrayList<Object>();

		try {
			Criteria crit = session.createCriteria(className);
			crit.add(Restrictions.eq(arg, value));
			if (sortOrder.equals("asc")) {
				crit.addOrder(Order.asc(sortBy));
			} else {
				crit.addOrder(Order.desc(sortBy));				
			}
			crit.setFirstResult(firstResult)
				.setFetchSize(maxResults);
			listObject = crit.list();
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			session.close();
			session = sessionFactory.openSession();
		}
		return listObject;
	}
}
