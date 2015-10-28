package businessLayer;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CreditHome;
import dao.UserHome;
import dto.Credit;
import dto.User;


public class CreditProcessorImp implements CreditProcessor{

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private CreditHome creditHome = new CreditHome();
	private UserHome userHome = new UserHome();
	@Override
	public float checkSerial(String serial) {
		// TODO Auto-generated method stub
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		
		Credit instance= creditHome.findById(serial);
		
		if(instance==null ||instance.isUsed()) {return -1;}
			
		else {
			
			instance.setUsed(true);
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			tx.commit();
			
			return instance.getValue();
		}
	}

	@Override
	public float updateCredit(float value,User user) {
		// TODO Auto-generated method stub
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		float newCredit =user.getCredit()+value;
		user.setCredit(newCredit);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		//float updatedCredit=userHome.updateCredit(value, email);
		
		tx.commit();
		return newCredit;
	}
	@Override
	public void addSerial(String serial, int value) {
		// TODO Auto-generated method stub
		Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		Credit cr=new Credit();
		cr.setSerial(serial);
		cr.setUsed(false);
		cr.setValue(value);
		sessionFactory.getCurrentSession().save(cr);
		tx.commit();
		
		
	}

}
