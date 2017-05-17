import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class GHUser {
	protected String login;
    
    public static GHUser getUser(String token){
		try{
			URL url = new URL("https://api.github.com/user?access_token="+token);
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
