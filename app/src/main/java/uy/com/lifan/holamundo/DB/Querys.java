package uy.com.lifan.holamundo.DB;

public class Querys {

    //Clase que agrupa todas las sentencias SQL usadas en la app, par auna ms facil modificacion.

    public static final String  USUARIOS_ACTIVOS  = "SELECT value FROM adempiere.ad_user ";

    public static final String  QRY_LOCATIONS  = "SELECT * FROM android.lifan_android_locations ";
    public static final String  INSERT_LOCATION  = "INSERT INTO android.lifan_android_locations (location_id, vin, latitud, longitud, ad_org_id, ad_client_id, isactive, created, createdby, updated, updatedby, islast) VALUES (NEXTID(2100480,'N'), '%s', %f, %f, 2100002, 2100001,'Y', now(), 2100265, now(), 2100265, 'Y'); ";


 //   "INSERT INTO usuario (nome, email, telefone) VALUES ('%s','%s','%s')

}
