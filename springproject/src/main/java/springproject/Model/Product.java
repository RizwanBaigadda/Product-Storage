package springproject.Model;

import java.util.Random;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private int pid;
	private String name ;
	private String description;
    private long price;
    
    public Product() {
	
    	this.pid = generaterandon();
	}
    
    public int generaterandon() {
    	Random r = new Random();
    	return r.nextInt(1000);
    }
    
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
	public Product(int pid, String name, String description, long price) {
		super();
		this.pid = pid;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
    

}
