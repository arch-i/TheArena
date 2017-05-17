
public class Arena {
	public static void main(String args[]){
		String token1 = args[0], token2 = args[1];
		GHUser user1 = GHUser.getUser(token1);
		GHUser user2 = GHUser.getUser(token2);
		String login1 = user1.login;
		String login2 = user2.login;
		Repo[] repo1 = Repo.getRepos(login1);
		Repo[] repo2 = Repo.getRepos(login2);
		new PrintUser(repo1,"A");
		new PrintUser(repo2,"B");
	}

}
