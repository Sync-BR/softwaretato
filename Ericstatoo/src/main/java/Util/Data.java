/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Eduar
 */
public class Data {
    public static void datanascimento(String novadata){
        Date nascimento = new Date(0);
        @SuppressWarnings("deprecation")
		Locale brasil = new Locale("pt","BR");
        SimpleDateFormat formatodate = new SimpleDateFormat ("y-MM-dd", brasil);
        @SuppressWarnings("unused")
		String NovaData = formatodate.format(nascimento);
     
    
    }
}
