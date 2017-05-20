
public class Language {//keeps the record of number of times (count) a particular language has been used
	String lang;
	int count;
	public static String getLanguage(Repo[] repo){// returns the most used programming language in the repo list
		Language[] l= new Language[100];//an array of null languages 
		for(int j=0;j<100;j++){
			l[j] = new Language();
			l[j].lang=null;
			l[j].count=0;
		}
		
		for(int i=0;i<(repo.length);i++){
			String nextL = repo[i].language;// nextL = language of ith repo
			if(nextL==null){
				continue;
			}
			int j=0;
			while(nextL!=(l[j].lang)&&l[j].lang!=null){//checks wether nextL matches with any previous Ls(l[j] languages)
				j++;
			}
			if(nextL==(l[j].lang)){// if match found then l[j]'s count is increased
				l[j].count++;
			}
			else{if(l[j].lang==null){// if no match found then nextL is alloted to jth Language
				l[j].lang = nextL;
				l[j].count = 1;
			}}
		}
		
		if(l[0].count==0){// no language found in any repo
			return null;
		}
		
		String mostL=null ;//= most used language
		int max=0;
		for(int i=0;i<l.length;i++){
			if(l[i].count>max){
				max = l[i].count;
				mostL = l[i].lang;
			}
			if(l[i].count==max){
				mostL = mostL+" and "+l[i].lang;
			}
		}
		return mostL;
	}

}
