
public class PrintUser {
	
	PrintUser(Repo[] repo, String name){//prints the user's repo details with its name
		int totalC=0, lastWeek=0;// totalC = total commits of a user //lastWeek = last week's repo
		System.out.println("User "+name+":\n\t Total Repos: "+repo.length);//prints total owned repos
		for(int i=0;i<repo.length;i++){//prints details of each repo
			System.out.println("\t\t Repo "+(i+1)+": Stars - "+repo[i].getStars()+", Forks - "+repo[i].getForks());// prints Stars, Forks
			Commits commits = Commits.getCommits(repo[i]);
			int repoC = commits.getTotal();//total commits of a repo
			totalC = totalC + repoC;//totaling commits for all repos
			lastWeek = lastWeek + commits.getLastWeeks();//totalling last week's commits for all repo 
			if(repo[i].fork==true){//if forked
				System.out.print(", Commits - "+repoC);//prints commits done in that repo
			}
		}
		System.out.println("\t Total Commits: "+totalC);//prints total commits by the user (in its repos)
		System.out.println("\t Last Week's Commits: "+lastWeek);//prints total last week's commits (in its repos)
		System.out.println("\t Most active programming language: "+Language.getLanguage(repo));//prints most used language
	}

}
