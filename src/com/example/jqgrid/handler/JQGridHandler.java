package com.example.jqgrid.handler;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.jqgrid.dto.JQGridDTO;
import com.example.jqgrid.dto.SuperHeroDTO;

/**
 * The handler class used to fetch the data required.
 * 
 * @author Dinuka Arseculeratne
 *
 */
public class JQGridHandler {

	/**
	 * This method will fetch the super hero list. Of course i have mixed and
	 * matched DC and Marvel in order to keep peace on the universe.
	 * 
	 * @return
	 */
	public JQGridDTO<SuperHeroDTO> loadSuperHeroes(final HttpServletRequest req) {
		/**
		 * The page and rows are sent from the JQGrid component with the Ajax
		 * query.
		 * 
		 */
		int page = Integer.valueOf(req.getParameter("page")).intValue();
		int pageSize = Integer.valueOf(req.getParameter("rows")).intValue();

		/**
		 * I am not using the star index and end index in this case, but in an
		 * ideal situation, you will be passing the start and end index to your
		 * pagination SQL query.
		 * 
		 */
		int startIndex = page == 1 ? 0 : (pageSize * (page - 1));
		int endIndex = page == 1 ? pageSize : pageSize * page;
		int total = -1;

		JQGridDTO<SuperHeroDTO> jqGridData = new JQGridDTO<SuperHeroDTO>();
		List<SuperHeroDTO> superHeroList = new LinkedList<SuperHeroDTO>();
		SuperHeroDTO flash = new SuperHeroDTO("Barry Allen", "Flash", "Super speed, Taping into the speed force");
		superHeroList.add(flash);

		SuperHeroDTO superMan = new SuperHeroDTO("Clark Kent", "Superman", "Flying, super speed");
		superHeroList.add(superMan);

		SuperHeroDTO batman = new SuperHeroDTO("Bruce Wayne", "Batman", "Cool toys, Intelligence");
		superHeroList.add(batman);

		SuperHeroDTO professorX = new SuperHeroDTO("Professor Xavier", "Professor X", "Mind control");
		superHeroList.add(professorX);

		/**
		 * The total in the ideal situation would be the count of the records of
		 * your SQL query from the table you want to fetch data from.
		 * 
		 */
		total = superHeroList.size();

		jqGridData.setPage(page);
		jqGridData.setTotal(String.valueOf(Math.ceil((double) total / pageSize)));
		jqGridData.setRecords(String.valueOf(total));
		jqGridData.setRows(superHeroList);
		return jqGridData;
	}
}
