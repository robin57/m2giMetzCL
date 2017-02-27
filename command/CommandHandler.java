package command;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandHandler{
	
	private Map<String, Command> commandList;
	
	public CommandHandler(){
		this.commandList = new HashMap<String, Command>();
	}
	
	public void add(String cmdName, Command cmd){
		if (!this.commandList.containsKey(cmdName)){
			this.commandList.put(cmdName, cmd);
		}
	}
	
	public void handle(String str){
		Pattern pattern = Pattern.compile("^#([a-zA-Z0-9_]+)(\\[(.+)\\])?");
		Matcher matcher = pattern.matcher(str);
		
		if (matcher.matches()) {	
			String cmdName = matcher.group(1);
			String[] args = (matcher.group(3) != null) ? matcher.group(3).split(";") : null;
			
			if (this.commandList.containsKey(cmdName)){
				this.commandList.get(cmdName).run(args);
			}
		}
	}
}
