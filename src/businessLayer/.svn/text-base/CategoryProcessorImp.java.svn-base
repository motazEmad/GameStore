package businessLayer;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CategoryHome;
import dto.Category;

public class CategoryProcessorImp implements CategoryProcessor {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private CategoryHome categoryhome = new CategoryHome();

	@Override
	public List getAllCategories() {
		sessionFactory.getCurrentSession().beginTransaction();
		return categoryhome.getAllCategories();
	}
	@Override
	public Category findById(int id) {
		sessionFactory.getCurrentSession().beginTransaction();
		return categoryhome.findById(id);
	}
	@Override
	public boolean addCategory(String catName) {
		// TODO Auto-generated method stub
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		boolean found =categoryhome.isFound(catName);
		if(found==true)
		{
			return false;
		}
		else
		{
		Category cat =new Category();
		cat.setName(catName);
		sessionFactory.getCurrentSession().save(cat);
		tx.commit();
			return true;
		}
	}
	@Override
	public boolean deleteCategory(String catName) {
		// TODO Auto-generated method stub
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		boolean found =categoryhome.isFound(catName);
		if(found==true)
		{
			Category cat=categoryhome.getByName(catName);
			sessionFactory.getCurrentSession().delete(cat);
			tx.commit();
			return true;
		}
		else
		{
			return false;	
		}
	
	}
}
