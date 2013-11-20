import core.builders.CommandBuilder
import core.resulthandlers.LiferayConsoleOutputHandler;
import com.liferay.portal.kernel.cluster.ClusterExecutorUtil;

out.print("Starting...");

// Dynamic determine if runnen on cluster or not
boolean isCluster=ClusterExecutorUtil.isEnabled();

cb = new CommandBuilder("https://raw.github.com/inyakisainz/scripts/master/symp-2013/", isCluster);
cb.appendCommand("commands/MemoryUsageCommand.groovy", "MemoryUsageCommand");
cb.appendCommand("commands/GetPortalImplManifestAttrsCommand.groovy", "GetPortalImplManifestAttrsCommand");
// Not all servers has free process. 
//cb.appendCommand("commands/GetMachineMemoryCommand.groovy", "GetMachineMemoryCommand");
cb.appendCommand("commands/GetJVMInfoCommand.groovy", "GetJVMInfoCommand");
cb.appendCommand("commands/GetCPUInfoCommand.groovy", "GetCPUInfoCommand");
cb.start(new LiferayConsoleOutputHandler(out));


