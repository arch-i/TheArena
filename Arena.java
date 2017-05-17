
public class Arena {
	public static void main(String args[]){
		String token1 = args[0], token2 = args[1];//storing inputs
		GHUser user1 = GHUser.getUser(token1);//creating users from tokens
		GHUser user2 = GHUser.getUser(token2);
		String login1 = user1.login;//getting their user-id
		String login2 = user2.login;
		Repo[] repo1 = Repo.getRepos(login1);//getting the list of repos of the user
		Repo[] repo2 = Repo.getRepos(login2);
		new PrintUser(repo1,"A");//printing stuff for the user
		new PrintUser(repo2,"B");
	}

}
