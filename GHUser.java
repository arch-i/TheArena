import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class GHUser {//Represents a GitHub User (object) definied by field login (user-id)
	protected String login;
	
    public static GHUser getUser(String token){// Creates(returns) user with the given token
		try{
			URL url = new URL("https://api.github.com/user?access_token="+token);//making request to the user profile API  
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			InputStream is = con.getInputStream();
			Gson gson = new Gson();
			GHUser user = gson.fromJson(new InputStreamReader(is), GHUser.class);
			return user;
		}catch(Exception e){System.out.println("invalid token:"+token);
		}
		return new GHUser();
	}
	
}
