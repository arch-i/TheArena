import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Commits {
	int owner[];
	
	public static Commits getCommits(Repo repo){
		String path = repo.full_name;
		try{
			URL url = new URL("https://api.github.com/repos/"+path+"/stats/participation");
		    HttpURLConnection con = (HttpURLConnection)url.openConnection();
		    InputStream is = con.getInputStream();
		    Gson gson = new Gson();
		    Commits commits = gson.fromJson(new InputStreamReader(is), Commits.class);
		    return commits;
		}catch(Exception e){System.out.println("No Commits");}
		return new Commits();
	}
	
	public int getTotal(){
		int sum = 0;
		for(int i=0;i<52;i++){
			sum = sum + owner[i];
		}
		return sum;
	}
	
	public int getLastWeeks(){
		return owner[51];
	}

}
