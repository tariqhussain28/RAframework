package api.endpoints;

public class Routes 
{
// here we are maintaining only main url/ domain / base url / urlpart common in every url / no endpints
	
	 public static String base_url="https://petstore.swagger.io/v2";
	
	// User module
	
	 public static String userpost_url =base_url+"/user";
	 public static String userget_url =base_url+"/user/{username}";
	 public static String userput_url =base_url+"/user/{username}";
	 public static String userdelete_url =base_url+"/user/{username}";
	
	  
	// store module 
	 public static String petpost_url = base_url+"/store";
	 public static String petget_url =base_url+"/store/{}";
	 public static String petput_url =base_url+"/store/{}";
	 public static String petdelete_url =base_url+"/store{}";
	
	  
	// pet module   
			
	 public static String storepost_url =base_url+"/pet";
	 public static String storeget_url =base_url+"/pet/{}";
	 public static String storeput_url =base_url+"/pet/{}";
	 public static String storedelete_url =base_url+"/pet/{}";
	
	  
	 // like this we will update and add new module url will come here of all request 
	  
	  
	  
	  
	  
	  
	
	
	
}
