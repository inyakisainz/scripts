package commands

import core.Command
import com.liferay.portal.kernel.util.PropertiesUtil
import com.liferay.portal.kernel.util.PropsUtil

class GetDiffPortalPropertiesCommand extends Command {

	public GetDiffPortalPropertiesCommand(boolean isCluster) {
		super("DiffPortalPropertiesCommand", isCluster);
	}
	
	public void execute() {
	
		result = PropertiesUtil.load(getClass().getClassLoader().getResourceAsStream("portal.properties"),"UTF-8")
		systemProp = PropsUtil.getProperties()
		
		//order properties
		
		Iterator itr2;
		TreeMap treeMap2 = new TreeMap(systemProp);
		itr2 = treeMap2.keySet().iterator();
		   while (itr2.hasNext()) {
				envKey = itr2.next();
				if (!result.getProperty(envKey).equals(systemProp.getProperty(envKey))) {
					addResult(envKey, systemProp.getProperty(envKey))
				}
		   }
	}
}
