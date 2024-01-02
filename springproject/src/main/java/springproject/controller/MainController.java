package springproject.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import springproject.Dao.ProductDao;
import springproject.Model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productdao;

	@RequestMapping("/")
	public String home(Model m) {

		List<Product> products = productdao.allproducts();
		m.addAttribute("products", products);

		return "index";
	}

	@RequestMapping("/add-product")
	public String add(Model m) {

		m.addAttribute("title", "Add Product");

		return "add_product";
	}

	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView Addhandle(@ModelAttribute Product product1, HttpServletRequest req) {
		System.out.println(product1);
		productdao.createproduct(product1);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping(value = "/deleteproduct/{productid}")
	public RedirectView deleteproduct(@PathVariable("productid") int productid, HttpServletRequest req) {
		productdao.deleteproduct(productid);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping(value = "/updateproduct/{productid}")
	public String updateproduct(@PathVariable("productid") int productid, Model model) {
		Product product = this.productdao.getproduct(productid);
		model.addAttribute("product", product);

		return "update_product";
	}

}
