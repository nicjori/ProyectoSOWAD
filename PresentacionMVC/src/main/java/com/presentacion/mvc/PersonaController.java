package com.presentacion.mvc;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ent.Comun.*;
import com.ent.Seguridad.SEG_UsuarioEnt;
import com.log.Comun.*;
import com.log.Seguridad.SEG_UsuarioLog;

@Controller
public class PersonaController {
	
	@RequestMapping(value = "/Persona/NuevoPersona", method = RequestMethod.GET)
	public ModelAndView Nuevo(Locale locale, Model model) {		
		return new ModelAndView("NuevoPersona", "command", new CMM_PersonaEnt());
	}

	@RequestMapping(value = "/Persona/NuevoPersona", method = RequestMethod.POST)
	public String GuardaPersona(@ModelAttribute("SpringWeb")CMM_PersonaEnt p, 
										ModelMap model) {
		try {
			boolean inserto = CMM_PersonaLog.Instancia().InsertarPersona(p, "XYZ");
			return "redirect:/RegistroUsuario";
		} catch (Exception e) {
			return "frmError";
		}
	}
	
	@RequestMapping(value = "/Persona/EditarPersona", method = RequestMethod.GET)
	public ModelAndView EditarPersona(HttpServletRequest request) {
		try {
			//request es lo que llega y response es lo quesa le
			//capturamos el parametro editar
			//<td><a href="${pageContext.request.contextPath}/Persona/EditarPersona?id=${persona.idPersona}&nombre?=${persona.idPersona}">Editar</a></td>
			int idPersona=Integer.parseInt(request.getParameter("id"));
			
			CMM_PersonaEnt p=CMM_PersonaLog.Instancia().DevolverPersona(idPersona);
			ModelAndView model= new ModelAndView("/crudPersona/frmEditarPersona");
			model.addObject("command",p);
			return model;				
		} catch (Exception e) {
			return new ModelAndView("frmError","error",e.getMessage());
		}
	}
	
	@RequestMapping(value = "/Persona/EditarPersona", method = RequestMethod.POST)
	public ModelAndView EditarPersona(@ModelAttribute CMM_PersonaEnt p) {
		try {
			CMM_PersonaLog.Instancia().EditarPersona(p,"xy");
			return new ModelAndView("redirect:..//RegistroUsuario?msj='se inserto la persona'");
		}catch(Exception e){
			return new ModelAndView("frmError","error",e.getMessage());
		}
	}
}
