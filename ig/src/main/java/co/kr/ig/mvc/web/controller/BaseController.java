package co.kr.ig.mvc.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.ig.mvc.web.service.impl.BaseServiceImpl;


@Controller
public class BaseController {

	@Autowired
	BaseServiceImpl commonService;

	@RequestMapping(value="/")
	public String welcome(Model model) {

		return "index";
	}

	@RequestMapping(value="/base", method = RequestMethod.GET)
	public String service(Model model) throws SQLException {
		List<HashMap<String, Object>> output = new ArrayList<HashMap<String, Object>>();

		List<HashMap<String, Object>> listBase = commonService.select("COMM.R_testData", new HashMap<String, Object>());
		List<HashMap<String, Object>> listOrcl = commonService.select("orclMapper", "COMM.R_testData", new HashMap<String, Object>());
		List<HashMap<String, Object>> listMysql = commonService.select("mysqlMapper", "COMM.R_testData", new HashMap<String, Object>());
		List<HashMap<String, Object>> listMaria = commonService.select("mariaMapper", "COMM.R_testData", new HashMap<String, Object>());
		
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("BASE_DATA", listBase.get(0).get("TEST_DATA").toString());
		map.put("ORCL_DATA", listOrcl.get(0).get("TEST_DATA").toString());
		map.put("MYSQL_DATA", listMysql.get(0).get("TEST_DATA").toString());
		map.put("MARIA_DATA", listMaria.get(0).get("TEST_DATA").toString());

		output.add(0, map);
		

		model.addAttribute("list", output);
		return "base";
	}
}
