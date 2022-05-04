package cluestrategymanager;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ClueStrategyManagerPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ClueStrategyManagerPlugin.class);
		RuneLite.main(args);
	}
}