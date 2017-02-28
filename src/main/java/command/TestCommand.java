package command;

import java.util.Arrays;

public class TestCommand extends Command{
	public void run(String[] args){
		if (args != null)
			System.out.println("args:" + Arrays.toString(args));
	}
}
