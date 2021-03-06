package org.vsfamily.vslib.web.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.lucene.search.SortField;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Component;
import org.vsfamily.vslib.common.VslibBaseDAOImpl;
import org.vsfamily.vslib.common.domain.Article;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.common.domain.ErrorMessages;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.domain.ItemHold;
import org.vsfamily.vslib.common.domain.ItemReserve;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.common.domain.VslibParams;
import org.vsfamily.vslib.common.tools.VslibPaginate;
import org.vsfamily.vslib.forms.SimpleSearchForm;


@Component(value="vslibDAO")
public class VslibDAOImpl extends VslibBaseDAOImpl implements VslibDAO {
	
	
	@Override
	public boolean addDocumentItem(Document doc, Item item) {
		Transaction tx = this.getSession().beginTransaction();
		boolean status = false;
		try {
			this.getSession().save(doc);
			item.setDocument(doc);
			this.getSession().save(item);
			tx.commit();
			status = true;
		} catch (Exception e) {
			if (tx!=null) tx.rollback();
			logger.info(e);
			System.out.println(e);
			status = false;
		} finally {
			this.getSession().close();
			this.setSession(this.getSessionFactory().openSession());
		}
		return status;
	}

	@Override
	public void doDeleteErrorMessages() {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -15);
		try {
			Criteria crit = this.getSession().createCriteria(ErrorMessages.class);
			
			crit.add(Restrictions.lt("addDate", cal));
			
			List<?> list = crit.list();
			
			for(Object obj : list){
				ErrorMessages msg = (ErrorMessages) obj;
				this.getSession().delete(msg);
			}
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			this.getSession().close();
			this.setSession(this.getSessionFactory().openSession());
		}
	}

	@Override
	public VslibParams getVslibParams() {
		
		VslibParams vslibParams = null;
		
		try {
			
			Criteria crit = this.getSession().createCriteria(VslibParams.class);
			
			crit.addOrder(Order.desc("addDate"));
			
			List<?> list = crit.list();
			
			if (!list.isEmpty()){
				vslibParams = (VslibParams) list.get(0);
			}
			
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			this.getSession().close();
			this.setSession(this.getSessionFactory().openSession());
		}
		return vslibParams;
	}

	@Override
	public VslibPaginate listNewArrivals(int firstResult, int maxResults) {
		VslibPaginate page = new VslibPaginate();
		
		List<?> listObject = new ArrayList<Object>();
		
		page.setStartResult(firstResult);
		page.setMaxResult(maxResults);
		
		Calendar calStart = Calendar.getInstance();
		Calendar calEnd = Calendar.getInstance();
		calEnd.add(Calendar.DAY_OF_YEAR, -15);
		
		try {
			
			Criteria crit = this.getSession().createCriteria(Item.class);
			
			crit.add(Restrictions.le("addDate", calStart));
			crit.add(Restrictions.ge("addDate", calEnd));
						
			crit.setProjection(Projections.rowCount());
			
			page.setTotalResult(((Long)crit.uniqueResult()).intValue());
			
			Criteria crit1 = this.getSession().createCriteria(Item.class);
			
			crit1.add(Restrictions.le("addDate", calStart));
			crit1.add(Restrictions.ge("addDate", calEnd));
			crit1.createAlias("document", "doc");
			
			crit1.addOrder(Order.asc("doc.uniformTitle"));
			
			crit1.setFirstResult(firstResult);
			crit1.setMaxResults(maxResults);
			
			listObject = crit1.list();
			
			page.setListObject(listObject);
			
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			this.getSession().close();
			this.setSession(this.getSessionFactory().openSession());
		}
		return page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> listArticleHomePagePublished() {

		List<Article> listArticle = new ArrayList<Article>();
		
		try {
			
			Criteria crit = this.getSession().createCriteria(Article.class);
			
			crit.add(Restrictions.eq("homePage", true));
			crit.add(Restrictions.eq("published", true));
			
			crit.addOrder(Order.desc("addDate"));
			
			listArticle = (List<Article>) crit.list();
			
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			this.getSession().close();
			this.setSession(this.getSessionFactory().openSession());
		}
		return listArticle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> listArticlePublished(ArticleCategory category) {

		List<Article> listArticle = new ArrayList<Article>();
		
		try {
			
			Criteria crit = this.getSession().createCriteria(Article.class);
			
			crit.add(Restrictions.eq("category", category));
			crit.add(Restrictions.eq("published", true));
			
			crit.addOrder(Order.desc("addDate"));
			
			listArticle = (List<Article>) crit.list();
			
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			this.getSession().close();
			this.setSession(this.getSessionFactory().openSession());
		}
		return listArticle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemHold> listItemToReleaseHold() {

		List<ItemHold> listItemHold = new ArrayList<ItemHold>();
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		
		try {
			
			Criteria critItem = this.getSession().createCriteria(ItemHold.class);
			
			critItem.add(Restrictions.lt("holdReleaseDate", cal));
			
			listItemHold = (List<ItemHold>) critItem.list();
			
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			this.getSession().close();
			this.setSession(this.getSessionFactory().openSession());
		}
		return listItemHold;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemReserve> listItemToReleaseReserve() {

		List<ItemReserve> listItemReserve = new ArrayList<ItemReserve>();
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		
		try {
			
			Criteria critItem = this.getSession().createCriteria(ItemReserve.class);
			
			critItem.add(Restrictions.lt("reserveReleaseDate", cal));
			
			listItemReserve = (List<ItemReserve>) critItem.list();
			
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			this.getSession().close();
			this.setSession(this.getSessionFactory().openSession());
		}
		return listItemReserve;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> searchDocument(SimpleSearchForm ssf) {
		
		List<Document> listDocument = new ArrayList<Document>();

		try {
			
			List<Long> listItemDocument = new ArrayList<Long>();
			
			Criteria critItem = this.getSession().createCriteria(Item.class);
			
			critItem.add(Restrictions.disjunction()
					.add(Restrictions.ilike("barcodeNumber", ssf.getSearchString(), MatchMode.EXACT))
					.add(Restrictions.ilike("classNumber", ssf.getSearchString(), MatchMode.ANYWHERE)));
			
			List<Item> list = (List<Item>) critItem.list();
			
			for(Item item : list){
				listItemDocument.add(item.getDocument().getId());
			}
			
			Criteria crit = this.getSession().createCriteria(Document.class);
			
			if (listItemDocument.isEmpty()){
				crit.add(Restrictions.disjunction()
						.add(Restrictions.ilike("uniformTitle", ssf.getSearchString(), MatchMode.ANYWHERE))
						.add(Restrictions.ilike("primaryAuthor", ssf.getSearchString(), MatchMode.ANYWHERE))
						.add(Restrictions.ilike("isbn", ssf.getSearchString(), MatchMode.EXACT))
						.add(Restrictions.ilike("edition", ssf.getSearchString(), MatchMode.ANYWHERE))
						.add(Restrictions.ilike("publisher", ssf.getSearchString(), MatchMode.ANYWHERE))
						.add(Restrictions.ilike("seriesStatement", ssf.getSearchString(), MatchMode.ANYWHERE))
						);
			} else {
				crit.add(Restrictions.disjunction()
						.add(Restrictions.ilike("uniformTitle", ssf.getSearchString(), MatchMode.ANYWHERE))
						.add(Restrictions.ilike("primaryAuthor", ssf.getSearchString(), MatchMode.ANYWHERE))
						.add(Restrictions.ilike("isbn", ssf.getSearchString(), MatchMode.EXACT))
						.add(Restrictions.ilike("edition", ssf.getSearchString(), MatchMode.ANYWHERE))
						.add(Restrictions.ilike("publisher", ssf.getSearchString(), MatchMode.ANYWHERE))
						.add(Restrictions.ilike("seriesStatement", ssf.getSearchString(), MatchMode.ANYWHERE))
						.add(Restrictions.in("id", listItemDocument))
						);
			}
			
			crit.addOrder(Order.asc("uniformTitle"));
			crit.addOrder(Order.asc("primaryAuthor"));
			
			listDocument = crit.list();
			
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			this.getSession().close();
			this.setSession(this.getSessionFactory().openSession());
		}
		return listDocument;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> searchDocumentSimpleLucene(SimpleSearchForm ssf) {

        List<Document> result = new ArrayList<Document>();
        
        if (ssf.getSearchString()!=null && ssf.getSearchString().length()>=3){
        	
            FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());
            Transaction tx = fullTextSession.beginTransaction();

            try {
            	
            	QueryBuilder qb = fullTextSession.getSearchFactory()
                        .buildQueryBuilder().forEntity(Document.class).get();

                //org.apache.lucene.search.Query queryTitle = null;
            	
                org.apache.lucene.search.Query query = qb
                            .keyword()
                            .onFields("uniformTitle", "primaryAuthor", "secondaryAuthors", "isbn",
                            		"edition", "publicationYear", "publisher", "seriesStatement",
                            		"copyright", "summary", "keywords")
                            .matching(ssf.getSearchString())
                            .createQuery();

                boolean reverse = false;
                
                SortField sf = new SortField("uniformTitle", SortField.STRING, reverse);
                
                org.hibernate.Query hibQuery
                        = fullTextSession.createFullTextQuery(query, Document.class)
                        	.setSort(new org.apache.lucene.search.Sort(sf));

                result = (List<Document>) hibQuery.list();

                tx.commit();
            } catch (HibernateException e) {
            	logger.info(e);
                System.out.println(e);
            } catch (Exception e){
                //System.out.println(e);
            } finally {
                this.getSession().close();
                this.setSession(this.getSessionFactory().openSession());
            }
        }
        return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patron> searchPatron(SimpleSearchForm ssf) {

		List<Patron> listPatron = new ArrayList<Patron>();

		try {
			
			Criteria crit = this.getSession().createCriteria(Patron.class);
			
			crit.add(Restrictions.disjunction()
					.add(Restrictions.ilike("number", ssf.getSearchString(), MatchMode.EXACT))
					.add(Restrictions.ilike("firstName", ssf.getSearchString(), MatchMode.ANYWHERE))
					.add(Restrictions.ilike("middleName", ssf.getSearchString(), MatchMode.ANYWHERE))
					.add(Restrictions.ilike("lastName", ssf.getSearchString(), MatchMode.ANYWHERE)));
			
			crit.addOrder(Order.asc("number"));
			
			listPatron = (List<Patron>)crit.list();
			
		} catch (Exception e) {
			logger.info(e);
			System.out.println(e);
		} finally {
			this.getSession().close();
			this.setSession(this.getSessionFactory().openSession());
		}
		return listPatron;
	}
}
