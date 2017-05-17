
public class PrintUser {
	
	PrintUser(Repo[] repo, String name){
		int totalC=0, lastWeek=0;
		System.out.println("User "+name+":\n\t Total Repos: "+repo.length);
		for(int i=0;i<repo.length;i++){
			System.out.println("\t\t Repo "+(i+1)+": Stars - "+repo[i].getStars()+", Forks - "+repo[i].getForks());
			Commits commits = Commits.getCommits(repo[i]);
			int repoC = commits.getTotal();
			totalC = totalC + repoC;
			lastWeek = lastWeek + commits.getLastWeeks();
			if(repo[i].fork==true){
				System.out.print(", Commits - "+repoC);
			}
		}
		System.out.println("\t Total Commits: "+totalC);
		System.out.println("\t Last Week's Commits: "+lastWeek);
		System.out.println("\t Most active programming language: "+Language.getLanguage(repo));
	}

}
