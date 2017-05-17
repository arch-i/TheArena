import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Commits {//keeps the record of a repo's weekly commit count (by the owner) 
	int owner[];//an array of commits per week (by the owner=user), for the past 52 weeks (length=52)
	
	public static Commits getCommits(Repo repo){//returns Commits(object) of the (passed) repo
		String path = repo.full_name; // = :owner/:repo
		try{
			URL url = new URL("https://api.github.com/repos/"+path+"/stats/participation");//requesting commit stat API 
		    HttpURLConnection con = (HttpURLConnection)url.openConnection();
		    InputStream is = con.getInputStream();//json format
		    Gson gson = new Gson();
		    Commits commits = gson.fromJson(new InputStreamReader(is), Commits.class);// json to a Commit object
		    return commits;
		}catch(Exception e){System.out.println("No Commits");}
		return new Commits();
	}
	
	public int getTotal(){// returns total commits by the owner (summed for past 52 weeks) on the repo
		int sum = 0;
		for(int i=0;i<52;i++){
			sum = sum + owner[i];
		}
		return sum;
	}
	
	public int getLastWeeks(){// returns last week's commits on the repo
		return owner[51];
	}

}
