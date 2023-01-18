package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(City.class)
				                 .buildSessionFactory();
		//Unit of Work (Session aslında unit of work tasarım deseni uygulanmış hali.)
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			//HQL Listeleme
			// World veritabanından ülkeleri sıralıyor
//			List<City> cities = session.createQuery("from City").getResultList();
			// World veritabanından ülke kodu TUR olan şehirler geliyor.
//			List<City> cities = session.createQuery("from City c where c.countryCode='TUR'").getResultList();
			// World veritabanından ülke kodu TUR veya USA olan şehirler yani Türkiye ve Amerikadaki şehir isimleri geliyor.
//			List<City> cities = session.createQuery("from City c where c.countryCode='TUR' OR c.countryCode='USA'").getResultList();
			// World veritabanından ülke kodu TUR ve bölgesi Ankara olan şehirler geliyor.
//			List<City> cities = session.createQuery("from City c where c.countryCode='TUR' AND c.district='Ankara'").getResultList();
			// World veritabanından içerisinde "kar" geçen şehirler geliyor.
//			List<City> cities = session.createQuery("from City c where c.name LIKE '%kar%'").getResultList();
			//World veritabanından şehirleri alfabetik sıraya göre sıralıyor.
			//(Defoult olarak ASC-Ascending-Yükselme ile geliyor. DSC-Descending- Alçalma yapıyor yani Z'den A'ya sıralıyor.)
//			List<City> cities = session.createQuery("from City c ORDER BY c.name").getResultList();
			//Eğer city üzerinden çalışıyorsak burası çalışacak.
//			for(City city : cities) {
//				System.out.println(city.getName());}
			//GROUP BY ile ülke kodlarını gruplamak istiyoruz. Burada tek bir kolon ve city değil countryCode ile çalışacağız.  
			
			/*List<String> countryCodes = session.createQuery("select c.countryCode from City c GROUP BY c.countryCode").getResultList();
			
			for(String countryCode : countryCodes) {
				System.out.println(countryCode);
			}*/
			//INSERT
			/*
			 * City city =new City(); city.setName("Düzce 1"); city.setCountryCode("TUR");
			 * city.setDistrict("Karadeniz"); city.setPopulation(100000);
			 * session.save(city);
			 */
			//UPDATE (4080 Düzce1'in ID'si)
			/*
			 * City city =session.get(City.class, 4080); city.setPopulation(110000);
			 * session.save(city);
			 */
			
			
			//DELETE (4080 Düzce1'in ID'si)
			City city =session.get(City.class, 4080);
			session.delete(city);
			
			session.getTransaction().commit();
			//System.out.println("Şehir eklendi.");
			//System.out.println("Şehir güncellendi.");
			System.out.println("Şehir silindi.");
			
			
		}
		finally {
			factory.close();
		}

	}

}
