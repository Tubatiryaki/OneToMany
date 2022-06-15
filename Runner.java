package oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {

		Ulkeler ulke1=new Ulkeler();
		Ulkeler ulke2=new Ulkeler();
		
		ulke1.setId(100);
		ulke1.setName("Turiye");
		ulke1.setUlkeKodu(90);
		
		ulke2.setId(101);
		ulke2.setName("Almanya");
		ulke2.setUlkeKodu(49);
		
		Sehirler sehir1=new Sehirler();
		Sehirler sehir2=new Sehirler();
		Sehirler sehir3=new Sehirler();
		
		sehir1.setId(1000);
		sehir1.setName("Ýstanbul");
		sehir2.setPlaka("34");
		
		sehir2.setId(1001);
		sehir2.setName("Ankara");
		sehir2.setPlaka("06");
		
		
		sehir3.setId(1002);
		sehir3.setName("Berlin");
		sehir3.setPlaka("BGL");
		
		

	        //Configuration: yapýlandýrma
	        //

	       Configuration con=new Configuration().configure("hibernate.cfg.xml")
	    		   .addAnnotatedClass(Ulkeler.class).addAnnotatedClass(Sehirler.class);

	        SessionFactory sf=con.buildSessionFactory();
	        Session session=sf.openSession();

	        Transaction tx=session.beginTransaction();

	        session.save(ulke1);
	        session.save(ulke2);

	        session.save(sehir1);
	        session.save(sehir2);
	        session.save(sehir3);




	        tx.commit();
	        session.close();
	        sf.close();

	}

	private static void setId(int i) {
		// TODO Auto-generated method stub
		
	}

}
