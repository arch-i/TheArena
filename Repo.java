import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Repo {//representation of (json) repo api
	String full_name, language;
	boolean fork;
	int stargazers_count, forks_count;
	
	public static Repo[] getRepos(String login){//Creates Repo list (array) using login(user-id)
		try{
		    URL url = new URL("https://api.github.com/users/"+login+"/repos");//requesting repo list api
		    HttpURLConnection con = (HttpURLConnection)url.openConnection();
		    InputStream is = con.getInputStream();//json format
		    Gson gson = new Gson();
		    Repo[] repo = gson.fromJson(new InputStreamReader(is), Repo[].class);//Objects of Repos(list) from json
		    return repo;
		}catch(Exception e){System.out.println("No Repos Found");}
		return new Repo[0];
	}
	public int getStars(){//returns Stars on the repo
		return stargazers_count;
	}
	
	public int getForks(){//returns forks on the repo
		return forks_count;
	}

}
