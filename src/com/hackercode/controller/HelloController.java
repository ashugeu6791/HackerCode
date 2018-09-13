package com.hackercode.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hackercode.constants.Constants;
import com.hackercode.dao.AdminDao;
import com.hackercode.daoimpl.AdminDaoImpl;
import com.hackercode.daoimpl.CommonDaoImpl;
import com.hackercode.services.CommonServiceImpl;
import com.hackercode.structures.Admin;
import com.hackercode.util.Util;


@Controller
public class HelloController extends AbstractController{
	
	
	
	private ModelAndView modelandview;
	
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub

    	ApplicationContext context = 
    	    		new ClassPathXmlApplicationContext("Beans.xml");
    	AdminDaoImpl dao=(AdminDaoImpl)context.getBean("adminDao"); 
    	CommonDaoImpl cdao = (CommonDaoImpl)context.getBean("commonDao");
    	modelandview = new ModelAndView("hello");
    	return modelandview;
    	//	System.out.println("Our DataSource is = " + dataSource);
    /*	String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        pass = Util.covertToMd5(pass);
        try{
        	Boolean userExists =   cdao.isUserExists(email, pass);  //checkUserPresent(email,pass);
        	if(userExists.equals(Constants.FALSE)){
        		return wrongUserPass();
        	}
        /*	Admin user = CommonServiceImpl.getUser(email);
        	String userType = user.getUserType();
        	if(userType.equals(Constants.ADMIN)){	
        		return setAdminSpecificData(user);
        	}
        	else if(userType.equals(Constants.STUDENT)){
        		 return setStudentSpecificData();
        	}*/
      //  }
   /*     catch(Exception e){
        	System.out.println("Cannot find the user "+e);
        }
        
		return modelandview;*/
		//return null;
	}
   
	
	/*public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
    	
    	ApplicationContext context = 
    	    		new ClassPathXmlApplicationContext("Beans.xml");
    	AdminDaoImpl dao=(AdminDaoImpl)context.getBean("adminDao"); 
    	CommonDaoImpl cdao = (CommonDaoImpl)context.getBean("commonDao");
    	modelandview = new ModelAndView("hello");
    	return modelandview;*/
    	/*String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        pass = Util.covertToMd5(pass);
        try{
        	Boolean userExists =   cdao.isUserExists(email, pass);  //checkUserPresent(email,pass);
        	if(userExists.equals(Constants.FALSE)){
        		return wrongUserPass();
        	}
        	Admin user = CommonServiceImpl.getUser(email);
        	String userType = user.getUserType();
        	if(userType.equals(Constants.ADMIN)){	
        		return setAdminSpecificData(user);
        	}
        	else if(userType.equals(Constants.STUDENT)){
        		 return setStudentSpecificData();
        	}
        }
       catch(Exception e){
        	System.out.println("Cannot find the user "+e);
        }
        
		return modelandview;*/
   // }
    
    boolean checkUserPresent(String email, String pass){
    	return CommonServiceImpl.isUserExists(email, pass);
    }
    
    private ModelAndView wrongUserPass() {
		// TODO Auto-generated method stub
    	modelandview = new ModelAndView("login_failed");
		modelandview.addObject(Constants.WRONG_USERNAME_PASSWORD, Constants.FALSE);
		
		return modelandview;
	}
    
    
    private ModelAndView setAdminSpecificData(Admin user) {
		// TODO Auto-generated method stub
    	/*
    	user = AdminServiceImpl.getUserDetail(user.getEmail());
		statBox = (List<StatBox>) StatBoxServiceImpl.getStatBoxDetails(user.getId());
		modelandview = new ModelAndView("admin_home");
		modelandview.addObject(Constants.USER,user.getId());
		Util.setParameters(modelandview,Admin);
		Util.setStatBoxParameters(modelandview, statBox);*/
		//commonDao.setLastLogin(user.getId());
		return modelandview;
	}
	
	/*public String printHello(ModelMap model) {
	    model.addAttribute("message", "Hello Spring MVC Framework!");
	    return "hello";
	 }*/

	
	private ModelAndView setStudentSpecificData() {
		// TODO Auto-generated method stub
    	modelandview =new ModelAndView("admin_data");
		return modelandview;
	}

	





}