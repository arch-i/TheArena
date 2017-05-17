import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Repo {
	String full_name, language;
	boolean fork;
	int stargazers_count, forks_count;
	
	public static Repo[] getRepos(String login){
		try{
			URL url = new URL("https://api.github.com/users/"+login+"/repos");
		    HttpURLConnection con = (HttpURLConnection)url.openConnection();
		    InputStream is = con.getInputStream();
		    Gson gson = new Gson();
		    Repo[] repo = gson.fromJson(new InputStreamReader(is), Repo[].class);
		    return repo;
		}catch(Exception e){System.out.println("No Repos Found");}
		return new Repo[0];
	}
	public int getStars(){
		return stargazers_count;
	}
	
	public int getForks(){
		return forks_count;
	}

}
