package com.imagineage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings({"serial"})
@WebServlet("/input")
public class BillingServlet extends HttpServlet{
	List<BillModel> ls=new ArrayList<BillModel>();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String val=req.getParameter("sub");
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		HttpSession hs=req.getSession();
		if(val.equals("Add"))
		{
			BillModel bm=new BillModel();
			bm.setId(req.getParameter("id"));
			bm.setIname(req.getParameter("iname"));
			bm.setIprice(Double.parseDouble(req.getParameter("iprice")));
			bm.setIqty(Double.parseDouble(req.getParameter("iqty")));
			bm.setTotal(Double.parseDouble(req.getParameter("iprice"))*Double.parseDouble(req.getParameter("iqty")));
			ls.add(bm);
			hs.setAttribute("Items", ls);
			RequestDispatcher rd=req.getRequestDispatcher("Bill_IN.jsp");
			rd.forward(req, resp);
			System.out.println("Added"+ls.size());
		}else if(ls.size()>1)
		{
			double gtotal=0.0;
			ArrayList<BillModel> sesbm=(ArrayList)hs.getAttribute("Items");
			for(BillModel mb:sesbm)
			{
				gtotal=gtotal+mb.getTotal();
				pw.println(mb);
			}
			pw.println(gtotal);
		}else
		{
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("iname");
			double price=Double.parseDouble(req.getParameter("iprice"));
			double qty=Double.parseDouble(req.getParameter("iqty"));
			double tot=price*qty;
			pw.println("ID : "+id);
			pw.println("Name : "+name);
			pw.println("Price : "+price);
			pw.println("Quantity : "+qty);
			pw.println("Total : "+tot);
		}
	}
}
