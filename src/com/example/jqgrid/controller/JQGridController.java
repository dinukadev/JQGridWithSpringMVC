package com.example.jqgrid.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.jqgrid.common.util.JsonUtil;
import com.example.jqgrid.dto.JQGridDTO;
import com.example.jqgrid.dto.SuperHeroDTO;
import com.example.jqgrid.handler.JQGridHandler;

/**
 * This class acts as the controller for JQGrid related functionality.
 * 
 * @author Dinuka Arseculeratne
 * 
 */
@Controller
public class JQGridController {

	/**
	 * This method will display the page used to display the grid.
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, path = "/jqGridExample")
	public String jqGrid(HttpServletRequest req, HttpServletResponse res) {
		String forward = "jqgrid/jqGridData";

		return forward;
	}

	/**
	 * This method will handle fetching data required for the JQGrid.
	 * 
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, path = "/loadData")
	public String loadData(HttpServletRequest req, HttpServletResponse res) {
		String forward = "common/formData";

		JQGridDTO<SuperHeroDTO> gridData = new JQGridHandler().loadSuperHeroes(req);
		req.setAttribute("formData", JsonUtil.toJsonObj(gridData));
		return forward;
	}

}
