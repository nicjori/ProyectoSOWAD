package com.ws.comun;

import java.util.ArrayList;

import com.ent.Comun.CMM_PersonaEnt;
import com.log.Comun.CMM_PersonaLog;

public class ws_comun {	
	public CMM_PersonaEnt[] listapersona() throws Exception{			
		 
		try{			
			ArrayList<CMM_PersonaEnt> lTareas = CMM_PersonaLog.Instancia().ListarPersona();
			CMM_PersonaEnt[] lTarea = new CMM_PersonaEnt[lTareas.size()];
			for(int i = 0;i < lTareas.size(); i++){
				lTarea[i] = (CMM_PersonaEnt)lTareas.get(i);
			}	
			return lTarea;
		}
		catch(Exception e){
			throw e;
		}
	}	
}