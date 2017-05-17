
public class Language {
	String lang;
	int count;
	public static String getLanguage(Repo[] repo){
		Language[] l= new Language[100];
		for(int j=0;j<100;j++){
			l[j] = new Language();
			l[j].lang=null;
			l[j].count=0;
		}
		String mostl=null ;
		int max=0;
		for(int i=0;i<(repo.length);i++){
			String nextl = repo[i].language;
			System.out.println(nextl);
			int j=0;
			while(nextl!=(l[j].lang)&&l[j].lang!=null){
				j++;
			}
			if(nextl!=null&&l[j].lang==null){
				l[j].lang = nextl;
				l[j].count = 1;
			}
			if(nextl==(l[j].lang)&&l[j].lang!=null){
				l[j].count++;
			}
		}
		if(l[0].count==0){
			return null;
		}
		for(int i=0;i<l.length;i++){
			if(l[i].count>max){
				max = l[i].count;
				mostl = l[i].lang;
			}
			if(l[i].count==max){
				mostl = mostl+" and "+l[i].lang;
			}
		}
		return mostl;
	}

}
