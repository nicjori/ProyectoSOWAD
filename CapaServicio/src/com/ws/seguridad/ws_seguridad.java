package com.ws.seguridad;

import com.ent.Seguridad.SEG_UsuarioEnt;
import com.log.Seguridad.SEG_UsuarioLog;

public class ws_seguridad {
	public int verificarAccesoEntero(String _Usuario, String _Passsword) throws Exception{
		try {
			SEG_UsuarioEnt u = SEG_UsuarioLog.Instancia().VerificarAcceso(_Usuario, _Passsword);
			if(u!=null){
				return 1;
			}else{
				return 0;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
    public SEG_UsuarioEnt verificarAcceso(String _Usuario, String _Passsword) throws Exception{
		try {
			return SEG_UsuarioLog.Instancia().VerificarAcceso(_Usuario, _Passsword);
		} catch (Exception e) {
			throw e;
		}
	}
 
}
