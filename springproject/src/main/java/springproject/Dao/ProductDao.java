package springproject.Dao;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import springproject.Model.Product;

@Component
public class ProductDao {

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createproduct(Product product) {	
		this.hibernateTemplate.saveOrUpdate(product);
		
	}
	
	  public Product getproduct(int num) {  
	  return this.hibernateTemplate.get(Product.class, num);
	  
	  }
		  
	public List<Product> allproducts(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	@Transactional
	public void deleteproduct(int pid) {		
		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
	}
	
}
