package org.gaming.Security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Passgenerator {
	 public static void main(String ...args) {
	        BCryptPasswordEncoder Crypt = new BCryptPasswordEncoder(4);
	        //El String que mandamos al metodo encode es el password que queremos encriptar.
		System.out.println(Crypt.encode("1234"));
	    }
	 
	 public String CrearContra(String clave)
	 {
		 BCryptPasswordEncoder Crypt = new BCryptPasswordEncoder(4);
		 String cla=Crypt.encode(clave);
		 return cla;
	 }
	}

