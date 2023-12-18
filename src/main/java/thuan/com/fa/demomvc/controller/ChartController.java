package thuan.com.fa.demomvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thuan.com.fa.demomvc.entity.Product;
import thuan.com.fa.demomvc.service.ProductServiceImpl;

@Controller
@RequestMapping("/chart")
public class ChartController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@GetMapping("/product")
	public String getAllProductWithPageAble(Model model) {
		List<Product> all = productServiceImpl.findAll();
		Map<Object, Object> map = null;
		List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
		List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();
		for (Product p : all) {
			map = new HashMap<Object, Object>();
			map.put("label", p.getName());
			map.put("y", p.getQuantity());
			dataPoints1.add(map);
		}
		list.add(dataPoints1);
		model.addAttribute("dataPointsList", list);
		return "/chart/product";
	}
}
